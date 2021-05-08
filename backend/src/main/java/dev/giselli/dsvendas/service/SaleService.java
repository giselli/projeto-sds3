package dev.giselli.dsvendas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.giselli.dsvendas.dto.SaleDTO;
import dev.giselli.dsvendas.dto.SaleSuccessDTO;
import dev.giselli.dsvendas.dto.SaleSumDTO;
import dev.giselli.dsvendas.entities.Sale;
import dev.giselli.dsvendas.repositories.SaleRepository;
import dev.giselli.dsvendas.repositories.SellerRepository;

@Service // a classe será um componente do sistema e poderá ser injetado em outros
			// componentes
public class SaleService {

	@Autowired
	private SaleRepository repository;

	@Autowired
	private SellerRepository sellerRepository;

	@Transactional(readOnly = true) // toda operação com o banco será feita neste momento como service. O read Only
									// garante que o banco não sofrerá lock
	public Page<SaleDTO> findAll(Pageable pageable) {
		// pageable para os resultados aparecerem em páginas
		sellerRepository.findAll();
		Page<Sale> result = repository.findAll(pageable);
		return result.map(x -> new SaleDTO(x));
	}

	@Transactional
	public List<SaleSumDTO> amountGroupedBySeller() {
		return repository.amountGroupedBySeller();
	}
	
	@Transactional
	public List<SaleSuccessDTO> successGroupedBySeller() {
		return repository.successGroupedBySeller();
	}
}
