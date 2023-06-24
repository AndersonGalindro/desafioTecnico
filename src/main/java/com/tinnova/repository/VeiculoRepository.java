package com.tinnova.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tinnova.entity.Veiculo;
import com.tinnova.enums.Marca;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Integer> {

	List<Object> findByMarcaOrAno(Marca marca, Integer ano);

	Integer countByVendidoFalse();

	Integer countByAnoBetween(int start, int end);

	@Query(value = "SELECT  MARCA, COUNT(*) FROM VEICULO GROUP BY MARCA", nativeQuery = true)
	List<Object> countByMarcaContaining();

	List<Veiculo> findByCreatedGreaterThanEqual(LocalDate created);
}
