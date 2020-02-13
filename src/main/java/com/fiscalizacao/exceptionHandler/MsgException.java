package com.fiscalizacao.exceptionHandler;

public class MsgException extends BackendException {
	
	private final String codigoErro;
	private final String mensagem;
	private final  String mensageSemCodigo;
	private final String acao;
	
	public MsgException(String message, String codigoErro, String mensagem, String mensageSemCodigo, String acao) {
		
		super(message);
		this.codigoErro = codigoErro;
		this.mensagem = mensagem;
		this.mensageSemCodigo = mensageSemCodigo;
		this.acao = acao;
	}
	
	

}
