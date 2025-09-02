package com.sena.getback.service;

import java.util.List;

import com.sena.getback.model.Evento;
import com.sena.getback.model.Pedido;

public interface IPedidoService {
	List<Pedido> findAll();
	public String generarNumeroOrden();
	public Evento save(Evento evento);
	public void update(Evento evento);
	public void delete(Evento evento);

}
