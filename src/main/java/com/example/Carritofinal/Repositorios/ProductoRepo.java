package com.example.Carritofinal.Repositorios;
import com.example.Carritofinal.Entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepo extends JpaRepository <Producto, Long> {
    boolean existsById(Long id);

}


