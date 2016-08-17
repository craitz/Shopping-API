package com.camilo.shopping.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.camilo.shopping.domain.Supermercado;

@RepositoryRestResource(path = "/supermercados", collectionResourceRel = "supermercados")
public interface SupermercadosRepository extends CrudRepository<Supermercado, Long> {
		
	@RestResource(path = "nome-comeca-com", rel = "nome-comeca-com")
	public List<Supermercado> findByNomeStartsWith(@Param("nome") String nome);	

	@RestResource(path = "nome-termina-com", rel = "nomeTerminaCom")
	public List<Supermercado> findByNomeEndsWith(@Param("nome") String nome);	

	@RestResource(path = "nome-contem", rel = "nomeContem")
	public List<Supermercado> findByNomeContaining(@Param("nome") String nome);	

	@RestResource(path = "nome-exato", rel = "nomeExato")
	public List<Supermercado> findByNome(@Param("nome") String nome);	
	
	@RestResource(path = "ordena-ascendente", rel = "ordenaAscendente")
	public List<Supermercado> findAllByOrderByNomeAsc();	
		
	@RestResource(path = "ordena-descendente", rel = "ordenaDescendente")
	public List<Supermercado> findAllByOrderByNomeDesc();	
}
