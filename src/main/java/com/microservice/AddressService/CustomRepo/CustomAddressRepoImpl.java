package com.microservice.AddressService.CustomRepo;

import com.microservice.AddressService.Entity.Address;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

@Repository
public class CustomAddressRepoImpl implements CustomAddressRepo{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Address getAddressByProcedure(Long addressId) {

        StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("AddressDataByProcedure");
        query.setParameter("addressId",addressId);
        query.execute();

        String street =(String) query.getOutputParameterValue("street1");
        String city = (String) query.getOutputParameterValue("city1");
        String state = (String) query.getOutputParameterValue("state1");
        String zipcode = (String) query.getOutputParameterValue("zipcode1");

        Address address = new Address();
        address.setStreet(street);
        address.setCity(city);
        address.setState(state);
        address.setZipcode(zipcode);

        return address;
    }
}
