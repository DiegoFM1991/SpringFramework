package com.entra21_Spring.entra21_Spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ResponseEntity<Fabricante> salvar(@RequestBody Fabricante f) {
		Fabricante fabricante = fabricanteRepository.save(f);
		return new ResponseEntity<Fabricante>(fabricante, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/listatodos")
	@ResponseBody
	public ResponseEntity<List<Fabricante>> listaFabricante() {
		List<Fabricante> fabricante = fabricanteRepository.findAll();
		return new ResponseEntity<List<Fabricante>>(fabricante, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/delete")
	@ResponseBody
	public ResponseEntity<String> delete(@RequestParam Long id) {
		fabricanteRepository.deleteById(id);
		return new ResponseEntity<String>("Fabricante removido com sucesso!", HttpStatus.OK);
	}
	
	@GetMapping(value = "/fabricanteID")
	@ResponseBody
	public ResponseEntity<Fabricante> fabricanteID(@RequestParam(name = "id") Long id) {
		Fabricante f = fabricanteRepository.findById(id).get();
		return new ResponseEntity<Fabricante>(f, HttpStatus.OK);
	}
	
	@PutMapping(value = "/atualizar")
	@ResponseBody
	public ResponseEntity<Fabricante> atualizar(@RequestBody Fabricante f) {
		Fabricante fabricante = fabricanteRepository.saveAndFlush(f);
		return new ResponseEntity<Fabricante>(fabricante, HttpStatus.OK);
	}
	
	@GetMapping(value = "/buscarFabricanteOrigem")
	@ResponseBody
	public ResponseEntity<List<Fabricante>> buscarFabricanteOrigem(@RequestParam(name="origem") String origem) {
		List<Fabricante> f = fabricanteRepository.findByOrigem(origem);
		return new ResponseEntity<List<Fabricante>>(f, HttpStatus.OK);
	}
	
	@GetMapping(value = "/buscarFabricanteNomeLike")
	@ResponseBody
	public ResponseEntity<List<Fabricante>> buscarFabricanteNomeLike(@RequestParam(name="nome") String nome) {
		List<Fabricante> f = fabricanteRepository.findByNomeLike(nome.trim().toUpperCase());
		return new ResponseEntity<List<Fabricante>>(f, HttpStatus.OK);
	}
	
}
