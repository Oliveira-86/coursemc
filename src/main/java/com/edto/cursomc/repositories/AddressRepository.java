package com.edto.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edto.cursomc.domain.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
