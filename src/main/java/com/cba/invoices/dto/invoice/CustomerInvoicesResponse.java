package com.cba.invoices.dto.invoice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class CustomerInvoicesResponse {
    Long customerId;
    List<InvoiceSummary> summaries;
}
