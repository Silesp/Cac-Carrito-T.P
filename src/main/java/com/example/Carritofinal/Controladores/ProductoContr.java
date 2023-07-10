package com.example.Carritofinal.Controladores;
import com.example.Carritofinal.Entidades.Producto;
import com.example.Carritofinal.Servicios.ProductoServicioInter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;


@RestController

@RequiredArgsConstructor

public class ProductoContr {
    @Autowired
    public ProductoServicioInter prodServ;
    @PostMapping("/agregar/producto")
    public ResponseEntity<String> agregarProducto(@RequestBody Producto prod) {

        boolean resultado = prodServ.agregarProducto(prod);
        if (resultado) {
            return ResponseEntity.ok("El producto se ha agregado");
        } else {
            String mensaje = "El producto no se ha agregado, ya existe un producto con el ID " + prod.getId();
            return ResponseEntity.status(HttpStatus.CONFLICT).body(mensaje);

        }
    }

    @GetMapping("/ver/productos")
    public List<Producto> verProductos() {
        return prodServ.verProductos();
    }

    @GetMapping("/consultar/{id}")
    public ResponseEntity<?> buscarProducto(@PathVariable Long id) {
        Producto producto = prodServ.buscarProducto(id);
        if (producto == null) {
            String mensaje = "El producto con el ID " + id + " no existe";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensaje);
        }
        return ResponseEntity.ok(producto);
    }

    @PatchMapping("/total/{id}/{cantidad}")
    public ResponseEntity<?> calcularTotal(@PathVariable Long id, @PathVariable int cantidad) {
        Producto producto = prodServ.calcularTotal(id, cantidad);
        if (producto == null) {
            String mensaje = "El producto con el ID " + id + " no existe";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensaje);
        }
        return ResponseEntity.ok(producto);
    }
    @DeleteMapping("/borrarProducto/{id}")
    public ResponseEntity<String> borrarProducto(@PathVariable Long id) {
        boolean productoBorrado = prodServ.borrarProducto(id);
        if (productoBorrado) {
            return ResponseEntity.ok("El producto se ha borrado exitosamente");
        } else {
            String mensaje = "El producto con el ID " + id + " no existe";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensaje);
        }
    }
}