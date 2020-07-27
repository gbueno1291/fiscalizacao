package com.fiscalizacao.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name="uf")
public class Uf implements Serializable{

	/**
	 * DESENVOLVIDO POR GILIARDI BUENO
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@Column(name="nome")
	@NotNull
    public String nome;
	
	@Column(name="codigo")
	@NotNull
    public int codigo;
	
	@Column(name="sigla")
	@NotNull
    public String sigla;

	
}
