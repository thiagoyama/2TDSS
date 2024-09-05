package br.com.fiap.mvc.controller;

import br.com.fiap.mvc.model.Disciplina;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("calculadora")
public class CalculadoraController {

    @GetMapping("media")
    public String calcular(){
        return "calculadora/media";
    }

    @PostMapping("media")
    public String calcular(Disciplina disciplina, Model model){
        model.addAttribute("mediaFinal", disciplina.calcularMediaAnual());
        model.addAttribute("dis", disciplina);
        return "calculadora/media";
    }

}
