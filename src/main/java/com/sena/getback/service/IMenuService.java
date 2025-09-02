package com.sena.getback.service;

import java.util.List;

import com.sena.getback.model.Menu;


public interface IMenuService {
	
	List<Menu> findAll();
	public Menu save(Menu menu);
	public void update(Menu menu);
	public void delete(Menu menu);


}
