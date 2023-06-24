package com.tinnova.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tinnova.enums.Marca;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Veiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer Id;

	String nome;

	@Enumerated(EnumType.STRING)
	Marca marca;
	Integer ano;
	String descricao;
	Boolean vendido;
	@JsonIgnore
	LocalDate created;
	@JsonIgnore
	LocalDate updated;

}
