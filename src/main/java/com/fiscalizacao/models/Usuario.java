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
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
@Table(name="usuario")
public class Usuario implements Serializable {
	
	/**
	 *  Autor: Giliardi de souza Bueno
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
   
   @Column(name="nome")
   @NotNull
   private String nome;
   
   @Column(name="cpf")
   @NotNull
   private String cpf;
   
   @Column(name="matricula")
   @NotNull
   private String matricula;
   
   @Column(name="foto")
   private String foto;
   
   
   @Column(name="celular")
   private String celular;
   
   @Column(name="login")
   @NotNull
   private String login;
   
   @Column(name="senha")
   @NotNull
   private String senha;
   
   @Column(name="status")
   private int status;
   
   @ManyToOne
   @JsonBackReference
   @JoinColumn(name="tipouser")
   public TipoUsuario tipouser;

   
}
