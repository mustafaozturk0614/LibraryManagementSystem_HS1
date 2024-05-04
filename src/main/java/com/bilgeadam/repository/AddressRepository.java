package com.bilgeadam.repository;

import com.bilgeadam.entity.Address;
import com.bilgeadam.entity.Author;

public class AddressRepository extends Repository<Address,Long >{

    public AddressRepository() {
        super(new Address());
    }
}
