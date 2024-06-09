package com.zaplivros.zaplivros.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zaplivros.zaplivros.model.Funcionario;
import com.zaplivros.zaplivros.model.FuncionarioService;

@Controller
public class IndexController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/logado")
    public String logado() {
        return "logado";
    }

    @GetMapping("/cadastroFuncionario")
    public String listar(Model model) {
        List<Map<String, Object>> lista = funcionarioService.listarFuncionario();
        model.addAttribute("lista", lista);
        return "cadastroFuncionario";
    }

    @GetMapping("/cadastroLivro")
    public String cadastroLivro() {
        return "cadastroLivro";
    }

    @GetMapping("/atualizaLivro")
    public String atualizaLivro() {
        return "atualizaLivro";
    }

    @GetMapping("/cadastrarFuncionario")
    public String cadastrarFuncionario(Model model) {
        model.addAttribute("funcionario", new Funcionario());
        return "cadastroFuncionario";
    }

    @PostMapping("/cadastrarFuncionario")
    public String cadastrarFuncionario(@ModelAttribute Funcionario fun) {
        funcionarioService.inserirFuncionario(fun);
        return "redirect:/cadastroFuncionario";
    }

    @GetMapping("/alterarFuncionario/{id}")
    public String alterarFuncionario(@PathVariable("id") int id, Model model) {
        Map<String, Object> funcionario = funcionarioService.obterFuncionario(id).get(0);
        String nome = (String) funcionario.get("nome");
        String cpf = (String) funcionario.get("cpf");
        String email = (String) funcionario.get("email");
        String telefone = (String) funcionario.get("telefone");
        String senha = (String) funcionario.get("senha");
        boolean cargo = (boolean) funcionario.get("cargo");
        model.addAttribute("funcionario", new Funcionario(id, nome, cpf, email, telefone, senha, cargo));
        return "dadosFunc";
    }

    @PostMapping("/alterarFuncionario")
    public String alterarFuncionario(@ModelAttribute Funcionario fun) {
        funcionarioService.alterarFuncionario(fun);
        return "redirect:/cadastroFuncionario";
    }

    @PostMapping("/deletarFuncionario")
    public String deletarFuncionario(@RequestParam("id") int id) {
        funcionarioService.deletarFuncionario(id);
        return "redirect:/cadastroFuncionario";
    }
}
