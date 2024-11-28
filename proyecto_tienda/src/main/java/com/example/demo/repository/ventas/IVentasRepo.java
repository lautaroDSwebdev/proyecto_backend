package com.example.demo.repository.ventas;

import com.example.demo.entity.ventas.VentasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVentasRepo extends JpaRepository<VentasEntity, Long> {

}
