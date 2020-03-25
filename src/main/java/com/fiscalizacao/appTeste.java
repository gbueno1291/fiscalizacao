package com.fiscalizacao;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fiscalizacao.utils.Utils;

public class appTeste {

	public static void main(String[] args) {
		
		System.out.println(new BCryptPasswordEncoder().encode("123456"));
	}
}
