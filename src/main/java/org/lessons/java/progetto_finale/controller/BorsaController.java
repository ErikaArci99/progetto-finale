package org.lessons.java.progetto_finale.controller;

import org.lessons.java.progetto_finale.model.Borsa;
import org.lessons.java.progetto_finale.service.BorsaService;
import org.lessons.java.progetto_finale.service.CollezioneService;
import org.lessons.java.progetto_finale.service.ScontoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.security.core.Authentication;

@Controller
@RequestMapping("/admin/borse")
public class BorsaController {

    private final BorsaService borsaService;
    private final CollezioneService collezioneService;
    private final ScontoService scontoService;

    public BorsaController(BorsaService borsaService, CollezioneService collezioneService,
            ScontoService scontoService) {
        this.borsaService = borsaService;
        this.collezioneService = collezioneService;
        this.scontoService = scontoService;
    }

    @GetMapping
    public String list(Model model, Authentication authentication) {
        List<Borsa> borse = borsaService.findAll();
        model.addAttribute("borse", borse);
        model.addAttribute("username", authentication.getName());
        model.addAttribute("ruolo", authentication.getAuthorities());
        return "borse/list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        Borsa borsa = borsaService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Borsa non trovata"));
        model.addAttribute("borsa", borsa);
        return "borse/detail";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        Borsa borsa = borsaService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Borsa non trovata"));
        model.addAttribute("borsa", borsa);
        model.addAttribute("collezioni", collezioneService.findAll());
        model.addAttribute("sconti", scontoService.findAll());
        return "borse/edit";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable Long id, @Valid @ModelAttribute Borsa borsa, BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("collezioni", collezioneService.findAll());
            model.addAttribute("sconti", scontoService.findAll());
            return "borse/edit";
        }
        borsa.setId(id);
        borsaService.save(borsa);
        return "redirect:/admin/borse";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        borsaService.deleteById(id);
        return "redirect:/admin/borse";
    }
}
