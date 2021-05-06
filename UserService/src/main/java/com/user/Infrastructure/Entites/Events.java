package com.user.Infrastructure.Entites;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.json.JSONObject;

import javax.persistence.*;


@Table(name = "EVENTS")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Events {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id ;

    @Column(name = "entity_name")
    private String entityName;

    @Column(name = "entity_id")
    private String entityId;

    @Column(name = "data")
    private String data;


}
