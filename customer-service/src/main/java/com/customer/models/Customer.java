package com.customer.models;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.json.JSONObject;


@Table(name = "Student")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Customer {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id ;

    @Column(name = "name")
    private String name;

    public String toJson(){
        JSONObject json = new JSONObject();
        json.put("user_id" , this.id);
        json.put("name" , this.name);
        return  json.toString();

    }

}
