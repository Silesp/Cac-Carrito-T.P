package com.example.Carritofinal.Entidades;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="productos")
@SQLDelete(sql = "UPDATE productos SET enabled = false WHERE id = ?")
@Where(clause = "enabled = true")

public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id", nullable = false)
    @NotNull
    private long Id;
    @Column(nullable = false)
    @NotNull
    private String Nombre;
    @Column(length = 25)
    private String Categoria;
    @NotNull
    @Column(columnDefinition = "TEXT")
    private String Descripcion;
    @Column(scale = 2)
    @NotNull
    private double Precio;
    @Column
    private int Tamaño;
    @Column(length = 150)
    @NotNull
    private String Tipo;
    @Column
    private boolean enabled = true;
    //@Transient
    @Column
    private int CantidadSolicitada;
    @Column
    private double TotalPedido;

}
