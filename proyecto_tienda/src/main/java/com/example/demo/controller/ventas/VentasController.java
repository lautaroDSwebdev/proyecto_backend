package com.example.demo.controller.ventas;

import com.example.demo.entity.ventas.VentasEntity;
import com.example.demo.service.ventas.IVentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/ventas")
public class VentasController {
    @Autowired
    private IVentasService ven_serv;
    @GetMapping("/get")
    public List<VentasEntity> getVentas(){
        return ven_serv.getVentas();
    }
    @PostMapping("/post")
    public String  postVentas(@RequestBody VentasEntity e){
        ven_serv.postVentas(e);
         return "Venta creada con exito";
    }
    @DeleteMapping("/del/{id_venta}")
    public String deleteVentas(@PathVariable Long id_venta){
        ven_serv.deleteVentas(id_venta);
        return "Venta eliminada";
    }

    @PutMapping("/put")
    public VentasEntity putVentas(@RequestBody VentasEntity body){
        ven_serv.putVentas(body);
        return ven_serv.findVentas(body.getCodigo_venta());
    }
}
