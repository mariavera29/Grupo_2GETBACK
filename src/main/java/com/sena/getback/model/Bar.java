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
@Table(name = "bar") 
public class Bar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bar") 
    private Integer idBar;

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
    public Bar() {
    }

    // Constructor completo
    public Bar(Integer idBar, Pedido pedido, Usuario usuario, Estado estado) {
        super();
        this.idBar = idBar;
        this.pedido = pedido;
        this.usuario = usuario;
        this.estado = estado;
    }

   
    // Getters y Setters
    public Integer getIdBar() {
        return idBar;
    }

    public void setIdBar(Integer idBar) {
        this.idBar = idBar;
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
        return "Bar [idBar=" + idBar + ", pedido=" + pedido + ", usuario=" + usuario + ", estado=" + estado + "]";
    }
}