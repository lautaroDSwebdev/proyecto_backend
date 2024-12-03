package com.example.demo.controller.ventas;

import com.example.demo.entity.producto.ProductoEntity;
import com.example.demo.entity.ventas.VentasEntity;
import com.example.demo.service.producto.IProductoService;
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
    private IProductoService prod_serv;
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


//    Hacer suma de  precio de todas las ventas de ese dia (ganancia) y ver cuantas compras hubo ese dia
    @GetMapping("/get/{fecha_venta}")
    public String getMonto_Fecha(@PathVariable String fecha_venta){
        for(VentasEntity e : ven_serv.getVentas()){
//            Comparo la fecha dentro de la lista de ventas y la fecha ingresada
            if(e.getFecha_venta().equals(fecha_venta)){
               String cantidad_compras = "Hubo esta cantidad de compras este dia: ";
               int longitud_ventas =  e.getLista_prod().size();

                Double ganancia = null;
//                Acá busco en la lista de productos de la entidad productos
               for (ProductoEntity i  : prod_serv.getProductos()) {
//                   Trato de sumar la ganancia de ese dia
                    ganancia += i.getCosto();
                    return "Ganancia: " +  ganancia;
               }
               return cantidad_compras + longitud_ventas ;
            }

        }
        return "fdmkvmkdf";

    }

    @PostMapping("/post")
    public ResponseEntity<?>  postVentas(@RequestBody VentasEntity e){
        ven_serv.postVentas(e);
         return ResponseEntity.status(HttpStatus.CREATED).body("Se creó con exito");
    }
    @DeleteMapping("/del/{id_venta}")
    public ResponseEntity<?> deleteVentas(@PathVariable Long id_venta){
        ven_serv.deleteVentas(id_venta);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("El elemento  con id de: " + id_venta + " se eliminó con exito");
    }

    @PutMapping("/put")
    public VentasEntity putVentas(@RequestBody VentasEntity body){
        ven_serv.putVentas(body);
        return ven_serv.findVentas(body.getCodigo_venta());
    }
}
