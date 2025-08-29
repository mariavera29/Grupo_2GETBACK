package com.sena.getback.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Integer numeroMesa;
	private String comentario;
	@ManyToOne
	@JoinColumn(name = "usuario_id") // FK usuario
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "menu_id") // FK menu
	private Menu menu;

	@OneToMany(mappedBy = "pedido")
	private List<Bar> bares;

	@OneToMany(mappedBy = "pedido")
	private List<Cocina> cocinas;



	@ManyToOne
	@JoinColumn(name = "estado_id")
	private Estado estado;

	public Pedido() {
	}

	public Pedido(Integer id, Integer numeroMesa, String comentario, Usuario usuario, Menu menu) {
		this.id = id;
		this.numeroMesa = numeroMesa;
		this.comentario = comentario;
		this.usuario = usuario;
		this.menu = menu;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumeroMesa() {
		return numeroMesa;
	}

	public void setNumeroMesa(Integer numeroMesa) {
		this.numeroMesa = numeroMesa;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public List<Bar> getBares() {
		return bares;
	}

	public void setBares(List<Bar> bares) {
		this.bares = bares;
	}

	public List<Cocina> getCocinas() {
		return cocinas;
	}

	public void setCocinas(List<Cocina> cocinas) {
		this.cocinas = cocinas;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", numeroMesa=" + numeroMesa + ", comentario=" + comentario + "]";
	}

}
