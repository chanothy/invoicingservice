package edu.iu2.invoicingservice.data;

import jakarta.persistence.*;

//@Entity
public class Invoice {

    public Invoice(int orderId, int customerId, String orderPlaced, double total, InvoiceItem invoiceItem, Payment payment) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderPlaced = orderPlaced;
        this.total = total;
        this.invoiceItem = invoiceItem;
        this.payment = payment;
    }

    private int orderId;
    private int customerId;
    private String orderPlaced;
    private double total;


    @OneToOne(cascade = CascadeType.ALL)
    private InvoiceItem invoiceItem;

    @OneToOne(cascade = CascadeType.ALL)
    private Payment payment;

    public int getOrderId() {
        return orderId;
    }

    public String getOrderPlaced() {
        return orderPlaced;
    }

    public void setOrderPlaced(String orderPlaced) {
        this.orderPlaced = orderPlaced;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public InvoiceItem getInvoiceItem() {
        return invoiceItem;
    }

    public void setInvoiceItem(InvoiceItem invoiceItem) {
        this.invoiceItem = invoiceItem;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
