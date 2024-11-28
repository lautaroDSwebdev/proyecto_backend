package com.example.demo.repository.producto;

import com.example.demo.entity.producto.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepo extends JpaRepository<ProductoEntity, Long> {

}
