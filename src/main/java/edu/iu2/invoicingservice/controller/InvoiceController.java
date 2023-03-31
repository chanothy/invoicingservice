package edu.iu2.invoicingservice.controller;

import edu.iu2.invoicingservice.fakedata.InvoiceItem;
import edu.iu2.invoicingservice.fakedata.InvoiceRepository;
import edu.iu2.invoicingservice.fakedata.Item;
import edu.iu2.invoicingservice.fakedata.Order;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    private InvoiceRepository invoiceRepository;

    public InvoiceController(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = new InvoiceRepository();
    }

    @GetMapping("/{id}")
    public Order findByCustomerID(@PathVariable int id) {
        return invoiceRepository.findByCustomerId(id);
    }

    @PutMapping("/{orderId}")
    public void update(@RequestBody Item item, @PathVariable int orderId) {
        invoiceRepository.update(item,orderId);
    }
}
