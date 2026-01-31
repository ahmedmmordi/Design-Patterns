package org.example.behavioral.template_method;

class BankTransferPayment extends PaymentProcessor {
    @Override
    protected void validate() {
        System.out.println("Validating Bank Account...");
    }

    @Override
    protected void charge(double amount) {
        System.out.println("Charging Bank Transfer: $" + amount);
    }

    @Override
    protected boolean requiresFraudChecking() {
        return false;
    }
}
