package dev.giselli.dsvendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.giselli.dsvendas.dto.SellerDTO;
import dev.giselli.dsvendas.service.SellerService;

@RestController //indica que a classe será um controlador Rest
@RequestMapping(value = "/sellers") //qual o caminho do recurso

public class SellerController {

	@Autowired
	private SellerService service;
	
	@GetMapping
	public ResponseEntity<List<SellerDTO>> findAll(){
		List<SellerDTO> list = service.findAll();
		return ResponseEntity.ok(list);
	}
}
