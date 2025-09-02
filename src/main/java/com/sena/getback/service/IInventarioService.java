package com.sena.getback.service;

import java.util.List;


import com.sena.getback.model.Inventario;

public interface IInventarioService {
	List<Inventario> findAll();
	public Inventario save(Inventario inventario );
	public void update(Inventario inventario );
	public void delete(Inventario inventario );

}
