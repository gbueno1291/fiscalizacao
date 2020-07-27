package com.fiscalizacao.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="logradouros")
public class Logradouros implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="bairroID")
	public Bairros bairro;
	
	@ManyToOne
	@JoinColumn(name="tipologradouro")
	public TipoLogradouro tipologradouro;
	
	@Column(name="nome")
	public String nome;
	
	@Column(name="cep")
	public String cep;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + id;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((tipologradouro == null) ? 0 : tipologradouro.hashCode());
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
		Logradouros other = (Logradouros) obj;
		if (bairro == null) {
			if (other.bairro != null)
				return false;
		} else if (!bairro.equals(other.bairro))
			return false;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (tipologradouro == null) {
			if (other.tipologradouro != null)
				return false;
		} else if (!tipologradouro.equals(other.tipologradouro))
			return false;
		return true;
	}


}
