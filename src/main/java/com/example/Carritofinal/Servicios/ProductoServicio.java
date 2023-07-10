package com.example.Carritofinal.Servicios;

import com.example.Carritofinal.Entidades.Producto;
import com.example.Carritofinal.Repositorios.ProductoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;


@Service
public class ProductoServicio implements ProductoServicioInter{

    @Autowired
    public ProductoRepo productoRepo;
    @Override
    public List<Producto> verProductos() {
        return productoRepo.findAll();
    }
    @Override
    public boolean agregarProducto(Producto prod) {
        if(productoRepo.existsById(prod.getId())){
            return false;
        }else {
            productoRepo.save(prod);
            return true;
        }
    }

    @Override
    public Producto buscarProducto(Long id) {
        return productoRepo.findById(id).orElse(null);
    }

    @Override
    public boolean borrarProducto(Long id) {
        if (productoRepo.existsById(id)) {
            productoRepo.deleteById(id);
            return true; // Producto borrado
        } else {
            return false;
        }
    }

    @Override
    public Producto calcularTotal(Long id, int cantidad) {
        Producto producto = productoRepo.findById(id).orElse(null);
        if (!Objects.isNull(producto) ){
            producto.setTotalPedido(producto.getPrecio() * cantidad);
            producto.setCantidadSolicitada(cantidad);
            productoRepo.save(producto);
        }
        return producto;
    }

}
