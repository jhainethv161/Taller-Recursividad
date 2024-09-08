package co.edu.uniquindio.TallerRecursividad.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Producto {
    private int id;
    private float precio;
    private String nombre;
    private String categoria;
}

