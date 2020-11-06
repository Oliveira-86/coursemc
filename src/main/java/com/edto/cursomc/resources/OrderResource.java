package com.edto.cursomc.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.edto.cursomc.domain.Order;
import com.edto.cursomc.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {
	
	@Autowired
	private OrderService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id) {
		Order obj = service.findbyId(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody Order obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
		}
}

/*
 * Entre pedido e cliente tem uma associaçao de mao dupla, como foi feito um end point para pedido e o pedido tem que mostrar o cliente. 
 * Permitiremos que seja serializado o cliente de um pedido, porem eu nao vou permitir que seja serializado o pedido de um client.
 * OBS.: O mesmo vai acontecer com o pagamento.
 * 
 * não é necessário criar uma classe OrderDTO pq o pedido tem varios dados associado a ele, cliente, item, endereo pagamento. Para nao ter que fazer um DTO grande ou vários DTO associado usn com os outros.
 *  
 *  
 */
