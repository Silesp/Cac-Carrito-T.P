package com.example.Carritofinal.Servicios;
import com.example.Carritofinal.Entidades.Producto;
import java.util.List;

public interface ProductoServicioInter {
    public List<Producto> verProductos();
    public boolean agregarProducto(Producto prod);
    public Producto buscarProducto(Long id);
    public Producto calcularTotal(Long id, int cantidad);
    public boolean borrarProducto(Long id);

}
