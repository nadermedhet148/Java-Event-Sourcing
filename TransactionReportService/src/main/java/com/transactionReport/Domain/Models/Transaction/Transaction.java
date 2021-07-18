package com.transactionReport.Domain.Models.Transaction;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Transaction {
    private Integer transactionId;
    private String userId;
    private Float amount;
    private String type;
    private String status;
    private Date createdAt = new Date();
}
