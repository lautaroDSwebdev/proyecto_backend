package com.example.demo.service.ventas;

import com.example.demo.entity.ventas.VentasEntity;
import com.example.demo.repository.ventas.IVentasRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentasService implements IVentasService{

    @Autowired
    private IVentasRepo ven_repo;
    @Override
    public List<VentasEntity> getVentas() {
        List<VentasEntity> get_ven = ven_repo.findAll();
        return get_ven;
    }

    @Override
    public Optional<VentasEntity> getVentasByCode(Long codigo_venta) {
        return Optional.empty();
    }

    @Override
    public void deleteVentas(Long id) {
        ven_repo.deleteById(id);
    }

    @Override
    public void postVentas(VentasEntity e) {
        ven_repo.save(e);

    }

    @Override
    public VentasEntity findVentas(Long id) {
        VentasEntity ven_find = ven_repo.findById(id).orElse(null);
        return ven_find;
    }

    @Override
    public void putVentas(VentasEntity e) {
        this.postVentas(e);
    }
}
