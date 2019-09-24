package com.algaworks.algafood.domain.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.algaworks.algafood.domain.model.Restaurante;

@Repository
public interface RestauranteRepository 
		extends CustomJpaRepository<Restaurante, Long>, RestauranteRepositoryQueries,
		JpaSpecificationExecutor<Restaurante> {

	// Errata: se um restaurante não tiver nenhuma forma de pagamento associada a ele,
	// esse restaurante não será retornado usando JOIN FETCH r.formasPagamento.
	// Para resolver isso, temos que usar LEFT JOIN FETCH r.formasPagamento
//	@Query("from Restaurante r join fetch r.cozinha join fetch r.formasPagamento")
	@Query("from Restaurante r join fetch r.cozinha left join fetch r.formasPagamento")
	List<Restaurante> findAll();
	
	List<Restaurante> queryByTaxaFreteBetween(BigDecimal taxaInicial, BigDecimal taxaFinal);
	
//	@Query("from Restaurante where nome like %:nome% and cozinha.id = :id")
	List<Restaurante> consultarPorNome(String nome, @Param("id") Long cozinha);
	
//	List<Restaurante> findByNomeContainingAndCozinhaId(String nome, Long cozinha);
	
	Optional<Restaurante> findFirstRestauranteByNomeContaining(String nome);
	
	List<Restaurante> findTop2ByNomeContaining(String nome);
	
	int countByCozinhaId(Long cozinha);
	
}
