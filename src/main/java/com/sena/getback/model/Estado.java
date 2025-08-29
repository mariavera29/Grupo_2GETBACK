package com.sena.getback.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "estados")
public class Estado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nombreEstado;

	// Un estado puede estar asociado a muchos usuarios
	@OneToMany(mappedBy = "estado")
	private List<Usuario> usuarios;

	
	@OneToMany(mappedBy = "estado")
	private List<Cocina> cocinas;


	@OneToMany(mappedBy = "estado")
	private List<Bar> bares;

	// Un estado puede estar asociado a muchos pedidos
	@OneToMany(mappedBy = "estado")
	private List<Pedido> pedidos;

	public Estado() {
	}

	public Estado(Integer id, String nombreEstado) {

		this.id = id;
		this.nombreEstado = nombreEstado;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombreEstado() {
		return nombreEstado;
	}

	public void setNombreEstado(String nombreEstado) {
		this.nombreEstado = nombreEstado;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Cocina> getCocinas() {
		return cocinas;
	}

	public void setCocinas(List<Cocina> cocinas) {
		this.cocinas = cocinas;
	}

	public List<Bar> getBares() {
		return bares;
	}

	public void setBares(List<Bar> bares) {
		this.bares = bares;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	@Override
	public String toString() {
		return "Estado [id=" + id + ", nombreEstado=" + nombreEstado + "]";
	}

}