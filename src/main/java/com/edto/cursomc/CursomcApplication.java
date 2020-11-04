package com.edto.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.edto.cursomc.domain.Address;
import com.edto.cursomc.domain.BoletoPayment;
import com.edto.cursomc.domain.CardPayment;
import com.edto.cursomc.domain.Category;
import com.edto.cursomc.domain.City;
import com.edto.cursomc.domain.Client;
import com.edto.cursomc.domain.Order;
import com.edto.cursomc.domain.OrderItem;
import com.edto.cursomc.domain.Payment;
import com.edto.cursomc.domain.Product;
import com.edto.cursomc.domain.State;
import com.edto.cursomc.domain.enums.ClientType;
import com.edto.cursomc.domain.enums.PaymentStatus;
import com.edto.cursomc.repositories.AddressRepository;
import com.edto.cursomc.repositories.CategoryRepository;
import com.edto.cursomc.repositories.CityRepository;
import com.edto.cursomc.repositories.ClientRepository;
import com.edto.cursomc.repositories.OrderItemRepository;
import com.edto.cursomc.repositories.OrderRepository;
import com.edto.cursomc.repositories.PaymentRepository;
import com.edto.cursomc.repositories.ProductRepository;
import com.edto.cursomc.repositories.StateRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private StateRepository stateRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		Category cat1 = new Category(null, "Informática");
		Category cat2 = new Category(null, "Escritório");
		Category cat3 = new Category(null, "Cama Mesa e Banho");
		Category cat4 = new Category(null, "Eletrônico");
		Category cat5 = new Category(null, "Jardinagem");
		Category cat6 = new Category(null, "Decoração");
		Category cat7 = new Category(null, "Perfumaria");

		Product p1 = new Product(null, "Computer", 2000.00);
		Product p2 = new Product(null, "Scanner", 800.00);
		Product p3 = new Product(null, "Mouse", 80.00);
		Product p4 = new Product(null, "Mesa de escritório", 300.00);
		Product p5 = new Product(null, "Toalha", 50.00);
		Product p6 = new Product(null, "Colcha", 200.00);
		Product p7 = new Product(null, "TV true color", 1200.00);
		Product p8 = new Product(null, "Roçadeira", 800.00);
		Product p9 = new Product(null, "Abajour", 100.00);
		Product p10 = new Product(null, "Pendente", 180.00);
		Product p11 = new Product(null, "Shampoo", 90.00);
		
		
		cat1.getProducts().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProducts().addAll(Arrays.asList(p2));
		cat2.getProducts().addAll(Arrays.asList(p2, p4));
		cat3.getProducts().addAll(Arrays.asList(p5, p6));
		cat4.getProducts().addAll(Arrays.asList(p1, p2, p3, p7));
		cat5.getProducts().addAll(Arrays.asList(p8));
		cat6.getProducts().addAll(Arrays.asList(p9, p10));
		cat7.getProducts().addAll(Arrays.asList(p11));
		
		p1.getCategories().addAll(Arrays.asList(cat1, cat4));
		p2.getCategories().addAll(Arrays.asList(cat1, cat2, cat4));
		p3.getCategories().addAll(Arrays.asList(cat1, cat4));
		p4.getCategories().addAll(Arrays.asList(cat2));
		p5.getCategories().addAll(Arrays.asList(cat3));
		p6.getCategories().addAll(Arrays.asList(cat3));
		p7.getCategories().addAll(Arrays.asList(cat4));
		p8.getCategories().addAll(Arrays.asList(cat5));
		p9.getCategories().addAll(Arrays.asList(cat6));
		p10.getCategories().addAll(Arrays.asList(cat6));
		p11.getCategories().addAll(Arrays.asList(cat7));
		
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11));		

		State st1 = new State(null, "Minas Gerais");
		State st2 = new State(null, "São Paulo");
		
		City cit1 = new City(null, "Urbelândia", st1);
		City cit2 = new City(null, "São Paulo", st2);
		City cit3 = new City(null, "Campinas", st2);
		
		st1.getCities().addAll(Arrays.asList(cit1));
		st2.getCities().addAll(Arrays.asList(cit2, cit3));
		
		stateRepository.saveAll(Arrays.asList(st1, st2));
		cityRepository.saveAll(Arrays.asList(cit1, cit2, cit3));
		
		Client cl1 = new Client(null, "Maria Silva", "maria@gmail.com", "00987856432" ,ClientType.PHYSICALPERSON);
		
		cl1.getPhone().addAll(Arrays.asList("999923388", "982983746"));
		
		Address add1 = new Address(null, "Rua Flores", "300", "Apto 203", "Jardim", "54389098", cl1, cit1);
		Address add2 = new Address(null, "Avenida Matos", "400", "Sala 800", "Centro", "23490847", cl1, cit2);
		
		cl1.getAddress().addAll(Arrays.asList(add1, add2));
		
		clientRepository.saveAll(Arrays.asList(cl1));
		addressRepository.saveAll(Arrays.asList(add1, add2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Order o1 = new Order(null, sdf.parse("23/09/2020 00:01"), cl1, add1);
		Order o2 = new Order(null, sdf.parse("19/10/2020 12:34"), cl1, add2);
		
		Payment pay1 = new CardPayment(null, PaymentStatus.PENDING, o1, 6);
		o1.setPayment(pay1);
		
		Payment pay2 = new BoletoPayment(null, PaymentStatus.PAID, o2, sdf.parse("21/09/2020 13:50"), sdf.parse("23/09/2020 15:00"));
		o2.setPayment(pay2);
		
		cl1.getOrders().addAll(Arrays.asList(o1, o2)); 
		
		orderRepository.saveAll(Arrays.asList(o1, o2));
		paymentRepository.saveAll(Arrays.asList(pay1, pay2));
		
		OrderItem oi1 = new OrderItem(o1, p1, 0.00, 1, 2000.00);
		OrderItem oi2 = new OrderItem(o1, p3, 0.00, 2, 80.00);
		OrderItem oi3 = new OrderItem(o2, p2, 100.0, 1, 800.00);
		
		o1.getItems().addAll(Arrays.asList(oi1, oi2));
		o2.getItems().addAll(Arrays.asList(oi3));
		
		p1.getItems().addAll(Arrays.asList(oi1));
		p2.getItems().addAll(Arrays.asList(oi3));
		p3.getItems().addAll(Arrays.asList(oi2));
		
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3));
	}

}

/*
 * Salvamos primeiro sempre quem é independente. Exemplo, salvar primeiro o pedido e depois os pagamentos.
 */
