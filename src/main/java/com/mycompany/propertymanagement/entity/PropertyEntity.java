package com.mycompany.propertymanagement.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private Double price;
    private String address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", nullable = false)
    private UserEntity userEntity;

}
