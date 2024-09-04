package br.com.fiap.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("produto")
public class ProdutoController {

    @GetMapping("cadastrar")
    public String cadastrar(){
        return "produto/cadastro";
    }

    @PostMapping("cadastrar")
    public String churros(String nome, Double preco, Model model){
        model.addAttribute("nome",nome);
        model.addAttribute("preco",preco);
        System.out.println("Passei aki" + nome + " " + preco);
        return "produto/cadastro";
    }

}
