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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("livro")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @PostMapping("excluir")
    @Transactional
    public String remover(Long idBook, RedirectAttributes redirectAttributes){
        livroRepository.deleteById(idBook);
        redirectAttributes.addFlashAttribute("msg", "Livro removido!");
        return "redirect:/livro/listar";
    }

    @PostMapping("editar")
    @Transactional
    public String editar(Livro livro, RedirectAttributes redirectAttributes){
        livroRepository.save(livro);
        redirectAttributes.addFlashAttribute("msg", "Livro atualizado");
        return "redirect:/livro/listar";
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
    public String cadastrar(Livro livro, RedirectAttributes redirectAttributes){
        livroRepository.save(livro);
        redirectAttributes.addFlashAttribute("msg", "Livro registrado!");
        return "redirect:/livro/cadastrar";
    }

}
