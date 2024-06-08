package com.zaplivros.zaplivros.model;

//POJO - Plain Old Java Object
public class Funcionario {

    private int id;
    private String nome, cpf, email, telefone, senha;
    private boolean cargo;

    // Sobrecarga de construtores
    public Funcionario() {

    }

    public Funcionario(int id, String nome, String cpf, String email, String telefone, String senha, boolean cargo) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
        this.cargo = cargo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setCargo(boolean cargo) {
        this.cargo = cargo;
    }

    public int getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getSenha() {
        return senha;
    }

    public boolean getCargo() {
        return cargo;
    }

}
