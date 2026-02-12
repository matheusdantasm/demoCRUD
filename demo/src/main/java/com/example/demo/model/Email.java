package com.example.model;

public class Email {

    private String valor;

    public Email(String valor) {
        if (!valor.contains("@")) {
            throw new IllegalArgumentException("Email inválido");
        }
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}