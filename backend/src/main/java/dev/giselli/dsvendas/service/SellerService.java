package dev.giselli.dsvendas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.giselli.dsvendas.dto.SellerDTO;
import dev.giselli.dsvendas.entities.Seller;
import dev.giselli.dsvendas.repositories.SellerRepository;

@Service //a classe será um componente do sistema e poderá ser injetado em outros componentes
public class SellerService{
	
	@Autowired
	private SellerRepository repository;
	
	public List<SellerDTO> findAll(){
		List<Seller> result = repository.findAll();
		return result.stream().map(x -> new SellerDTO(x)).collect(Collectors.toList());
	}
}
