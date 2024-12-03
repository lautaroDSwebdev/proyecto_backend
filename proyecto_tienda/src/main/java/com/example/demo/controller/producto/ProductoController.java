package com.example.demo.controller.producto;

import com.example.demo.entity.producto.ProductoEntity;
import com.example.demo.service.producto.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prod")
public class ProductoController {

    @Autowired
    private IProductoService prod_service;


    @GetMapping("/get")
    public List<ProductoEntity> getProducts(){
        return prod_service.getProductos();
    }
    @GetMapping("/get/{codigo_producto}")
    public ResponseEntity<?> getProducts(@PathVariable Long codigo_producto){
        for (ProductoEntity  e  : prod_service.getProductos() ) {
            if(e.getCodigo_producto().equals(codigo_producto)){
                return ResponseEntity.ok(e);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se pudo encontrar");
    }


//    @GetMapping("/get/falta_stock")
//    public ProductoEntity getProductosQantStock(){
//        for (ProductoEntity i  : prod_service.getProductosQantStock()) {
//            if( i.getStock() < 5){
//                return prod_service;
//            }
//        }
//        return null;
//    }
    @PostMapping("/post")
    public String postProducts(@RequestBody ProductoEntity e ){
        prod_service.postProductos(e);
        return "Producto creado";
    }
    @DeleteMapping("/del")
    public String delProducts(@PathVariable Long id ){
        prod_service.deleteProductos(id);
        return "Producto eliminado";
    }
    @PutMapping("/put/{id_original}")
    public ProductoEntity putProducts(@PathVariable Long id_original,
                                      @RequestParam(required = false, name = "nombre")String new_name,
                                      @RequestParam(required = false, name = "marca")String new_marca,
                                      @RequestParam(required = false, name = "costo")double new_costo,
                                      @RequestParam(required = false, name = "stock")int new_stock){
        prod_service.putProductos(id_original, new_name , new_marca, new_costo, new_stock);

        ProductoEntity put_prod = prod_service.findProductos(id_original);
        return put_prod;
    }

}
