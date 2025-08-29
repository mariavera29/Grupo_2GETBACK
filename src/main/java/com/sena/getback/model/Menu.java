package com.sena.getback.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "menu")
public class Menu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String comida;
	private Integer cantidad;
	private Double precio;
	private String descripcion;
	private String combo;

	@OneToMany(mappedBy = "menu")
	private List<Pedido> pedidos;

	public Menu() {
	}

	public Menu(Integer id, String comida, Integer cantidad, Double precio, String descripcion, String combo,
			List<Pedido> pedidos) {
		super();
		this.id = id;
		this.comida = comida;
		this.cantidad = cantidad;
		this.precio = precio;
		this.descripcion = descripcion;
		this.combo = combo;
		this.pedidos = pedidos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getComida() {
		return comida;
	}

	public void setComida(String comida) {
		this.comida = comida;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCombo() {
		return combo;
	}

	public void setCombo(String combo) {
		this.combo = combo;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	@Override
	public String toString() {
		return "Menu [id=" + id + ", comida=" + comida + ", cantidad=" + cantidad + ", precio=" + precio
				+ ", descripcion=" + descripcion + ", combo=" + combo + "]";
	}

}
