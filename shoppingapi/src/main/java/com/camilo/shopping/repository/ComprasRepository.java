package com.camilo.shopping.repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.camilo.shopping.domain.Compra;

@RepositoryRestResource(path = "/compras", collectionResourceRel = "compras")
public interface ComprasRepository extends CrudRepository<Compra, Long> {

	@RestResource(path = "valor-exato", rel = "valor-exato")
	public List<Compra> findByValor(@Param("valor") BigDecimal valor);	

	@RestResource(path = "ordena-valor-ascendente", rel = "ordena-valor-ascendente")
	public List<Compra> findAllByOrderByValorAsc();

	@RestResource(path = "ordena-valor-descendente", rel = "ordena-valor-descendente")
	public List<Compra> findAllByOrderByValorDesc();

	@RestResource(path = "valor-entre", rel = "valor-entre")
	@Query("SELECT c FROM Compra c WHERE c.valor BETWEEN :min AND :max ORDER BY c.valor")
	public List<Compra> findValorBetween(@Param("min") BigDecimal min, @Param("max") BigDecimal max);

	@RestResource(path = "valor-maior-que", rel = "valor-maior-que")
	@Query("SELECT c FROM Compra c WHERE c.valor >= :valor ORDER BY c.valor")
	public List<Compra> findByValorGreaterThan(@Param("valor") BigDecimal valor);

	@RestResource(path = "valor-menor-que", rel = "valor-menor-que")
	@Query("SELECT c FROM Compra c WHERE c.valor <= :valor ORDER BY c.valor")
	public List<Compra> findByValorLessThan(@Param("valor") BigDecimal valor);

	@RestResource(path = "data-exata", rel = "data-exata")
	public List<Compra> findByData(@Param("data") Date data);	

	@RestResource(path = "ordena-data-ascendente", rel = "ordena-data-ascendente")
	public List<Compra> findAllByOrderByDataAsc();

	@RestResource(path = "ordena-data-descendente", rel = "ordena-data-descendente")
	public List<Compra> findAllByOrderByDataDesc();

	@RestResource(path = "data-entre", rel = "data-entre")
	@Query("SELECT c FROM Compra c WHERE c.data BETWEEN :min AND :max ORDER BY c.data")
	public List<Compra> findValorBetween(@Param("min") Date min, @Param("max") Date max);

	@RestResource(path = "data-maior-que", rel = "data-maior-que")
	@Query("SELECT c FROM Compra c WHERE c.data >= :data ORDER BY c.data")
	public List<Compra> findByValorGreaterThan(@Param("data") Date valor);

	@RestResource(path = "data-menor-que", rel = "data-menor-que")
	@Query("SELECT c FROM Compra c WHERE c.data <= :data ORDER BY c.data")
	public List<Compra> findByValorLessThan(@Param("data") Date valor);
}
