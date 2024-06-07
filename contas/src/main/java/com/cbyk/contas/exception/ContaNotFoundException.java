package com.cbyk.contas.exception;
public class ContaNotFoundException extends RuntimeException {
    public ContaNotFoundException(Long id) {
        super("Conta não encontrada com id: " + id);
    }
}

