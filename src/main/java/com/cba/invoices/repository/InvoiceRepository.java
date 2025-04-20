package com.cba.invoices.repository;

import com.cba.invoices.dto.invoice.InvoiceSummary;
import com.cba.invoices.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    List<InvoiceSummary> findByCustomer_Id(long customerId);

    @Query("SELECT sum(i.amount) FROM Invoice i WHERE i.customer.id = :id")
    double findTotalAmountByCustomerId(@Param("id") Long id);
}
