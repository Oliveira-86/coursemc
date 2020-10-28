package com.edto.cursomc.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.edto.cursomc.services.validation.ClientInsert;

@ClientInsert
public class ClientNewDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message="Mandatory")
	@Length(min=5, max=80, message="The length must be between 5 and 80 characters")
	private String name;
	
	@NotEmpty(message="Mandatory")
	@Email(message="Invalid Email")
	private String email;
	
	@NotEmpty(message="Mandatory")
	private String cpfOuCnpj;
	private Integer type;
	
	@NotEmpty(message="Mandatory")
	private String publicPlace;
	
	@NotEmpty(message="Mandatory")
	private String number;
	
	private String complement;
	
	private String neighborhood;
	
	@NotEmpty(message="Mandatory")
	private String zipCode;
	
	@NotEmpty(message="Mandatory")
	private String phone1;
	
	private String phone2;
	
	private String phone3;
	
	private Long cityId;
	
	public ClientNewDTO() {
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

	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}

	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getPublicPlace() {
		return publicPlace;
	}

	public void setPublicPlace(String publicPlace) {
		this.publicPlace = publicPlace;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getPhone3() {
		return phone3;
	}

	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cidadeId) {
		this.cityId = cidadeId;
	}

	
}
