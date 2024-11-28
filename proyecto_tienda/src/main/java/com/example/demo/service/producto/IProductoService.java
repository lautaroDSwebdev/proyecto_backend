package com.example.demo.service.producto;

import com.example.demo.entity.producto.ProductoEntity;

import java.util.List;
import java.util.Optional;

public interface IProductoService {
    public List<ProductoEntity> getProductos();

    public List<ProductoEntity> getProductosQantStock();
    public void postProductos(ProductoEntity e);
    public void deleteProductos(Long id);
    public ProductoEntity findProductos(Long id);
    public  void putProductos(Long id_original, String new_name,
                              String new_marca, Double new_costo,
                              int new_stock);

}
