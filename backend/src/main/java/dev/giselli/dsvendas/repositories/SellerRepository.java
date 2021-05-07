package dev.giselli.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.giselli.dsvendas.entities.Seller;

public interface SellerRepository extends JpaRepository<Seller,Long> {

}
