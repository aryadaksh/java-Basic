package com.snapdeal.constant;

public final class AppConstants {

    private AppConstants() {

    }

    // Database

    public static final String DB_PROPERTIES_FILE =
            "db.properties";

    // Audit

    public static final String CREATED_BY =
            "SYSTEM";

    public static final String UPDATED_BY =
            "SYSTEM";

    // Product

    public static final int MIN_QUANTITY =
            0;

    public static final int LOW_STOCK_LIMIT =
            10;

    // Customer

    public static final int MOBILE_LENGTH =
            10;

    // Messages

    public static final String CUSTOMER_ADDED =
            "Customer Added Successfully";

    public static final String CUSTOMER_UPDATED =
            "Customer Updated Successfully";

    public static final String CUSTOMER_DELETED =
            "Customer Deleted Successfully";

    public static final String PRODUCT_ADDED =
            "Product Added Successfully";

    public static final String PRODUCT_UPDATED =
            "Product Updated Successfully";

    public static final String PRODUCT_DELETED =
            "Product Deleted Successfully";

    public static final String ORDER_PLACED =
            "Order Placed Successfully";

    public static final String ORDER_CANCELLED =
            "Order Cancelled Successfully";

    public static final String NO_RECORD_FOUND =
            "No Record Found";

    public static final String INVALID_CHOICE =
            "Invalid Choice";

}