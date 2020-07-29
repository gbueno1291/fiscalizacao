package com.fiscalizacao.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="contribuinte")
public class Contribuinte implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="cadastro")
	@NotNull
    private int cadastro; 
	
	@Column(name="nome")
	@NotNull
    private String nome;
	
	@Column(name="cpf")
	@NotNull
    private String cpf; 
	
	@Column(name="celular")
	@NotNull
    private String celular;
	
	@Column(name="telefone")
	@NotNull
    private String telefone; 
	
	@Column(name="email")
	@NotNull
    private String email; 
	
	@ManyToOne
	@JoinColumn(name="logradouroid")
    private Logradouros logradouro; 
	
	@Column(name="numero")
	@NotNull
    private String numero;
	
	@Column(name="complemento")
	@NotNull
    private String complemento; 
	
	@Column(name = "latitude")
	private String latitude;
	
	@Column(name = "logitude")
	private String logitude;
	
	
	@OneToMany(mappedBy="contribuinteid", fetch = FetchType.LAZY)
	public List<Imovel> imovel;
	

}
