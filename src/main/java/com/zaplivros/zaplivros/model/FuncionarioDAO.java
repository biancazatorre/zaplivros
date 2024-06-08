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
    DataSource dataSource;

    JdbcTemplate jdbc;

    @PostConstruct
    private void initialize() {
        jdbc = new JdbcTemplate(dataSource);
    }

    public void inserirFuncionario(Funcionario fun) {
        String sql = "INSERT INTO funcionario(nome,cpf,email,telefone,senha,cargo)" +
                " VALUES (?,?,?,?,?,?)";
        Object[] obj = new Object[6];
        // primeiro ?
        obj[0] = fun.getNome();
        // segundo ?
        obj[1] = fun.getCpf();
        obj[2] = fun.getEmail();
        obj[3] = fun.getTelefone();
        obj[4] = fun.getSenha();
        obj[5] = fun.getCargo();
        jdbc.update(sql, obj);
    }

    public List<Map<String, Object>> listarFuncionario() {
        String sql = "SELECT * FROM funcionario";
        return jdbc.queryForList(sql);
    }

    public void alterarFuncionario(Funcionario fun){
        String sql = "UPDATE funcionario SET nome = ?, cpf = ?, email = ?, telefone = ?, senha = ?, cargo = ? WHERE id = ?";
        Object[] obj = new Object[7];
    
        obj[0] = fun.getNome();
        obj[1] = fun.getCpf();
        obj[2] = fun.getEmail();
        obj[3] = fun.getTelefone();
        obj[4] = fun.getSenha();
        obj[5] = fun.getCargo();
        obj[6] = fun.getId();
        jdbc.update(sql, obj);
    }

    public void deletarFuncionario(int id) {
        String sql = "DELETE FROM funcionario WHERE id = ?";
        Object[] obj = new Object[1];
        obj[0] = id;
        jdbc.update(sql, obj);
    }

}
