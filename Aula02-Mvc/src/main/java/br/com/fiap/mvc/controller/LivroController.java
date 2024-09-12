package br.com.fiap.mvc.controller;

import br.com.fiap.mvc.model.Livro;
import br.com.fiap.mvc.respository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("livro")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @GetMapping("cadastrar")
    public String cadastrar(Livro livro){
        return "livro/cadastro";
    }

    @PostMapping("cadastrar")
    @Transactional
    public String cadastrar(Livro livro, Model model){
        livroRepository.save(livro);
        model.addAttribute("msg", "Livro registrado!");
        return "livro/cadastro";
    }

}
