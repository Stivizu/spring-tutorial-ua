package com.stevecorp.teaching.spring.repository;

import com.stevecorp.teaching.spring.model.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {

    @Override
    List<Address> findAll();
}
