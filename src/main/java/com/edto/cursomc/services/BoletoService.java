package com.edto.cursomc.services;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.edto.cursomc.domain.BoletoPayment;



@Service
public class BoletoService {

	public void preencherPagamentoComBoleto(BoletoPayment pagto, Date instanteDoPedido) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(instanteDoPedido);
		cal.add(Calendar.DAY_OF_MONTH, 7);
		pagto.setDueDate(cal.getTime());
	}
}
