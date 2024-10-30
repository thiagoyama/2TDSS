package br.com.fiap.mvc.controller;

import br.com.fiap.mvc.dto.UserForm;
import br.com.fiap.mvc.respository.RoleRepository;
import br.com.fiap.mvc.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.beans.Transient;

@Controller
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("registrar")
    public String cadastrar(Model model){
        model.addAttribute("usuario", new UserForm());
        model.addAttribute("roles", roleRepository.findAll());
        return "usuario/cadastro";
    }

    @PostMapping("cadastrar")
    public String cadastrar(@Valid UserForm userForm,
                            BindingResult bindingResult,
                            Model model,
                            RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            model.addAttribute("roles", roleRepository.findAll());
            return "usuario/cadastro";
        }
        usuarioService.save(userForm.getUsername(),
                passwordEncoder.encode(userForm.getPassword()), userForm.getRoles());
        return "redirect:/login";
    }

}
