package com.sena.getback.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "inventarios")
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_inventarios;

    private Integer cantidad;
    private Double precio_compra;
    private String recibo;
    private String producto;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    // constructor vacio
    public Inventario() {
    }

    public Inventario(Integer id_inventarios, Integer cantidad, Double precio_compra, String recibo, String producto, Usuario usuario) {
        super();
        this.id_inventarios = id_inventarios;
        this.cantidad = cantidad;
        this.precio_compra = precio_compra;
        this.recibo = recibo;
        this.producto = producto;
        this.usuario = usuario;
    }

    // Constructor sin ID
    public Inventario(Integer cantidad, Double precio_compra, String recibo, String producto, Usuario usuario) {
        this.cantidad = cantidad;
        this.precio_compra = precio_compra;
        this.recibo = recibo;
        this.producto = producto;
        this.usuario = usuario;
    }

    // Getters y Setters
    public Integer getId_inventarios() {
        return id_inventarios;
    }

    public void setId_inventarios(Integer id_inventarios) {
        this.id_inventarios = id_inventarios;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(Double precio_compra) {
        this.precio_compra = precio_compra;
    }

    public String getRecibo() {
        return recibo;
    }

    public void setRecibo(String recibo) {
        this.recibo = recibo;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Inventario [id_inventarios=" + id_inventarios + ", cantidad=" + cantidad + ", precio_compra=" + precio_compra + ", recibo=" + recibo + ", producto=" + producto + ", usuario=" + usuario + "]";
    }
}