package org.example.behavioral.template_method;

class PayPalPayment extends PaymentProcessor {
    @Override
    protected void validate() {
        System.out.println("Validating PayPal Account...");
    }

    @Override
    protected void charge(double amount) {
        System.out.println("Charging PayPal: $" + amount);
    }
}
