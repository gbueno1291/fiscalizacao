package com.fiscalizacao.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="tipousuario")
public class TipoUsuario implements Serializable{

	/**
	 *  Autor: Giliardi de souza Bueno
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "descricao")
	@NotNull
	private String descricao;
	
	@OneToMany(mappedBy="tipouser", fetch = FetchType.LAZY)
	public List<Usuario> usuario;
}
