package com.example.demo.entity.ventas;

import com.example.demo.entity.cliente.ClienteEntity;
import com.example.demo.entity.producto.ProductoEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@Entity
public class VentasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long codigo_venta;
    private String fecha_venta;
    private Double total;

    @OneToMany
    private List<ProductoEntity> lista_prod;

    @OneToOne
    @JoinColumn(name = "un_cliente_id_cliente" , referencedColumnName = "id_cliente" )
    private ClienteEntity unCliente;

    public VentasEntity() {
    }

    public VentasEntity(Long codigo_venta, String fecha_venta,
                        Double total,
                        List<ProductoEntity> lista_prod,
                        ClienteEntity unCliente) {
        this.codigo_venta = codigo_venta;
        this.fecha_venta = fecha_venta;
        this.total = total;
        this.lista_prod = lista_prod;
        this.unCliente = unCliente;
    }



}
