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
<<<<<<< Updated upstream
import javax.validation.constraints.Size;
=======
>>>>>>> Stashed changes

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="cidades")
public class Cidades implements Serializable{

	private static final long serialVersionUID = 1L;
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "nome")
	@NotNull
<<<<<<< Updated upstream
	@Size(min= 3, max = 30)
	private  String nome;
	
	@Column(name = "uf")
	@NotNull
	private String uf;
=======
	public  String nome;
>>>>>>> Stashed changes
	
    @ManyToOne
    @JoinColumn(name = "uf")
	public Uf uf;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((uf == null) ? 0 : uf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cidades other = (Cidades) obj;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (uf == null) {
			if (other.uf != null)
				return false;
		} else if (!uf.equals(other.uf))
			return false;
		return true;
	}
    
	
}
