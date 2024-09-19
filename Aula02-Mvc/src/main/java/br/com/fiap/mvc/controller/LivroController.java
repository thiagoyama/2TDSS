package br.com.fiap.mvc.controller;

import br.com.fiap.mvc.model.Livro;
import br.com.fiap.mvc.respository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("livro")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @PostMapping("editar")
    @Transactional
    public String editar(Livro livro, Model model){
        livroRepository.save(livro);
        model.addAttribute("msg", "Livro atualizado");
        model.addAttribute("books", livroRepository.findAll());
        return "livro/lista";
    }

    @GetMapping("editar/{id}")
    public String editar(@PathVariable("id") Long id, Model model){
        //Pesquisar o livro pelo id e enviar o livro para a view
        model.addAttribute("livro", livroRepository.findById(id));
        //Retornar a view
        return "livro/editar";
    }

    @GetMapping("listar") //localhost:8080/livro/listar
    public String listar(Model model){
        //Enviar a lista de livros para a view
        model.addAttribute("books", livroRepository.findAll());
        return "livro/lista";
    }

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
