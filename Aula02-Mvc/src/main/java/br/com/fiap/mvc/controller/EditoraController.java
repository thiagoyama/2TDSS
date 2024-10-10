package br.com.fiap.mvc.controller;

import br.com.fiap.mvc.model.Editora;
import br.com.fiap.mvc.respository.EditoraRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/editora")
public class EditoraController {

    @Autowired
    private EditoraRepository editoraRepository;

    @GetMapping("cadastrar")
    public String cadastrar(Model model){
        model.addAttribute("editora", new Editora());
        return "editora/form";
    }

    @PostMapping("cadastrar")
    @Transactional
    public String cadastrar(@Valid Editora editora, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()) return "editora/form";
        editoraRepository.save(editora);
        redirectAttributes.addFlashAttribute("msg", "Editora registrada!");
        return "redirect:/editora/cadastrar";
    }

}
