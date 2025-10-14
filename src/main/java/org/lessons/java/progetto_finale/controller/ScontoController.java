package org.lessons.java.progetto_finale.controller;

import org.lessons.java.progetto_finale.model.Sconto;
import org.lessons.java.progetto_finale.service.ScontoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/sconti")
public class ScontoController {

    private final ScontoService scontoService;

    public ScontoController(ScontoService scontoService) {
        this.scontoService = scontoService;
    }

    @GetMapping
    public String list(Model model, Authentication authentication) {
        model.addAttribute("sconti", scontoService.findAll());
        model.addAttribute("users", authentication.getName());
        model.addAttribute("roles", authentication.getAuthorities());
        return "sconti/list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("sconto", new Sconto());
        return "sconti/create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute Sconto sconto, BindingResult result) {
        if (result.hasErrors())
            return "sconti/create";
        scontoService.save(sconto);
        return "redirect:/sconti";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        Sconto sconto = scontoService.findById(id).orElseThrow();
        model.addAttribute("sconto", sconto);
        return "sconti/edit";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable Long id, @Valid @ModelAttribute Sconto sconto, BindingResult result) {
        if (result.hasErrors())
            return "sconti/edit";
        sconto.setId(id);
        scontoService.save(sconto);
        return "redirect:/sconti";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        scontoService.deleteById(id);
        return "redirect:/sconti";
    }
}
