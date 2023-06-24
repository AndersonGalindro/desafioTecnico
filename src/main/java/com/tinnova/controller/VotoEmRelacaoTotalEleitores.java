package com.tinnova.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/votoEmRelacaoTotalEleitores")
@SuppressWarnings({ "rawtypes", "unchecked" })
public class VotoEmRelacaoTotalEleitores {

	private static BigDecimal totalVoto = BigDecimal.valueOf(1000);
	private static BigDecimal votoValido = BigDecimal.valueOf(800);
	private static BigDecimal votoBranco = BigDecimal.valueOf(150);
	private static BigDecimal votoNull = BigDecimal.valueOf(50);

	@GetMapping
	public ResponseEntity<?> findAll() {

		Map<String, BigDecimal> map = new HashMap<String, BigDecimal>();

		map.put("Percentual de votos VALIDOS: ", percentageOfValidVotes());
		map.put("Percentual de votos BRANCOS: ", percentageOfWhiteVotes());
		map.put("Percentual de votos NULOS: ", percentageOfNullVotes());

		return new ResponseEntity(map, HttpStatus.OK);
	}

	private static BigDecimal percentageOfValidVotes() {
		return divide(votoValido);
	}

	private static BigDecimal percentageOfWhiteVotes() {
		return divide(votoBranco);
	}

	private static BigDecimal percentageOfNullVotes() {
		return divide(votoNull);
	}

	private static BigDecimal divide(final BigDecimal value) {
		return value.divide(totalVoto, 2, RoundingMode.HALF_UP);
	}

}
