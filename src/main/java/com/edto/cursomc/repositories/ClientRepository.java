package com.edto.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.edto.cursomc.domain.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

	@Transactional(readOnly=true)
	Client findByEmail(String email);
	
}










/*
 * @Transactional(readOnly=true) --> Annotation que para método não ser classificado como transferencia de dados deixando mais rápido e envitando o "locking" no gerenciamento do banco de dados
 * 
 * 
 * Client findByEmail(String email) --> Método criado para que o spring-data automaticamente detecta que vc quer ffazer uma buscar por Email, ouseja, vamos podeer buscar um cliente atraves do seu email.	 
*/