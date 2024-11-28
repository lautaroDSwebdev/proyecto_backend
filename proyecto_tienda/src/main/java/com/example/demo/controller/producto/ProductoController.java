package com.example.demo.controller.producto;

import com.example.demo.entity.producto.ProductoEntity;
import com.example.demo.service.producto.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
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
//    @GetMapping("/get/falta_stock")
//    public String getProductosQantStock(){
//        if (prod_service.getProductosQantStock() < 5){
//            return "falta stock, es menor a 5, este es el stock: "
//                    + prod_service.getProductosQantStock() ;
//        }
//            return "Hay suficiente stock";
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
