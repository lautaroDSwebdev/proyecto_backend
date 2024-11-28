package com.example.demo.service.cliente;


import com.example.demo.entity.cliente.ClienteEntity;

import java.util.List;

public interface IClienteService {
    public List<ClienteEntity> getCliente();
    public void postCliente(ClienteEntity e);
    public void deleteCliente(Long id);

    public void putCliente(ClienteEntity e);
    public ClienteEntity findCliente(Long id);
}
