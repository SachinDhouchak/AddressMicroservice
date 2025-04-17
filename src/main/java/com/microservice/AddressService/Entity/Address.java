package com.microservice.AddressService.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@NamedStoredProcedureQueries(
        @NamedStoredProcedureQuery(
                name = "AddressDataByProcedure",
                procedureName = "getAddress",
                parameters = {
                        @StoredProcedureParameter(name = "addressId", mode = ParameterMode.IN, type = Long.class),
                        @StoredProcedureParameter(name = "street1", mode = ParameterMode.OUT, type = String.class),
                        @StoredProcedureParameter(name = "city1", mode = ParameterMode.OUT, type = String.class),
                        @StoredProcedureParameter(name = "state1", mode = ParameterMode.OUT, type = String.class),
                        @StoredProcedureParameter(name = "zipcode1", mode = ParameterMode.OUT, type = String.class)
                }
        )
)
@Entity
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
