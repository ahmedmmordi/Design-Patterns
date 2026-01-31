package org.example.behavioral.template_method;

class CreditCardPayment extends PaymentProcessor {
    @Override
    protected void validate() {
        System.out.println("Validating Credit Card...");
    }

    @Override
    protected void charge(double amount) {
        System.out.println("Charging Credit Card: $" + amount);
    }
}
