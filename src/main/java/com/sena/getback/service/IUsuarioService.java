package com.sena.getback.service;

import java.util.List;
import java.util.Optional;

import com.sena.getback.model.Usuario;

public interface IUsuarioService {
	public Usuario save(Usuario usuario);
	public Optional<Usuario> get (Integer id);
	public void update(Usuario usuario);
	public void delete(Integer id);
	List<Usuario> findAll();

}
