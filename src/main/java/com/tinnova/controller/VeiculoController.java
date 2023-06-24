package com.tinnova.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tinnova.entity.Veiculo;
import com.tinnova.service.VeiculoService;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {

	@Autowired
	VeiculoService veiculoService;

	@GetMapping("/findAll")
	public ResponseEntity<?> findAll() {
		return veiculoService.findAll();
	}

	@GetMapping
	public ResponseEntity<?> findByMarcaOrAno(@RequestParam(required = false) String marca,
			@RequestParam(required = false) Integer ano) {
		return veiculoService.findByMarcaOrAno(marca, ano);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		return veiculoService.findById(id);
	}

	@PostMapping
	public ResponseEntity<?> save(@RequestBody Veiculo veiculo) {

		return veiculoService.save(veiculo);

	}

	@PutMapping("/{id}")
	public ResponseEntity<?> put(@PathVariable Integer id, @RequestBody Veiculo veiculo) {

		return veiculoService.put(id, veiculo);

	}

	@PatchMapping("/{id}")
	public ResponseEntity<?> patch(@PathVariable Integer id, @RequestBody Veiculo veiculo) {

		return veiculoService.patch(id, veiculo);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Integer id) {

		return veiculoService.deleteById(id);

	}

	@GetMapping("/countByVendidoFalse")
	public ResponseEntity<?> countByVendidoFalse() {
		return veiculoService.countByVendidoFalse();
	}

	@GetMapping("/countByAnoBetween")
	public ResponseEntity<?> countByAnoBetween(@RequestParam int start, @RequestParam int end) {
		return veiculoService.countByAnoBetween(start, end);
	}

	@GetMapping("/countByMarcaContaining")
	public ResponseEntity<?> countByMarcaContaining() {
		return veiculoService.countByMarcaContaining();
	}

	@GetMapping("/findByCreatedGreaterThanEqual")
	public ResponseEntity<?> findByCreatedGreaterThanEqual() {
		return veiculoService.findByCreatedGreaterThanEqual();
	}

}
