package com.example.demo.controller.ventas;

import com.example.demo.entity.ventas.VentasEntity;
import com.example.demo.service.ventas.IVentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
//    Ver una venta en especifico desde su codigo de venta
//    Se puede aplicar a muchos otros datos pero que sean unicos
    @GetMapping("/get/{codigo_venta}")
//    El signo de iterrogacion es para cuando no vamos a retornar un simple tipo, sinó que puede variar
    public ResponseEntity<?>  getProductosVendidos(@PathVariable Long codigo_venta ){
            for(VentasEntity  i : ven_serv.getVentas()) {
                if(i.getCodigo_venta().equals(codigo_venta)  ){

                    return ResponseEntity.ok(i);
                }
            }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La peticion no se pudo ejecutar: " + codigo_venta);
    }
    @PostMapping("/post")
    public ResponseEntity<?>  postVentas(@RequestBody VentasEntity e){
        ven_serv.postVentas(e);
         return ResponseEntity.status(HttpStatus.CREATED).body("Se creó con exito: "+ e);
    }
    @DeleteMapping("/del/{id_venta}")
    public ResponseEntity<?> deleteVentas(@PathVariable Long id_venta){
        ven_serv.deleteVentas(id_venta);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("El elemento se eliminó con exito: " + id_venta);
    }

    @PutMapping("/put")
    public VentasEntity putVentas(@RequestBody VentasEntity body){
        ven_serv.putVentas(body);
        return ven_serv.findVentas(body.getCodigo_venta());
    }
}
