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

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "pessoa")
public class Pessoa implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
   
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	    
	    @ManyToOne
	    @JoinColumn(name = "tipo_pessoa_id")
	    public TipoPessoa tipoPessoa;
	    
	    @Column(name = "nome_razao_social")
	    public String nome;
	    
	    @Column(name = "cpf_cnpj")
	    public String cpf;
	    
	    @Column(name = "rg_ie")
	    public String rg;
	    
	    @Column(name = "logo_imagem")
	    public String logo;
	    
	    @OneToMany(mappedBy="pessoa", fetch = FetchType.LAZY)
		public List<Contato> contato;
	    
	    @OneToMany(mappedBy = "pessoa", fetch = FetchType.LAZY)
	    public List<Endereco> endereco;
}
