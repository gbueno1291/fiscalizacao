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

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name="departamento")
public class Departamento  implements Serializable{

	/**
	 * Desenvolvido por Giliardi Bueno
	 */
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    
    @Column(name = "nome")
    @NotNull
	private String nome;
    
    @Column(name = "divisao")
    @NotNull
	private String divisao;
    
    @Column(name = "responsavel")
    @NotNull
	private String responsavel;
    
    @ManyToOne
    @JoinColumn(name = "logradouroid")
	private Logradouros logradouro;
	
	@Column(name = "numero")
    @NotNull
	private String numero;
	
	@Column(name = "complemento")
	private String complemento;
	
	@Column(name = "latitude")
	private String latitude;
	
	@Column(name = "longitude")
	private String longitude;

	
}
