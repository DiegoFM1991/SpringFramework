package com.entra21_Spring.entra21_Spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.entra21_Spring.entra21_Spring.model.Fabricante;
import com.entra21_Spring.entra21_Spring.repository.FabricanteRepository;

@RestController
@RequestMapping(value = "/fabricante")
public class FabricanteController {

	@Autowired
	private FabricanteRepository fabricanteRepository;
	
	@PostMapping(value = "/salvar")
	@ResponseBody
	public ResponseEntity<Fabricante>salvar(@RequestBody Fabricante f) {
		Fabricante fabricante = fabricanteRepository.save(f);
		return new ResponseEntity<Fabricante>(fabricante,HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/listatodos")
	@ResponseBody
	public ResponseEntity<List<Fabricante>>listaFabricante() {
		List<Fabricante> fabricante = fabricanteRepository.findAll();
		return new ResponseEntity<List<Fabricante>>(fabricante, HttpStatus.OK);
	}
}
