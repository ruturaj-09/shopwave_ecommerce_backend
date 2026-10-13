package com.shopwave.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopwave.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
