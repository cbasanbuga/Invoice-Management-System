package com.cba.invoices.dto.invoice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CustomerInvoiceTotal {
    private Long customerId;
    private double totalAmount;
}
