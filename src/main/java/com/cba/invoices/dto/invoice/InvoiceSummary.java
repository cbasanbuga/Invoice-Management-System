package com.cba.invoices.dto.invoice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class InvoiceSummary {

    private Long id;
    private double amount;
    private String description;

}
