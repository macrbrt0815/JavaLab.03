package model;

import java.time.LocalDateTime;

public class Transaction {
    protected String transactionID;
    protected String customerName;
    protected float totalAmount;
    protected String timeStamp;

    public Transaction(String transactionID, String customerName, float totalAmount, String timeStamp) {
        this.transactionID = transactionID;
        this.customerName = customerName;
        this.totalAmount = totalAmount;
        this.timeStamp = timeStamp;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}
