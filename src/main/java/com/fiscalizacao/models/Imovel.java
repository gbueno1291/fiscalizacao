package com.fiscalizacao.models;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name="imovel")
public class Imovel implements Serializable {

   /**
	 * DESENVOLVIDO POR GILIARDI BUENO
	 */
	private static final long serialVersionUID = 1L;
   
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   
   @Column(name = "matricula")
   public String matricula;
   
   @ManyToOne
   @JoinColumn(name = "contribuinte_id")
   public Contribuinte contribuinte ;
   
   @ManyToOne
   @JoinColumn(name = "endereco_id")
   public Endereco endereco;
   
   @Column(name = "setor")
   public int setor;
   
   @Column(name = "quadra")
   public int quadra;
   
   @Column(name = "lote")
   public String lote;
   
   @Column(name = "unidade")
   public int unidade;
   
   @Column(name = "valor_venal_edificacao")
   public BigDecimal valorVenalEdificacao;
   
   @Column(name = "valor_venal_terreno")
   public BigDecimal valorVenalTerreno;
   
   @Column(name = "valor_venal_excedente")
   public BigDecimal valorVenalExcedente;
   
   @Column(name = "valor_venal_imovel")
   public BigDecimal valorVenalImovel;
   
   @Column(name = "fracao_ideal")
   public int fracaoIdeal;
   
   @Column(name = "total_area_edificada")
   public BigDecimal totalAreaEdificada ;
   
   @Column(name = "espaco_reservado")
   public BigDecimal espacoReservado ;
   
   @Column(name = "area_terreno")
   public BigDecimal areaTerreno ;
   
   @Column(name = "testada_terreno")
   public BigDecimal testadaTerreno;
   
   @Column(name = "testada_taxa")
   public BigDecimal testadaTaxa;
   
   @Column(name = "profundidade")
   public BigDecimal profundidade;
   
   @Column(name = "lado_esquerdo")
   public BigDecimal ladoEsquerdo;
   
   @Column(name = "lado_direito")
   public BigDecimal ladoDireito;
   
   @Column(name = "zoneamento")
   public String zoneamento;
   
}
