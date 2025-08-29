package com.sena.getback.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="eventos")
public class Evento {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String descripcion;
    private String multimedia;
    private Date fechaInicio;
    private Date fechaFinal;

    //Relación con Usuario
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    
    public Evento() {}

    public Evento(Integer id, String nombre, String descripcion, String multimedia, Date fechaInicio, Date fechaFinal, Usuario usuario) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.multimedia = multimedia;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.usuario = usuario;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getMultimedia() {
		return multimedia;
	}

	public void setMultimedia(String multimedia) {
		this.multimedia = multimedia;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Evento [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", multimedia=" + multimedia
				+ ", fechaInicio=" + fechaInicio + ", fechaFinal=" + fechaFinal + "]";
	}
    
}
