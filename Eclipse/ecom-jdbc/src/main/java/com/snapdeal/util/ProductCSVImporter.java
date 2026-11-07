package  com.snapdeal.util;


import java.io.BufferedReader;



import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.snapdeal.model.Product;
import com.snapdeal.service.ProductService;
import com.snapdeal.service.impl.ProductServiceImpl;

public class ProductCSVImporter {

    private static final int BATCH_SIZE = 1000;

    private static final String EXPECTED_HEADER =
            "product_name,category,price,quantity,brand";

    private final ProductService productService =
            new ProductServiceImpl();

    public void importProducts(String filePath) {

        int totalImported = 0;
        int batchNumber = 0;

        List<Product> batch = new ArrayList<>(BATCH_SIZE);

        System.out.println("Importing CSV from: " + filePath);

        try (BufferedReader br =
                     new BufferedReader(new FileReader(filePath))) {

            // Validate the header before processing rows
            String header = br.readLine();

            if (header == null) {
                throw new IllegalArgumentException(
                        "CSV file is empty.");
            }

            // Remove UTF-8 BOM if present
            header = header.replace("\uFEFF", "").trim();

            if (!EXPECTED_HEADER.equalsIgnoreCase(header)) {
                throw new IllegalArgumentException(
                        "Invalid CSV file or incorrect file path.\n"
                        + "Expected header: " + EXPECTED_HEADER
                        + "\nFound header: " + header);
            }

            String line;
            int lineNumber = 1;

            while ((line = br.readLine()) != null) {

                lineNumber++;

                if (line.trim().isEmpty()) {
                    continue;
                }

                if (line.trim().startsWith("<")
                        || line.contains("xmlns:xsi")) {
                    throw new IllegalArgumentException(
                            "XML content found at line "
                            + lineNumber
                            + ". Please select the correct CSV file.");
                }

                String[] data = line.split(",", -1);

                if (data.length != 5) {
                    throw new IllegalArgumentException(
                            "Invalid CSV row at line "
                            + lineNumber + ": " + line);
                }

                Product product = new Product();

                product.setProductName(data[0].trim());
                product.setCategory(data[1].trim());
                product.setPrice(
                        new BigDecimal(data[2].trim()));
                product.setQuantity(
                        Integer.parseInt(data[3].trim()));
                product.setBrand(data[4].trim());

                batch.add(product);

                if (batch.size() == BATCH_SIZE) {

                    productService.addProductsBatch(batch);

                    totalImported += batch.size();
                    batchNumber++;

                    System.out.println(
                            "Batch " + batchNumber
                            + " completed. Total imported: "
                            + totalImported);

                    batch.clear();
                }
            }

            // Insert the remaining products
            if (!batch.isEmpty()) {

                int remaining = batch.size();

                productService.addProductsBatch(batch);

                totalImported += remaining;
                batchNumber++;

                System.out.println(
                        "Final batch " + batchNumber
                        + " completed. Records: " + remaining);
            }

            System.out.println(
                    "Import completed. Total records: "
                    + totalImported);

        } catch (IOException | RuntimeException e) {

            System.err.println(
                    "Product import failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
}