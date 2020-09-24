package com.edto.cursomc.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.edto.cursomc.domain.enums.PaymentStatus;

@Entity
public class BoletoPayment extends Payment{
	private static final long serialVersionUID = 1L;
	
	private Date dueDate;
	private Date paymentDate;
	
	public BoletoPayment() {
	}

	public BoletoPayment(Long id, PaymentStatus status, Order order, Date dueDate, Date paymentDate) {
		super(id, status, order);
		this.dueDate = dueDate;
		this.paymentDate = paymentDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	
	
}