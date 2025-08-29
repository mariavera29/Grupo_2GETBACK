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
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String apellido;
	private String telefono;
	private String direccion;
	private String correo;
	private String clave;

	// Relación con Rol
	@ManyToOne
	@JoinColumn(name = "rol_id")
	private Rol rol;

	// Relación con Estado
	@ManyToOne
	@JoinColumn(name = "estado_id")
	private Estado estado;

	// Relaciones con otras entidades :p
	@OneToMany(mappedBy = "usuario")
	private List<Inventario> inventarios;

	@OneToMany(mappedBy = "usuario")
	private List<Pedido> pedidos;

	@OneToMany(mappedBy = "usuario")
	private List<Bar> bares;

	@OneToMany(mappedBy = "usuario")
	private List<Evento> eventos;

	@OneToMany(mappedBy = "usuario")
	private List<Cocina> cocinas;

	public Usuario() {
	}

	public Usuario(Integer id, String nombre, String apellido, String telefono, String direccion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.direccion = direccion;
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono
				+ ", direccion=" + direccion + ", correo=" + correo + "]";
	}

}
