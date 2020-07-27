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
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="emitente")
public class Emitente implements Serializable{
   /* Autor: Giliardi Bueno*/
	
	public static final long SerialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="razao_social")
	@NotNull
	private String razao_social;
	
	@Column(name="nome_fantasia")
	@NotNull
	private String nome_fantasia;
	
	@Column(name="cnpj")
	@NotNull
	private String cnpj;
	
	@Column(name="logo")
	@NotNull
	private String logo;
	
	@Column(name="telefone")
	@NotNull
	private String telefone;
	
	@Column(name="email")
	@NotNull
	private String email;
	
	@Column(name="site")
	@NotNull
	private String site;
	
	@Column(name="cep")
	@NotNull
	private String cep;
	 
	@Column(name="logradouro")
	@NotNull
	private String logradouro;
	
	@Column(name="numero")
	@NotNull
	private String numero;
	
	@Column(name="complemento")
	private String complemento;
	
	@Column(name="bairro")
	@NotNull
	private String bairro;
	
	@Column(name="cidade")
	@NotNull
	private String cidade;
	
	@Column(name="uf")
	@NotNull
	private String uf;
	
}
