package models;

public class Payment {
    private int paymentId;
    private String method;
    private double amount;
    private boolean paid;

    public Payment(int paymentId, double amount, String method) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.method = method;
    }

    public boolean proceed() {
        paid = method.equalsIgnoreCase("card") || method.equalsIgnoreCase("cash");
        return paid;
    }

    public int getPaymentId() { return paymentId; }
    public String getMethod() { return method; }
    public double getAmount() { return amount; }
    public boolean isPaid() { return paid; }
}