package com.cba.invoices.dto.invoice;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvoiceResponse {

    private Long id;
    private double amount;
    private String description;
    private Long customerId;
}
