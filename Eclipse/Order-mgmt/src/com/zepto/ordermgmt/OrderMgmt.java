package com.zepto.ordermgmt;



import com.zepto.delivery.DeliveryService;
import com.zepto.inventoryservice.InventoryService;
import com.zepto.order.Order;
import com.zepto.payment.PaymentService;

public class OrderMgmt {

    private PaymentService paymentService;
    private DeliveryService deliveryService;
    private InventoryService inventoryService;

    public OrderMgmt(
            PaymentService paymentService,
            DeliveryService deliveryService,
            InventoryService inventoryService) {

        this.paymentService = paymentService;
        this.deliveryService = deliveryService;
        this.inventoryService = inventoryService;
    }

    public void createOrder(Order order) {

        System.out.println("================================");
        System.out.println("CREATING ORDER");
        System.out.println("================================");

        // 1. Check inventory
        boolean stockAvailable =
                inventoryService.checkStock(order);

        if (!stockAvailable) {
            System.out.println("Order failed: Product unavailable.");
            return;
        }

        // 2. Reserve inventory
        inventoryService.reserveStock(order);

        // 3. Make payment
        boolean paymentSuccess =
                paymentService.makePayment(order);

        if (!paymentSuccess) {
            System.out.println("Payment failed!");
            return;
        }

        // 4. Assign delivery
        boolean deliverySuccess;

        if (order.getDeliveryType()
                .equalsIgnoreCase("1-DAY")) {

            deliverySuccess =
                    deliveryService.oneDayDelivery(order);

        } else {

            deliverySuccess =
                    deliveryService.assignDelivery(order);
        }

        if (!deliverySuccess) {
            System.out.println("Delivery assignment failed!");
            return;
        }

        System.out.println("================================");
        System.out.println("ORDER CREATED SUCCESSFULLY");
        System.out.println("================================");
    }

    public static void main(String[] args) {

        PaymentService paymentService =
                new PaymentService();

        DeliveryService deliveryService =
                new DeliveryService();

        InventoryService inventoryService =
                new InventoryService();

        OrderMgmt orderMgmt =
                new OrderMgmt(
                        paymentService,
                        deliveryService,
                        inventoryService
                );

        Order order = new Order(
                101,
                "Laptop",
                2,
                150000,
                "Rahul",
                "Bangalore",
                "UPI",
                "1-DAY"
        );

        orderMgmt.createOrder(order);
    }
}