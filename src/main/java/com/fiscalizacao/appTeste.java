package com.fiscalizacao;

import com.fiscalizacao.utils.Utils;

public class appTeste {

	public static void main(String[] args) {
		String texto = "Máis é um Téste apênas";
		System.out.println(Utils.getInstance().stringNormalize(texto));
	}
}
