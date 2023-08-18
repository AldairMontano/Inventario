package com.coppel.inventario.entidad;

import jakarta.persistence.*;

@Entity
@Table(name = "familias")
public class Familia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "clase_Id")
    private Clase clase;

    public Familia() {
    }

    public Familia(Integer id, String nombre, Clase clase) {
        this.id = id;
        this.nombre = nombre;
        this.clase = clase;
    }

    public Familia(Integer id) {
        this.id = id;
    }

    public Familia(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }
}
