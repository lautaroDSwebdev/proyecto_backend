package com.example.demo.service.cliente;

import com.example.demo.entity.cliente.ClienteEntity;
import com.example.demo.repository.cliente.IClienteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService{

    @Autowired
    private IClienteRepo clien_repo;
    @Override
    public List<ClienteEntity> getCliente() {
        List<ClienteEntity> get_clien = clien_repo.findAll();
        return get_clien;
    }

    @Override
    public void postCliente(ClienteEntity e) {
        clien_repo.save(e);
    }

    @Override
    public void deleteCliente(Long id) {
        clien_repo.deleteById(id);
    }

    @Override
    public ClienteEntity findCliente(Long id) {
        ClienteEntity fint_clien = clien_repo.findById(id).orElse(null);
        return fint_clien;
    }

    @Override
    public void putCliente(ClienteEntity e) {
        this.postCliente(e);
    }
}
