package com.edto.cursomc.domain;

import javax.persistence.Entity;

import com.edto.cursomc.domain.enums.PaymentStatus;
import com.fasterxml.jackson.annotation.JsonTypeName;

@Entity
@JsonTypeName("pagamentoComCartao")
public class CardPayment extends Payment {
	private static final long serialVersionUID = 1L;
	
	private Integer numberOfInstallments;
	
	public CardPayment() {
	}

	public CardPayment(Long id, PaymentStatus status, Order order, Integer numberOfInstallments) {
		super(id, status, order);
		this.numberOfInstallments = numberOfInstallments;
	}

	public Integer getNumberOfInstallments() {
		return numberOfInstallments;
	}

	public void setNumberOfInstallments(Integer numberOfInstallments) {
		this.numberOfInstallments = numberOfInstallments;
	}
	
	
	
}
