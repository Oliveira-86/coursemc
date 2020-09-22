package com.edto.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.edto.cursomc.domain.Address;
import com.edto.cursomc.domain.Category;
import com.edto.cursomc.domain.City;
import com.edto.cursomc.domain.Client;
import com.edto.cursomc.domain.Product;
import com.edto.cursomc.domain.State;
import com.edto.cursomc.domain.enums.ClientType;
import com.edto.cursomc.repositories.AddressRepository;
import com.edto.cursomc.repositories.CategoryRepository;
import com.edto.cursomc.repositories.CityRepository;
import com.edto.cursomc.repositories.ClientRepository;
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
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		Category cat1 = new Category(null, "Informática");
		Category cat2 = new Category(null, "Escritório");
		
		Product p1 = new Product(null, "Computer", 2000.00);
		Product p2 = new Product(null, "Scanner", 800.00);
		Product p3 = new Product(null, "Mouse", 80.00);
		
		cat1.getProducts().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProducts().addAll(Arrays.asList(p2));;
		
		p1.getCategories().addAll(Arrays.asList(cat1));
		p2.getCategories().addAll(Arrays.asList(cat1, cat2));
		p3.getCategories().addAll(Arrays.asList(cat2));
		
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		productRepository.saveAll(Arrays.asList(p1, p2, p3));
		

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
	}

}

/*
 * Salvamos primeiro sempre quem é independente.
 */
