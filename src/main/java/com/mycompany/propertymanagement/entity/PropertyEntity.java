package com.mycompany.propertymanagement.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import javax.persistence.*;


@Entity
@Table(name = "PROP_TABLE")
@Setter
@Getter
@NoArgsConstructor
public class PropertyEntity {


    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    @Column(name = "PROP_DESC")
    private String description;
    private String name;
    private String email;
    private Double price;
    private String address;



}
