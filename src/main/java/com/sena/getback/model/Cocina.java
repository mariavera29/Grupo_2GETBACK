package com.sena.getback.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cocina")
public class Cocina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cocina")
    private Integer idCocina;

    @ManyToOne
    @JoinColumn(name = "id_pedido") 
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_estado")
    private Estado estado;

    // constructor vacio
    public Cocina() {
    }

    // Constructor campos
    public Cocina(Integer idCocina, Pedido pedido, Usuario usuario, Estado estado) {
        super();
        this.idCocina = idCocina;
        this.pedido = pedido;
        this.usuario = usuario;
        this.estado = estado;
    }

  
    public Cocina(Pedido pedido, Usuario usuario, Estado estado) {
        this.pedido = pedido;
        this.usuario = usuario;
        this.estado = estado;
    }

    // Getters y Setters
    public Integer getIdCocina() {
        return idCocina;
    }

    public void setIdCocina(Integer idCocina) {
        this.idCocina = idCocina;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Cocina [idCocina=" + idCocina + ", pedido=" + pedido + ", usuario=" + usuario + ", estado=" + estado + "]";
    }
}