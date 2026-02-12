package com.example.demo.model;

public class Usuario {

    private Long id;
    private String nome;
    private Email email;

    // Construtor vazio (necessário para frameworks)
    public Usuario() {
    }

    // Construtor completo
    public Usuario(Long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = new Email(email);
    }

    // Construtor sem id
    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = new Email(email);
    }

    // Getters

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Email getEmail() {
        return email;
    }

    // Setters básicos (opcional manter apenas id)

    public void setId(Long id) {
        this.id = id;
    }

    // Métodos de comportamento (POO real)

    public void atualizarNome(String novoNome) {
        if (novoNome == null || novoNome.isBlank()) {
            throw new IllegalArgumentException("Nome inválido");
        }
        this.nome = novoNome;
    }

    public void atualizarEmail(String novoEmail) {
        this.email = new Email(novoEmail);
    }
}