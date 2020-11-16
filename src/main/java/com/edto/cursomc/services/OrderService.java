package com.edto.cursomc.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edto.cursomc.domain.BoletoPayment;
import com.edto.cursomc.domain.Order;
import com.edto.cursomc.domain.OrderItem;
import com.edto.cursomc.domain.enums.PaymentStatus;
import com.edto.cursomc.repositories.OrderItemRepository;
import com.edto.cursomc.repositories.OrderRepository;
import com.edto.cursomc.repositories.PaymentRepository;
import com.edto.cursomc.services.exceptions.ResourceNotFoundException;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;
	
	@Autowired
	private BoletoService boletoService;

	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	private OrderItemRepository orderItemRepository;

	@Autowired
	private ProductService productService;

	public Order findbyId(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	@Transactional
	public Order insert(Order obj) {
		obj.setId(null);
		obj.setInstante(new Date());;
		obj.getPayment().setStatus(PaymentStatus.PENDING);
		obj.getPayment().setOrder(obj);
		if (obj.getPayment() instanceof BoletoPayment) {
			BoletoPayment pagto = (BoletoPayment) obj.getPayment();
			boletoService.preencherPagamentoComBoleto(pagto, obj.getInstante());
		}
		obj = repository.save(obj);
		paymentRepository.save(obj.getPayment());
		for (OrderItem ip : obj.getItems()) {
			ip.setDiscount(0.0);
			ip.setPrice(productService.findbyId(ip.getProduct().getId()).getPrice());
			ip.setOrder(obj);
		}
		orderItemRepository.saveAll(obj.getItems());
		System.out.println(obj);
		return obj;
	}
}
