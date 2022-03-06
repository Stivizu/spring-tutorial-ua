package com.stevecorp.teaching.spring.service;

import com.stevecorp.teaching.spring.model.Address;
import com.stevecorp.teaching.spring.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

}
