package com.example.demo.repository.cliente;

import com.example.demo.entity.cliente.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepo extends JpaRepository<ClienteEntity, Long> {
}
