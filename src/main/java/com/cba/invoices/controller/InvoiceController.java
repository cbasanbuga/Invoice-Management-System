package com.cba.invoices.controller;

import com.cba.invoices.dto.invoice.CreateInvoiceRequest;
import com.cba.invoices.dto.invoice.CustomerInvoiceTotal;
import com.cba.invoices.dto.invoice.CustomerInvoicesResponse;
import com.cba.invoices.dto.invoice.InvoiceResponse;
import com.cba.invoices.service.InvoiceService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class InvoiceController {

    private final InvoiceService invoiceService;

    @PostMapping("/invoices")
    public ResponseEntity<InvoiceResponse> saveInvoice(@RequestBody CreateInvoiceRequest invoice) {
        return invoiceService.saveInvoice(invoice);
    }

    @GetMapping("/invoices/customer/{id}")
    public CustomerInvoicesResponse getAllInvoicesByCustomer(@PathVariable Long id) {
        return invoiceService.getAllInvoicesByCustomer(id);
    }

    @GetMapping("/invoices/customer/{id}/total")
    public CustomerInvoiceTotal getCustomerInvoiceTotal(@PathVariable Long id){
        return invoiceService.getCustomerInvoiceTotal(id);
    }

}
