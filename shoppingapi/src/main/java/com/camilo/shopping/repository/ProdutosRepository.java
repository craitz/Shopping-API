package com.camilo.shopping.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.camilo.shopping.domain.Produto;

@RepositoryRestResource(path = "/produtos", collectionResourceRel = "produtos")
public interface ProdutosRepository extends CrudRepository<Produto, Long> {

	@RestResource(path = "nome-comeca-com", rel = "nome-comeca-com")
	public List<Produto> findByNomeStartsWith(@Param("nome") String nome);	

	@RestResource(path = "nome-termina-com", rel = "nome-termina-com")
	public List<Produto> findByNomeEndsWith(@Param("nome") String nome);	

	@RestResource(path = "nome-contem", rel = "nome-contem")
	public List<Produto> findByNomeContaining(@Param("nome") String nome);	

	@RestResource(path = "nome-exato", rel = "nome-exato")
	public List<Produto> findByNome(@Param("nome") String nome);	
	
	@RestResource(path = "ordena-nome-ascendente", rel = "ordena-nome-ascendente")
	public List<Produto> findAllByOrderByNomeAsc();	
		
	@RestResource(path = "ordena-nome-descendente", rel = "ordena-nome-descendente")
	public List<Produto> findAllByOrderByNomeDesc();

	@RestResource(path = "valor-exato", rel = "valor-exato")
	public List<Produto> findByValor(@Param("valor") BigDecimal valor);	

	@RestResource(path = "ordena-valor-ascendente", rel = "ordena-valor-ascendente")
	public List<Produto> findAllByOrderByValorAsc();

	@RestResource(path = "ordena-valor-descendente", rel = "ordena-valor-descendente")
	public List<Produto> findAllByOrderByValorDesc();

	@RestResource(path = "valor-entre", rel = "valor-entre")
	@Query("SELECT p FROM Produto p WHERE p.valor BETWEEN :min AND :max ORDER BY p.valor")
	public List<Produto> findValorBetween(@Param("min") BigDecimal min, @Param("max") BigDecimal max);

	@RestResource(path = "valor-maior-que", rel = "valor-maior-que")
	@Query("SELECT p FROM Produto p WHERE p.valor >= :valor ORDER BY p.valor")
	public List<Produto> findByValorGreaterThan(@Param("valor") BigDecimal valor);

	@RestResource(path = "valor-menor-que", rel = "valor-menor-que")
	@Query("SELECT p FROM Produto p WHERE p.valor <= :valor ORDER BY p.valor")
	public List<Produto> findByValorLessThan(@Param("valor") BigDecimal valor);
}
