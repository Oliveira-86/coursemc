package com.edto.cursomc.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.edto.cursomc.domain.Client;
import com.edto.cursomc.services.validation.ClientUpdate;

@ClientUpdate
public class ClientDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@NotEmpty(message= "Mandatory")
	@Length(min=5, max=80, message="The length should be between 5 and 120 characters")
	private String name;
	
	@NotEmpty(message= "Mandatory")
	@Email(message = "Email Invalid")
	private String email;
	
	public ClientDTO() {
	}
	
	public ClientDTO(Client obj) {
		id = obj.getId();
		name = obj.getName();
		email = obj.getEmail();
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
