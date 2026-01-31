package org.example.behavioral.template_method;

public class Main {
    public static void main(String[] args) {
        PaymentProcessor payment = new CreditCardPayment();
        payment.processPayment(250.00);
        System.out.println("---------------------------");

        payment = new PayPalPayment();
        payment.processPayment(250.00);
        System.out.println("---------------------------");

        payment = new BankTransferPayment();
        payment.processPayment(250.00);
    }
}
