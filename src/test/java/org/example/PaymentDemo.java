package org.example;
public class PaymentDemo {
    public static void main(String[] args) {
        // Reference of Payment interface pointing to CreditCard object
        Payment paymentMethod = new CreditCard();
        paymentMethod.processPayment(150.00);

        // Reference of Payment interface pointing to PayPal object
        paymentMethod = new PayPal();
        paymentMethod.processPayment(75.50);
    }
}