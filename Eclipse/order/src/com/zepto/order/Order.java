package com.zepto.order;



public class Order {

    private int orderId;
    private String productName;
    private int quantity;
    private double amount;
    private String customerName;
    private String deliveryAddress;
    private String paymentMethod;
    private String deliveryType;

    public Order(
            int orderId,
            String productName,
            int quantity,
            double amount,
            String customerName,
            String deliveryAddress,
            String paymentMethod,
            String deliveryType) {

        this.orderId = orderId;
        this.productName = productName;
        this.quantity = quantity;
        this.amount = amount;
        this.customerName = customerName;
        this.deliveryAddress = deliveryAddress;
        this.paymentMethod = paymentMethod;
        this.deliveryType = deliveryType;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getAmount() {
        return amount;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    
    @Override
    public String toString() {
        return "\n" +
               "╔══════════════════════════════════════╗\n" +
               "║           ORDER DETAILS              ║\n" +
               "╠══════════════════════════════════════╣\n" +
               "║ Order ID       : " + orderId + "\n" +
               "║ Customer       : " + customerName + "\n" +
               "║ Product        : " + productName + "\n" +
               "║ Quantity       : " + quantity + "\n" +
               "║ Amount         : ₹" + amount + "\n" +
               "║ Payment        : " + paymentMethod + "\n" +
               "║ Delivery       : " + deliveryType + "\n" +
               "║ Address        : " + deliveryAddress + "\n" +
               "╚══════════════════════════════════════╝\n";
    }
}
