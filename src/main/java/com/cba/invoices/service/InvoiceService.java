package com.cba.invoices.service;

import com.cba.invoices.dto.invoice.*;
import com.cba.invoices.entity.Customer;
import com.cba.invoices.entity.Invoice;
import com.cba.invoices.repository.CustomerRepository;
import com.cba.invoices.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final CustomerRepository customerRepository;

    @Transactional
    public ResponseEntity<InvoiceResponse> saveInvoice(CreateInvoiceRequest invoiceRequest) {

        Customer customer = customerRepository
                .findById(invoiceRequest.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer id not found"));

        Invoice invoice = new Invoice();
        invoice.setCustomer(customer);
        invoice.setAmount(invoiceRequest.getAmount());
        invoice.setDescription(invoiceRequest.getDescription());

        Invoice saved = invoiceRepository.save(invoice);

        InvoiceResponse invoiceResponse = new InvoiceResponse();
        invoiceResponse.setId(saved.getId());
        invoiceResponse.setDescription(saved.getDescription());
        invoiceResponse.setAmount(saved.getAmount());
        invoiceResponse.setCustomerId(saved.getCustomer().getId());


        return new ResponseEntity<>(invoiceResponse, HttpStatus.ACCEPTED);

    }

    public CustomerInvoicesResponse getAllInvoicesByCustomer(Long id){

        List<InvoiceSummary> summaries = invoiceRepository.findByCustomer_Id(id);
        return new CustomerInvoicesResponse(id,summaries);

    }

    public CustomerInvoiceTotal getCustomerInvoiceTotal(Long id){
        double totalAmount = invoiceRepository.findTotalAmountByCustomerId(id);
        return new CustomerInvoiceTotal(id, totalAmount);
    }
}
