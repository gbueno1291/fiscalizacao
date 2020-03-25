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
@Table(name="imovel")
public class Imovel implements Serializable {

   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
   
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   
   @Column(name="cadastro")
   @NotNull
   public int cadastro;
   
   @ManyToOne
   @JsonBackReference
   @JoinColumn(name="contribuinteid")
   public Contribuinte contribuinteid;
   
   @Column(name="setor")
   @NotNull
   private int setor;
   
   @Column(name="quadra")
   @NotNull
   private int quadra;
   
   @Column(name="lote")
   @NotNull
   private String lote;
   
   @Column(name="valorvenalterreno")
   @NotNull
   private float valorvenalterreno;
   
   @Column(name="valorvenaledificacao")
   @NotNull
   private float valorvenaledificacao;
   
   @Column(name="valorvenalimovel")
   @NotNull
   private float valorvenalimovel;
   
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
   @NotNull
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
