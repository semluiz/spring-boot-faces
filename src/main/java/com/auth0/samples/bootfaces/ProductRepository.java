package com.auth0.samples.bootfaces;

import com.auth0.samples.bootfaces.controller.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
