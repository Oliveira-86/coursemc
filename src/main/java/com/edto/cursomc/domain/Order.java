package com.edto.cursomc.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date date;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "order")
	private Payment payment;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "delivery_address_id")
	private Address deliveryAddress;
	
	@OneToMany(mappedBy = "id.order")
	private Set<OrderItem> items = new HashSet<>();
	
	public Order() {
	}

	public Order(Long id, Date date, Client client, Address deliveryAddress) {
		super();
		this.id = id;
		this.date = date;
		this.client = client;
		this.deliveryAddress = deliveryAddress;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Address getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(Address deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	
	public Set<OrderItem> getItems() {
		return items;
	}

	public void setItems(Set<OrderItem> items) {
		this.items = items;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
/*
 * cascade = CascadeType.ALL --> é uma peculiaridade do JPA para que nao dê um erro de entidade transiente ao salvar pedido e pagamento.
 */
