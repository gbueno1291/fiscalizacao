package com.fiscalizacao;

import com.fiscalizacao.utils.Utils;

public class appTeste {

	public static void main(String[] args) {
		
		String cpf = "392.350.648-13";
		boolean valido  = Utils.isCPF(cpf);
		System.out.println(valido);
	}
}
