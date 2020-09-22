package com.edto.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edto.cursomc.domain.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
