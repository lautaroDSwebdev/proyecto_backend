package com.example.demo.service.producto;

import com.example.demo.entity.producto.ProductoEntity;
import com.example.demo.repository.producto.ProductoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService{

    @Autowired
    private ProductoRepo prod_repo;

    @Override
    public List<ProductoEntity> getProductos() {
        List<ProductoEntity> get_prod = prod_repo.findAll();
        return get_prod;
    }

    @Override
    public List<ProductoEntity> getProductosQantStock() {
        return null;
    }


    @Override
    public void postProductos(ProductoEntity e) {
        prod_repo.save(e);
    }

    @Override
    public void deleteProductos(Long id) {
        prod_repo.deleteById(id);
    }

    @Override
    public ProductoEntity findProductos(Long id) {
        ProductoEntity find_prod = prod_repo.findById(id).orElse(null);
        return find_prod;
    }

    @Override
    public void putProductos(Long id_original, String new_name,
                             String new_marca, Double new_costo,
                             int new_stock) {

    }


}
