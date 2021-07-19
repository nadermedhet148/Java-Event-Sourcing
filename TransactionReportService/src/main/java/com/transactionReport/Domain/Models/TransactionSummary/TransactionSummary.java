package com.transactionReport.Domain.Models.TransactionSummary;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;


@Table(name = "Transactions")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class TransactionSummary {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id ;


    @Column(name = "transaction_id")
    private Integer transactionId ;


    @Column(name = "user_id")
    private String userId;


    @Column(name = "username")
    private String username;

    @Column(name = "balance_after_transaction")
    private Float balanceAfterTransaction;

    @Column(name = "amount")
    private Float amount;

    @Column(name = "type")
    private String type;

    @Column(name = "status")
    private String status;

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreatedDate
    private Date createdAt;

}
