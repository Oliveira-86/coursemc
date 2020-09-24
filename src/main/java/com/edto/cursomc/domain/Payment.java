package com.edto.cursomc.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.edto.cursomc.domain.enums.PaymentStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Payment implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	private Integer status; 
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "order_id")
	@MapsId
	private Order order;
	
	public Payment() {
	}

	public Payment(Long id, PaymentStatus status, Order order) {
		super();
		this.id = id;
		this.status = status.getCod();
		this.order = order;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PaymentStatus getStatus() {
		return PaymentStatus.toEnum(status);
	}

	public void setStatus(PaymentStatus status) {
		this.status = status.getCod();
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
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
		Payment other = (Payment) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}

/*
 * @Inheritance(strategy = InheritanceType.JOINED) --> Annotation associada a superclasse e a estratégia usada para gerar a tbela no banco de dados,
 * tem duas estrategias a tabela unica ou uma tabela para cada classe. Nesse caso usamos a tabela única(JOINED).
 * 
 * public abstract class Payment implements Serializable --> para que essa classe nunca seja instanciada e sim suas subclasses.
 */
