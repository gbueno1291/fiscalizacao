package com.fiscalizacao.models;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;



import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="bairro")
public class Bairro  implements Serializable {

	/**
	 *  Autor: Giliardi de souza Bueno
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "setor_id")
	@NotNull
	private int setor_id;
	
	@Column(name = "descricao")
	@NotNull
	private String descricao;
	
	@Column(name = "data_criacao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date data_criacao;
	
	@Column(name="data_alteracao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date data_alteracao;
	
	public Bairro() {
		super();
		this.data_criacao = Calendar.getInstance().getTime();
		
	}
}
