package com.edto.cursomc.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edto.cursomc.domain.Order;
import com.edto.cursomc.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {
	
	@Autowired
	private OrderService service;
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll() {
		List<Order> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id) {
		Order obj = service.findbyId(id);
		return ResponseEntity.ok().body(obj);
	}
}

/*
 * Entre pedido e cliente tem uma associaçao de mao dupla, como foi feito um end point para pedido e o pedido tem que mostrar o cliente. 
 * Permitiremos que seja serializado o cliente de um pedido, porem eu nao vou permitir que seja serializado o pedido de um client.
 * OBS.: O mesmo vai acontecer com o pagamento.
 * 
 *  
 */
