package edu.iu2.invoicingservice.repository;

import edu.iu2.invoicingservice.data.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InvoiceRepo extends JpaRepository<Order,Integer>{

}
