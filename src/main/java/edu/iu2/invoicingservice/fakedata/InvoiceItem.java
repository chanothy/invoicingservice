package edu.iu2.invoicingservice.fakedata;

import java.util.ArrayList;
import java.util.List;

public class InvoiceItem {
//    private String status;
    private List<Item> item = new ArrayList<>();
    private String on;
    private Address address;

//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }

    public String getOn() {
        return on;
    }

    public void setOn(String on) {
        this.on = on;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
