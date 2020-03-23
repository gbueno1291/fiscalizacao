package com.fiscalizacao.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="cidades")
@NoArgsConstructor
public class Cidades implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "nome")
	@NotNull
	private  String nome;
	
	@Column(name = "uf")
	@NotNull
	private String uf;
	
	public Cidades(int id,String nome, String uf ) {
		this.id = id;
		this.nome = nome;
		this.uf = uf;
	}
	
}
