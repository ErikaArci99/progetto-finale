package org.lessons.java.progetto_finale.controller;

import org.lessons.java.progetto_finale.model.Collezione;
import org.lessons.java.progetto_finale.service.CollezioneService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/collezioni")
public class CollezioneController {

    private final CollezioneService collezioneService;

    public CollezioneController(CollezioneService collezioneService) {
        this.collezioneService = collezioneService;
    }

    @GetMapping
    public String list(Model model, Authentication authentication) {
        model.addAttribute("collezioni", collezioneService.findAll());
        model.addAttribute("users", authentication.getName());
        model.addAttribute("roles", authentication.getAuthorities());
        return "collezioni/list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("collezione", new Collezione());
        return "collezioni/create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute Collezione collezione, BindingResult result) {
        if (result.hasErrors())
            return "collezioni/create";
        collezioneService.save(collezione);
        return "redirect:/collezioni";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        Collezione collezione = collezioneService.findById(id).orElseThrow();
        model.addAttribute("collezione", collezione);
        return "collezioni/edit";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable Long id, @Valid @ModelAttribute Collezione collezione, BindingResult result) {
        if (result.hasErrors())
            return "collezioni/edit";
        collezione.setId(id);
        collezioneService.save(collezione);
        return "redirect:/collezioni";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        collezioneService.deleteById(id);
        return "redirect:/collezioni";
    }
}
