package edu.iu2.invoicingservice.data;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

//@Entity
public class InvoiceItem {
    public InvoiceItem(List<Item> item, Address address) {
        this.item = item;
        this.address = address;
    }

    @OneToMany(cascade = CascadeType.ALL)
    private List<Item> item = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
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


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
