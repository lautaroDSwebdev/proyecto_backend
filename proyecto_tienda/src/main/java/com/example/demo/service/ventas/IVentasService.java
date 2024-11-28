package com.example.demo.service.ventas;

import com.example.demo.entity.ventas.VentasEntity;

import java.util.List;
import java.util.Optional;

public interface IVentasService {
    public List<VentasEntity> getVentas();
    public Optional<VentasEntity>  getVentasByCode(Long codigo_venta);
    public void deleteVentas(Long id);
    public void postVentas(VentasEntity e);
    public VentasEntity findVentas(Long id);
    public void putVentas(VentasEntity e);
}
