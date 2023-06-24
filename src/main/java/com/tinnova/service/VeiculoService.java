package com.tinnova.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tinnova.entity.Veiculo;
import com.tinnova.enums.Marca;
import com.tinnova.repository.VeiculoRepository;

@Service
public class VeiculoService {

	@Autowired
	VeiculoRepository veiculoRepository;

	public ResponseEntity<?> findAll() {
		return new ResponseEntity<>(veiculoRepository.findAll(), HttpStatus.OK);
	}

	public ResponseEntity<?> findById(Integer id) {
		return new ResponseEntity<>(optionalFindById(id), HttpStatus.OK);
	}

	public ResponseEntity<?> save(Veiculo veiculo) {

		veiculo.setCreated(LocalDate.now());

		return new ResponseEntity<>(veiculoRepository.save(veiculo), HttpStatus.CREATED);

	}

	public ResponseEntity<?> findByMarcaOrAno(String marca, Integer ano) {
		return new ResponseEntity<>(
				veiculoRepository.findByMarcaOrAno(marca != null ? Marca.valueOf(marca.toUpperCase()) : null, ano),
				HttpStatus.OK);
	}

	public ResponseEntity<?> put(Integer id, Veiculo veiculo) {

		veiculo.setId(id);
		veiculo.setUpdated(LocalDate.now());

		return new ResponseEntity<>(veiculoRepository.save(veiculo), HttpStatus.OK);

	}

	private Optional<Veiculo> optionalFindById(Integer id) {
		return veiculoRepository.findById(id);
	}

	public ResponseEntity<?> patch(Integer id, Veiculo veiculo) {

		Optional<Veiculo> veiculoBuilder = veiculoRepository.findById(id);
		if (veiculoBuilder.isPresent()) {

			veiculoBuilder.get().setAno(veiculo.getAno() == null ? veiculoBuilder.get().getAno() : veiculo.getAno());
			veiculoBuilder.get().setDescricao(
					veiculo.getDescricao() == null ? veiculoBuilder.get().getDescricao() : veiculo.getDescricao());
			veiculoBuilder.get()
					.setMarca(veiculo.getMarca() == null ? veiculoBuilder.get().getMarca() : veiculo.getMarca());
			veiculoBuilder.get()
					.setNome(veiculo.getNome() == null ? veiculoBuilder.get().getNome() : veiculo.getNome());
			veiculoBuilder.get().setUpdated(LocalDate.now());

			return new ResponseEntity<>(veiculoRepository.save(veiculoBuilder.get()), HttpStatus.OK);

		} else {

			return new ResponseEntity<>("Falha ao atualizar", HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	public ResponseEntity<?> deleteById(Integer id) {

		if (optionalFindById(id).isPresent()) {

			veiculoRepository.deleteById(id);

			return new ResponseEntity<>("Deletado com sucesso", HttpStatus.OK);

		} else {
			return new ResponseEntity<>("Falha ao deletar", HttpStatus.NOT_FOUND);

		}
	}

	public ResponseEntity<?> countByVendidoFalse() {
		return new ResponseEntity<>(veiculoRepository.countByVendidoFalse(), HttpStatus.OK);
	}

	public ResponseEntity<?> countByAnoBetween(int start, int end) {
		return new ResponseEntity<>(veiculoRepository.countByAnoBetween(start, end), HttpStatus.OK);
	}

	public ResponseEntity<?> countByMarcaContaining() {
		return new ResponseEntity<>(veiculoRepository.countByMarcaContaining(), HttpStatus.OK);
	}

	public ResponseEntity<?> findByCreatedGreaterThanEqual() {

		return new ResponseEntity<>(veiculoRepository.findByCreatedGreaterThanEqual(LocalDate.now().minusDays(7)),
				HttpStatus.OK);

	}

}
