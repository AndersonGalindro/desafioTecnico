package com.tinnova.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/somaDosMultiplosDe3e5")
@SuppressWarnings({ "rawtypes", "unchecked" })
public class SomaDosMultiplosDe3e5 {

	@GetMapping
	public ResponseEntity<?> somaDosMultiplos(@RequestParam Integer numero) {

		int soma = 0;

		for (int i = 0; i < numero; i++) {
			if (i % 3 == 0 || i % 5 == 0) {
				soma += i;
			}
		}

		return new ResponseEntity("A soma dos multiplos de 3 e 5 abaixo de " + numero + " é: " + soma, HttpStatus.OK);
	}

}
