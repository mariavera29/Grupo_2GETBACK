package com.sena.getback.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CajaController {

	@GetMapping("/caja/panel")

	public String panel() {
		return  "caja/caja";
	}
}
