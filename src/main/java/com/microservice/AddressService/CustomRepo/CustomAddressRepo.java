package com.microservice.AddressService.CustomRepo;

import com.microservice.AddressService.Entity.Address;
import org.springframework.data.repository.query.Param;

public interface CustomAddressRepo {

    public Address getAddressByProcedure(Long addressId);
}
