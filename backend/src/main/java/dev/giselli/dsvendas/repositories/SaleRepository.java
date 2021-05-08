package dev.giselli.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.giselli.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale,Long> {

}
