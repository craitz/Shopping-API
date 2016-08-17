package com.camilo.shopping.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.camilo.shopping.domain.CategoriaProduto;

@RepositoryRestResource(path = "/categoriasProduto", collectionResourceRel = "categoriasProduto")
public interface CategoriasProdutoRepository extends CrudRepository<CategoriaProduto, Long> {

	@RestResource(path = "nome-comeca-com", rel = "nome-comeca-com")
	public List<CategoriaProduto> findByNomeStartsWith(@Param("nome") String nome);	

	@RestResource(path = "nome-termina-com", rel = "nomeTerminaCom")
	public List<CategoriaProduto> findByNomeEndsWith(@Param("nome") String nome);	

	@RestResource(path = "nome-contem", rel = "nomeContem")
	public List<CategoriaProduto> findByNomeContaining(@Param("nome") String nome);	

	@RestResource(path = "nome-exato", rel = "nomeExato")
	public List<CategoriaProduto> findByNome(@Param("nome") String nome);	
	
	@RestResource(path = "ordena-ascendente", rel = "ordenaAscendente")
	public List<CategoriaProduto> findAllByOrderByNomeAsc();
		
	@RestResource(path = "ordena-descendente", rel = "ordenaDescendente")
	public List<CategoriaProduto> findAllByOrderByNomeDesc();
}
