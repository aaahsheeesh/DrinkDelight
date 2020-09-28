package com.cg.drinkdelight.repository;


import com.cg.drinkdelight.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AddressDao extends JpaRepository<Address, Integer> {

}
