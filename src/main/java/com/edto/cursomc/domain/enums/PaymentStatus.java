package com.edto.cursomc.domain.enums;

public enum PaymentStatus {

	PENDING(1, "Pending"), 
	PAID(2, "Paid"),
	CANCELED(3, "Canceled");
	
	private Integer cod;
	private String description;
	
	private PaymentStatus(Integer cod, String description) {
		this.cod = cod;
		this.description = description;
	}
	
	public Integer getCod() {
		return cod;
	}
	
	public String getDescription() {
		return description;
	}
	
	public static PaymentStatus toEnum(Integer cod) {
		
		if(cod == null) {
			return null;	
		}
		
		for (PaymentStatus x : PaymentStatus.values()) {
			if(cod.equals(x.getCod())) {
			return x;
			}
		}
	
		throw new IllegalArgumentException("Id invalid " + cod);
	}
}

