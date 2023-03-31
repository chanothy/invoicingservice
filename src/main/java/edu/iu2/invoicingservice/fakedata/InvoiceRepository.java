package edu.iu2.invoicingservice.fakedata;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InvoiceRepository {


    private List<Order> orders = new ArrayList<>();

    public InvoiceRepository() {
        Order order = new Order();
        order.setOrderId(1);
        order.setCustomerId(1);
        order.setOrderPlaced("3/4/2023");
        order.setTotal(60.26);
        InvoiceItem invoiceItem = new InvoiceItem();
//        invoiceItem.setStatus("shipping now");
        Item item1 = new Item();
        item1.setName("Tea");
        item1.setPrice(24.84);
        Item item2 = new Item();
        item2.setName("Tumeric Paste");
        item2.setPrice(22.99);
        item1.setItemId(1);
        item2.setItemId(2);
        item1.setStatus("shipping soon");
        item2.setStatus("shipping soon");
        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        invoiceItem.setItem(items);
        invoiceItem.setOn("3/5/2023");
        Address address = new Address();
        address.setState("Indiana");
        address.setState("Bloomington");
        address.setPostalCode(47408);
        Payment payment = new Payment();
        payment.setMethod("Discover");
        payment.setNumber("12345678");
        payment.setBillingAddress(address);
        invoiceItem.setAddress(address);
        order.setInvoiceItem(invoiceItem);
        order.setPayment(payment);
        orders.add(order);
    }
    public List<Order> findAll() {
        return orders;
    }

//    public int create(Order order) {
//        orders.add(order);
//        int id = orders.size() + 1;
//        order.setStatus("ordered");
//
//        List<Item> items = order.getItems();
//        for (int i = 0; i < items.size(); i++) {
//            items.get(i).setItemId(i+1);
//        }
//        return order.getCustomerId();
//    }
//
    public Order getOrderById(int id) {
        return orders.stream().filter(x -> x.getCustomerId() == id).findAny().orElse(null);
    }

    public Item getItemById(int id, Order o) {
        InvoiceItem item = o.getInvoiceItem();
        return item.getItem().stream().filter(x -> x.getItemId() == id).findAny().orElse(null);
    }

//    @PutMapping("/{id}")
    public void update(Item item,int orderId) {
        Order x = getOrderById(orderId);
        if (x != null) {
            Item i = x.getInvoiceItem().getItem().get(item.getItemId()-1);
            if (i != null) {
                x.getInvoiceItem().getItem().get(item.getItemId()-1).setStatus(item.getStatus());
            }
        }
    }

//
//    public Item getItemById(int id, Order o) {
//        return o.getItems().stream().filter(x -> x.getItemId() == id).findAny().orElse(null);
//    }
//
//    public void delete(int id) {
//        Order x = getOrderById(id);
//        if (x != null) {
//            x.setStatus("cancelled");
//        }
//        else {
//            throw new IllegalStateException("Order id is not valid");
//        }
//    }


//    public List<CancelledOrder> findAllCanceled() {
//        return cancelledOrders;
//    }

//    public void update(CancelledOrder order) {
//        CancelledOrder x = getCancelledOrderById(order.getOrderId());
//        if (x != null) {
//            x.setItemId(order.getItemId());
//            x.setReason(order.getReason());
//        }
//        else {
//            throw new IllegalStateException("order id is not valid");
//        }
//    }

//    @PutMapping("/return")
//    public void update(CancelledOrder cancel) {
//        Order x = getOrderById(cancel.getOrderId());
//        if (x != null) {
//            Item i = getItemById(cancel.getItemId(),x);
//            if (i != null) {
//                x.getReturns().add((cancel));
//            }
//            else {
//                throw new IllegalStateException("item id is not valid");
//            }
//        }
//        else {
//            throw new IllegalStateException("order id is not valid");
//        }
//    }
//
//    public int create(CancelledOrder order) {
//        cancelledOrders.add(order);
//        return order.getOrderId();
//    }
//
//    public CancelledOrder getCancelledOrderById(int id) {
//        return cancelledOrders.stream().filter(x -> x.getOrderId() == id).findAny().orElse(null);
//    }
}
