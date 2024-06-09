package com.zaplivros.zaplivros.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioDAO funcionarioDAO;

    public void inserirFuncionario(Funcionario fun) {
        funcionarioDAO.inserirFuncionario(fun);
    }

    public List<Map<String, Object>> listarFuncionario() {
        return funcionarioDAO.listarFuncionario();
    }

    public List<Map<String, Object>> obterFuncionario(int id) {
        return funcionarioDAO.obterFuncionario(id);
    }

    public void alterarFuncionario(int id, Funcionario fun) {
        funcionarioDAO.alterarFuncionario(id, fun);
    }

    public void deletarFuncionario(int id) {
        funcionarioDAO.deletarFuncionario(id);
    }
}
