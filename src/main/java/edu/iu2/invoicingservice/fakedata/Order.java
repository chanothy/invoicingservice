package edu.iu2.invoicingservice.fakedata;

import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Order {
    private int orderId;
    private int customerId;
    private String orderPlaced;
    private double total;
    private InvoiceItem invoiceItem;
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
