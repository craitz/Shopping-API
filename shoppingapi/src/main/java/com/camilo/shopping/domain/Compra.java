package com.camilo.shopping.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "compra")
public class Compra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Temporal(TemporalType.DATE)
	@NotNull(message = "o campo data é obrigatório!")
	private Date data;
	
	@NotNull(message = "o campo valor é obrigatório!")
	@Digits(integer = 6, fraction = 3, message = "O valor deve ter o formato 999999.999.")
	private BigDecimal valor;
	
	@ManyToOne
	@JoinColumn(name = "supermercado_id")
	@NotNull(message = "o campo supermercado é obrigatório!")
	private Supermercado supermercado;

	@ManyToMany
	@JoinTable(name="compra_produto", 
		joinColumns = {@JoinColumn(name = "compra_id")},
		inverseJoinColumns = {@JoinColumn(name = "produto_id")})
	private List<Produto> produtos;
	
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Supermercado getSupermercado() {
		return supermercado;
	}

	public void setSupermercado(Supermercado supermercado) {
		this.supermercado = supermercado;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compra other = (Compra) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
}
