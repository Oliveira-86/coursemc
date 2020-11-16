package com.edto.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.edto.cursomc.domain.Order;

public interface EmailService {

	void sendOrderConfirmationEmail(Order obj);
	
	void sendEmail(SimpleMailMessage msg);
}
