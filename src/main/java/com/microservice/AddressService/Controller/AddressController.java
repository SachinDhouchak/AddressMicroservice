package com.microservice.AddressService.Controller;

import com.microservice.AddressService.Entity.Address;
import com.microservice.AddressService.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    // procedure api
    @GetMapping("/addressByProcedure/{addressId}")
    public ResponseEntity<Address> getAddressByProcedure(@PathVariable Long addressId) {
        return ResponseEntity.ok(addressService.getAddressByProcedure(addressId));
    }

    // CREATE
    @PostMapping("/addAddress")
    public ResponseEntity<String> addAddress(@RequestBody Address address) {
        Address savedAddress = addressService.saveAddress(address);
        return ResponseEntity.status(HttpStatus.CREATED).body("new address is saved");
    }

    // READ ALL
    @GetMapping("/allAddress")
    public ResponseEntity<List<Address>> getAllAddresses() {
        List<Address> addresses = addressService.getAllAddress();
        return ResponseEntity.ok(addresses);
    }

    // READ BY ID
    @GetMapping("/addressById/{addressId}")
    public ResponseEntity<Address> getAddressById(@PathVariable Long addressId) {
        Address address = addressService.getAddressById(addressId).orElseThrow(
                ()-> new RuntimeException("data is not found")
        );
        return ResponseEntity.ok(address);
    }

    // UPDATE
    @PutMapping("/updateAddress/{addressId}")
    public ResponseEntity<Address> updateAddress(@PathVariable Long addressId, @RequestBody Address address) {
        Address updatedAddress = addressService.updateAddress(addressId, address);
        return ResponseEntity.ok(updatedAddress);
    }

    // DELETE
    @DeleteMapping("/deleteAddress/{addressId}")
    public ResponseEntity<Address> deleteAddress(@PathVariable Long addressId) {
        Address deletedAddress = addressService.deleteAddressById(addressId);
        return ResponseEntity.ok(deletedAddress);
    }
}
