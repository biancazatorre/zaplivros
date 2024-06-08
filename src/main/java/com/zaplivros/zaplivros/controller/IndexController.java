package com.zaplivros.zaplivros.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zaplivros.zaplivros.model.Funcionario;
import com.zaplivros.zaplivros.model.FuncionarioService;


@Controller
public class IndexController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping("/")
    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    
    public String index(){
        return "index";
    }


    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/cadastroFuncionario")
    public String cadastroFuncionario(Model model) {
        model.addAttribute("funcionario", new Funcionario());
        List<Map<String, Object>> funcionarios = funcionarioService.listarFuncionario();
        model.addAttribute("lista", funcionarios);
        return "cadastroFuncionario";
    }

    @PostMapping("/cadastroFuncionario")
    public String cadastroFuncionario(@ModelAttribute Funcionario fun,
            @RequestParam("administrador") boolean administrador) {
        fun.setCargo(administrador);
        funcionarioService.inserirFuncionario(fun);
        return "redirect:/cadastroFuncionario";
    }

    @GetMapping("/editarFuncionario")
    public String editarFuncionario(@RequestParam("id") int id, Model model) {
        List<Map<String, Object>> funcionarios = funcionarioService.listarFuncionario();
        Funcionario funcionario = funcionarios.stream()
                .filter(map -> (Integer) map.get("id") == id)
                .map(map -> new Funcionario(
                        (Integer) map.get("id"),
                        (String) map.get("nome"),
                        (String) map.get("cpf"),
                        (String) map.get("email"),
                        (String) map.get("telefone"),
                        (String) map.get("senha"),
                        (Boolean) map.get("cargo")))
                .findFirst()
                .orElse(null);
        model.addAttribute("funcionario", funcionario);
        model.addAttribute("lista", funcionarios);
        return "dadosFunc"; // Redireciona para a página de dadosFunc.html para edição
    }

    @PostMapping("/alterarFuncionario")
    public String alterarFuncionario(@ModelAttribute Funcionario fun,
            @RequestParam("administrador") boolean administrador) {
        fun.setCargo(administrador);
        funcionarioService.alterarFuncionario(fun);
        return "redirect:/cadastroFuncionario";
    }

    @PostMapping("/deletarFuncionario")
    public String deletarFuncionario(@RequestParam("id") int id) {
        funcionarioService.deletarFuncionario(id);
        return "redirect:/cadastroFuncionario";
    }
}