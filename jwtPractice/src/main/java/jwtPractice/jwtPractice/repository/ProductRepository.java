package jwtPractice.jwtPractice.repository;

import jwtPractice.jwtPractice.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}