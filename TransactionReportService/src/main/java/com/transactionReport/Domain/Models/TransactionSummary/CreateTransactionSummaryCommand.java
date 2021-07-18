package com.transactionReport.Domain.Models.TransactionSummary;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreateTransactionSummaryCommand {
    private String userId;

    private Integer transactionId;


}
