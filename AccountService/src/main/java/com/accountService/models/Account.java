package com.accountService.models;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.json.JSONObject;

import java.util.Date;


@Table(name = "user_account")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Account {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id ;

    @Column(name = "user_id")
    private Integer userId;


    @Column(name = "balance")
    private Float balance;

    public String toJsonStringState(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("account_id" , this.id);
        jsonObject.put("user_id" , this.userId);
        jsonObject.put("balance", this.balance);
        jsonObject.put("event_type", "BALANCE_CHANGED_"+this.userId);
        jsonObject.put("created_at" , new Date().toString());
        return jsonObject.toString();
    }



}
