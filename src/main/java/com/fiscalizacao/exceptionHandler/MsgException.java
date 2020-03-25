package com.fiscalizacao.exceptionHandler;

public class MsgException extends BackendException {
	
	private String codigoErro;
	private String mensagem;
	private String mensageSemCodigo;
	private String acao;
	
	public MsgException(String message, String codigoErro, String mensagem, String mensageSemCodigo, String acao) {
		
		super(message);
		this.codigoErro = codigoErro;
		this.mensagem = mensagem;
		this.mensageSemCodigo = mensageSemCodigo;
		this.acao = acao;
	}

	public MsgException(String message, String acao) {
		super(message);
		this.acao = acao;
	}


	

	
	

}
