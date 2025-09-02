package com.sena.getback.service;

import java.util.Optional;

import com.sena.getback.model.Usuario;

public interface IRolService {
	Optional<Usuario> findById (Integer id);
	
	


}
