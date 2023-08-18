package com.coppel.inventario.entidad;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;


import javax.swing.*;
import java.time.LocalDate;
@Entity
@Table(name = "articulos")
public class Articulo {
    @Id
    @Column(length = 6)
    private Long sku;
    @Column(length = 15)
    private String articulo;
    @Column(length = 15)
    private String marca;
    @Column(length = 20)
    private String modelo;
    @ManyToOne
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;
    @ManyToOne
    @JoinColumn(name = "clase_id")
    private Clase clase;
    @ManyToOne
    @JoinColumn(name = "familia_id")
    private Familia familia;
    private LocalDate fechaDeAlta;
    @Column(length = 9)
    @Min(value = 0, message = "El stock debe ser positivo")
    private Long stock;
    @Column(length = 9)
    @Min(value = 0, message = "La cantidad debe ser positiva")
    private Long cantidad;
    @Column(length = 1)
    private Boolean descontinuado;
    private LocalDate fechaDeBaja;

    public Articulo() {
        this.fechaDeBaja = LocalDate.EPOCH;
        this.fechaDeAlta = LocalDate.now();
        this.descontinuado = false;
    }
    public Articulo(Long sku, String articulo, String marca, String modelo, Departamento departamento, Clase clase, Familia familia, Long stock, Long cantidad) {
        this.sku = sku;
        this.articulo = articulo;
        this.marca = marca;
        this.modelo = modelo;
        this.departamento = departamento;
        this.clase = clase;
        this.familia = familia;
        this.fechaDeAlta = LocalDate.now();
        this.stock = stock;
        this.cantidad = cantidad;
        this.descontinuado = false;
        this.fechaDeBaja = LocalDate.EPOCH;
    }

    public void actualizar(Articulo articulo) {
        if (articulo.getDescontinuado()) {
            this.fechaDeBaja = LocalDate.now();
        } else {
            this.fechaDeBaja = LocalDate.EPOCH;
        }
        if (articulo.getCantidad() <= articulo.getStock()) {
            this.cantidad = articulo.getCantidad();
        }
        if(articulo.getStock() >= articulo.getCantidad()) {
            this.stock = articulo.getStock();
        }
        this.articulo = articulo.getArticulo();
        this.marca = articulo.getMarca();
        this.modelo = articulo.getModelo();
        this.departamento = articulo.getDepartamento();
        this.clase = articulo.getClase();
        this.familia = articulo.getFamilia();
        this.descontinuado = articulo.getDescontinuado();
    }

    public Long getSku() {
        return sku;
    }

    public void setSku(Long sku) {
        this.sku = sku;
    }

    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public LocalDate getFechaDeAlta() {
        return fechaDeAlta;
    }


    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public Boolean getDescontinuado() {
        return descontinuado;
    }

    public void setDescontinuado(Boolean descontinuado) {
        this.descontinuado = descontinuado;
    }

    public LocalDate getFechaDeBaja() {
        return fechaDeBaja;
    }

    public void setFechaDeBaja(LocalDate fechaDeBaja) {
        this.fechaDeBaja = fechaDeBaja;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    public Familia getFamilia() {
        return familia;
    }

    public void setFamilia(Familia familia) {
        this.familia = familia;
    }
}

