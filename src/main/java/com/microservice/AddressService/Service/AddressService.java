package com.microservice.AddressService.Service;

import com.microservice.AddressService.Entity.Address;
import com.microservice.AddressService.Repository.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    AddressRepo addressRepo;

    public Address saveAddress(Address address) {
        return addressRepo.save(address);
    }

    public List<Address> getAllAddress() {
        return addressRepo.findAll();
    }

    public Optional<Address> getAddressById(Long addressId) {
        return addressRepo.findById(addressId);
    }

    public Address updateAddress(Long addressId, Address updatedAddress) {
        Address existingAddress  = addressRepo.findById(addressId).orElseThrow(
                ()-> new RuntimeException("Address not found with ID : "+addressId)
        );

        existingAddress.setAddressId(updatedAddress.getAddressId());
        existingAddress.setStreet(updatedAddress.getStreet());
        existingAddress.setCity(updatedAddress.getCity());
        existingAddress.setState(updatedAddress.getState());
        existingAddress.setZipcode(updatedAddress.getZipcode());
        return addressRepo.save(existingAddress );
    }

    public Address deleteAddressById(Long addressId) {
        Address address = addressRepo.findById(addressId)
                .orElseThrow(() -> new RuntimeException("Address not found with ID: " + addressId));
        addressRepo.deleteById(addressId);
        return address;
    }


}
