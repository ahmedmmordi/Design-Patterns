package org.example.behavioral.template_method;

abstract class PaymentProcessor {
    public final void processPayment(double amount) {
        validate();
        if (requiresFraudChecking()) {
            performFraudChecking();
        }
        charge(amount);
        sendReceipt();
        logTransaction();
    }

    protected abstract void validate();
    protected abstract void charge(double amount);

    protected void performFraudChecking() {
        System.out.println("Running Fraud Detection...");
    }

    protected boolean requiresFraudChecking() {
        return true;
    }

    protected void sendReceipt() {
        System.out.println("Sending Payment Receipt...");
    }

    protected void logTransaction() {
        System.out.println("Logging Transaction...");
    }
}
