package com.fiscalizacao.utils;

import java.text.Normalizer;

public class Utils {
  private static Utils instance;
  
	private Utils() {
		super();
	}

	public static Utils getInstance() {
		if(instance == null) instance  = new Utils();		   
		   return instance; 
	}
		
	public String stringNormalize(String texto) {
		return Normalizer.normalize(texto, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
	}
}
