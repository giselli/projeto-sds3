package dev.giselli.dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dev.giselli.dsvendas.dto.SaleSuccessDTO;
import dev.giselli.dsvendas.dto.SaleSumDTO;
import dev.giselli.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

	@Query("SELECT new dev.giselli.dsvendas.dto.SaleSumDTO(obj.seller, SUM(obj.amount)) " //selecionando novos objetos do tipo SaleSumDTO()
	 + " FROM Sale AS obj GROUP BY obj.seller")
	//obj para objetos do tipo Sale do banco, como um apelido
	//obj.seller. O seller vem do atributo private Seller seller do arquivo Sale.java
	//SUM é a operação do sql
	//Consulta em jpql

	//Sale deve ser escrito como no nome da classe (Sale.java)
	List<SaleSumDTO> amountGroupedBySeller();

	@Query("SELECT new dev.giselli.dsvendas.dto.SaleSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals) ) " 
			//visited e deals da classe Sale
			 + " FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSuccessDTO> successGroupedBySeller();
}
