package edu.iu2.invoicingservice.controller;

import edu.iu2.invoicingservice.data.Invoice;
import edu.iu2.invoicingservice.data.InvoiceItem;
import edu.iu2.invoicingservice.data.Item;
import edu.iu2.invoicingservice.data.Order;
import edu.iu2.invoicingservice.repository.InvoiceRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    private InvoiceRepo invoiceRepository;

    @GetMapping
    public List<Order> findAll() {
        return invoiceRepository.findAll();
    }
    public InvoiceController(InvoiceRepo invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @GetMapping("/{id}")
    public Invoice findByCustomerID(@PathVariable int id) {
        Optional<Order> temp = invoiceRepository.findById(id);
//        Order order = trackingRepository.getById(orderId);

        if (temp.isEmpty()) {
            throw new IllegalStateException("order id is not valid");
        }
        Order order = temp.get();
        InvoiceItem invoiceItem = new InvoiceItem(order.getItems(), order.getShippingAddress());
        Invoice invoice = new Invoice(order.getOrderId(),order.getCustomerId(),order.getDate(),order.getTotal(),invoiceItem,order.getPayment());
        return invoice;
    }

    @PutMapping("/{orderId}")
    public void update(@RequestBody Item item, @PathVariable int orderId) {
        Optional<Order> temp = invoiceRepository.findById(orderId);
//        Order order = trackingRepository.getById(orderId);

        if (temp.isEmpty()) {
            throw new IllegalStateException("order id is not valid");
        }
        Order order = temp.get();
        int validItemId = 0;
        for (int i = 0; i < order.getItems().size(); i++) {
            if (order.getItems().get(i).getItemId() == item.getItemId()) {
                order.getItems().get(i).setStatus(item.getStatus());
                validItemId = 1;
            }
        }
        if (validItemId == 0) {
            throw new IllegalStateException("item id is not valid");
        }

        invoiceRepository.save(order);
    }
}
