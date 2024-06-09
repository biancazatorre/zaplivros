package com.zaplivros.zaplivros.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.zaplivros.zaplivros.model.Funcionario;
import com.zaplivros.zaplivros.model.FuncionarioService;

@Controller
public class IndexController {

    @Autowired
    private FuncionarioService funcionarioService;

    @Autowired
    private ApplicationContext context;

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

    @GetMapping("/atualizar/{id}")
    public String atualizar(@PathVariable("id") int id, Model model) {
        Map<String, Object> funcionario = funcionarioService.obterFuncionario(id).get(0);
        Funcionario fun = new Funcionario();
        fun.setId(id);
        fun.setNome((String) funcionario.get("nome"));
        fun.setCpf((String) funcionario.get("cpf"));
        fun.setEmail((String) funcionario.get("email"));
        fun.setTelefone((String) funcionario.get("telefone"));
        fun.setSenha((String) funcionario.get("senha"));
        fun.setCargo((boolean) funcionario.get("cargo"));
        model.addAttribute("funcionario", fun);
        return "dadosFunc";
    }

    @PostMapping("/atualizar/{id}")
    public String atualizar(@PathVariable("id") int id, @ModelAttribute Funcionario fun) {
        funcionarioService.alterarFuncionario(id, fun);
        return "redirect:/cadastroFuncionario";
    }

    @PostMapping("/deletar/{id}")
    public String deletar(@PathVariable("id") int id) {
        funcionarioService.deletarFuncionario(id);
        return "redirect:/cadastroFuncionario";
    }
}
