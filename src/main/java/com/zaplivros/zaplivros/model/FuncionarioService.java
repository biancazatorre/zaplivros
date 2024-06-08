package com.zaplivros.zaplivros.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FuncionarioService {

    @Autowired
    FuncionarioDAO cdao;

    public void inserirFuncionario(Funcionario fun) {
        cdao.inserirFuncionario(fun);
    }

    public List<Map<String, Object>> listarFuncionario() {
        return cdao.listarFuncionario();
    }
	public List<Map<String, Object>> obterFuncionario(int id){
		return cdao.obterFuncionario(id);
	}

    public void alterarFuncionario(Funcionario fun) {
        cdao.alterarFuncionario(fun);
    }

    public void deletarFuncionario(int id) {
        cdao.deletarFuncionario(id);
    }

}
