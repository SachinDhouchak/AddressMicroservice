package com.microservice.AddressService.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long addressId;

        @Column(name = "street", nullable = false)
        private String street;

        @Column(name = "city", nullable = false)
        private String city;

        @Column(name = "state", nullable = false)
        private String state;

        @Column(name = "zipcode", nullable = false)
        private String zipcode;

    }
