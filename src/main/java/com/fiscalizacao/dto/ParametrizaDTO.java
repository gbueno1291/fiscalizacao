package com.fiscalizacao.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fiscalizacao.models.Parametriza;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class ParametrizaDTO {
   private int id;
   private BigDecimal valorUfm;
   private BigDecimal valTerreno;
   private BigDecimal precoMQ;
   private Date ano;
   
   public Parametriza transFormaParaObj() {
	   return new Parametriza(id, valorUfm, valTerreno, precoMQ, ano);
   }
}
