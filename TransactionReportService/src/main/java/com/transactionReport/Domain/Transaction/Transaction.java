package com.transactionReport.Domain.Transaction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Table(name = "Transactions")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Transaction {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id ;


    @Column(name = "user_id")
    private String userId;


    @Column(name = "username")
    private String username;

    @Column(name = "balance_after_transaction")
    private String balanceAfterTransaction;

    @Column(name = "amount")
    private Float amount;

    @Column(name = "type")
    private String type;

    @Column(name = "status")
    private String status;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

}
