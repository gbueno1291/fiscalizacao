package com.fiscalizacao.exceptionHandler;

public enum Errors {

    // @formatter:off
    ERRO_1("Erro ao fodao!!"),
    ERRO_2("CPF informado é inválido"),
	ERRO_99("Erro inexperado"), ;
    // @formatter:on

    private String errorCode;
    private String errorMessage;

    private Errors(String errorMessage) {
        this.errorCode = name().substring(3);
        this.errorMessage = errorMessage;
    }

    public String format(Object... params) {
        return String.format(errorMessage, params);
    }

    public String getCode() {
        return errorCode;
    }

    public String getMessage() {
        return errorMessage;
    }
}