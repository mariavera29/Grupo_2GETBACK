package com.sena.getback.service;

import java.util.List;

import com.sena.getback.model.Evento;

public interface IEventoService {
	
	public Evento save(Evento evento);
	public void update(Evento evento);
	public void delete(Evento evento);
	List<Evento> findAll();
}
