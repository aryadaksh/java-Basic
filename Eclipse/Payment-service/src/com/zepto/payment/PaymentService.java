package com.zepto.payment;

import com.zepto.order.Order;

public class PaymentService {

    public boolean makePayment(Order order) {

        System.out.println("Processing payment...");
        System.out.println("Order ID: " + order.getOrderId());
        System.out.println("Amount: ₹" + order.getAmount());
        System.out.println("Payment Method: "
                + order.getPaymentMethod());

        String method = order.getPaymentMethod();

        if (method.equalsIgnoreCase("UPI")) {
            return makeUpiPayment(order);
        }

        if (method.equalsIgnoreCase("CARD")) {
            return makeCardPayment(order);
        }

        if (method.equalsIgnoreCase("CASH")) {
            return makeCashPayment(order);
        }

        System.out.println("Invalid payment method!");
        return false;
    }

    private boolean makeUpiPayment(Order order) {

        System.out.println("Processing UPI payment...");
        System.out.println("UPI payment successful!");

        return true;
    }

    private boolean makeCardPayment(Order order) {

        System.out.println("Processing Card payment...");
        System.out.println("Card payment successful!");

        return true;
    }

    private boolean makeCashPayment(Order order) {

        System.out.println("Cash on delivery selected.");

        return true;
    }
}