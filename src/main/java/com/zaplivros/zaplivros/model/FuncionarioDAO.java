package com.zaplivros.zaplivros.model;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class FuncionarioDAO {

    @Autowired
    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    private void initialize() {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void inserirFuncionario(Funcionario fun) {
        String sql = "INSERT INTO funcionario (nome, cpf, email, telefone, senha, cargo) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, fun.getNome(), fun.getCpf(), fun.getEmail(), fun.getTelefone(), fun.getSenha(), fun.getCargo());
    }

    public List<Map<String, Object>> listarFuncionario() {
        String sql = "SELECT * FROM funcionario";
        return jdbcTemplate.queryForList(sql);
    }

    public List<Map<String, Object>> obterFuncionario(int id) {
        String sql = "SELECT * FROM funcionario WHERE id = ?";
        return jdbcTemplate.queryForList(sql, id);
    }

    public void alterarFuncionario(int id, Funcionario fun) {
        String sql = "UPDATE funcionario SET nome = ?, cpf = ?, email = ?, telefone = ?, senha = ?, cargo = ? WHERE id = ?";
        jdbcTemplate.update(sql, fun.getNome(), fun.getCpf(), fun.getEmail(), fun.getTelefone(), fun.getSenha(), fun.getCargo(), id);
    }

    public void deletarFuncionario(int id) {
        String sql = "DELETE FROM funcionario WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
