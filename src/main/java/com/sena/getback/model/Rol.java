package com.sena.getback.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Rol {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;

	    private String nombre;

	    @OneToMany(mappedBy = "rol")
	    private List<Usuario> usuarios;

	    public Rol() {}

	    public Rol(Integer id, String nombre) {
	        this.id = id;
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

		public List<Usuario> getUsuarios() {
			return usuarios;
		}

		public void setUsuarios(List<Usuario> usuarios) {
			this.usuarios = usuarios;
		}

		@Override
		public String toString() {
			return "Rol [id=" + id + ", nombre=" + nombre + "]";
		}
	    
}
