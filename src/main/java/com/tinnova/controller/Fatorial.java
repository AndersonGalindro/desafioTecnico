package com.tinnova.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fatorial")
@SuppressWarnings({ "rawtypes", "unchecked" })
public class Fatorial {

	@GetMapping
	public ResponseEntity<?> somaDosMultiplos(@RequestParam Integer numero) {

		double resultado = numero;

		while (numero > 1) {

			resultado = resultado * (numero - 1);
			numero--;
		}

		return new ResponseEntity("Fatorial " + numero + " é: " + resultado, HttpStatus.OK);
	}

}
