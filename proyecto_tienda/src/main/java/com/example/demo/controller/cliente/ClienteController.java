package com.example.demo.controller.cliente;

import com.example.demo.entity.cliente.ClienteEntity;
import com.example.demo.service.cliente.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private IClienteService clien_ser;

    @GetMapping("/get")
    public List<ClienteEntity> getCliente(){
        return clien_ser.getCliente();
    }
    @PostMapping("/post")
    public String postCliente(@RequestBody ClienteEntity e){
        clien_ser.postCliente(e);
        return "Cliente creado";
    }

    @DeleteMapping("/del/{id}")
    public String deleteCliente(@PathVariable Long id){
        clien_ser.deleteCliente(id);
        return "Cliente eliminado";
    }

    @PutMapping("/put")
    public ClienteEntity putCliente(@RequestBody ClienteEntity e){
        clien_ser.putCliente(e);
        return clien_ser.findCliente(e.getId_cliente());
    }
}
