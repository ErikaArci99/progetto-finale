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
@RequestMapping("/borse")
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

    // index (list)
    @GetMapping
    public String list(Model model, Authentication authentication) {
        List<Borsa> borse = borsaService.findAll();
        model.addAttribute("borse", borse);
        model.addAttribute("users", authentication.getName());
        model.addAttribute("roles", authentication.getAuthorities());
        return "borse/list";
    }

    // show (detail)
    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model, Authentication authentication) {
        Borsa borsa = borsaService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Borsa non trovata"));
        model.addAttribute("borsa", borsa);
        model.addAttribute("users", authentication.getName());
        model.addAttribute("roles", authentication.getAuthorities());
        return "borse/detail";
    }

    // create form
    @GetMapping("/create")
    public String createForm(Model model, Authentication authentication) {
        model.addAttribute("borsa", new Borsa());
        model.addAttribute("collezioni", collezioneService.findAll());
        model.addAttribute("sconti", scontoService.findAll());
        model.addAttribute("users", authentication.getName());
        model.addAttribute("roles", authentication.getAuthorities());
        return "borse/create";
    }

    // create
    @PostMapping("/create")
    public String create(@Valid @ModelAttribute Borsa borsa,
            @RequestParam Long collezioneId,
            @RequestParam(required = false) Long scontoId,
            BindingResult bindingResult,
            Model model, Authentication authentication) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("collezioni", collezioneService.findAll());
            model.addAttribute("sconti", scontoService.findAll());
            model.addAttribute("users", authentication.getName());
            model.addAttribute("roles", authentication.getAuthorities());
            return "borse/create";
        }

        borsa.setCollezione(collezioneService.findById(collezioneId).orElse(null));
        borsa.setSconto(scontoId != null ? scontoService.findById(scontoId).orElse(null) : null);

        borsaService.save(borsa);
        return "redirect:/borse";
    }

    // edit form
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model, Authentication authentication) {
        Borsa borsa = borsaService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Borsa non trovata"));
        model.addAttribute("borsa", borsa);
        model.addAttribute("collezioni", collezioneService.findAll());
        model.addAttribute("sconti", scontoService.findAll());
        model.addAttribute("users", authentication.getName());
        model.addAttribute("roles", authentication.getAuthorities());
        return "borse/edit";
    }

    // edit
    @PostMapping("/edit/{id}")
    public String edit(@PathVariable Long id,
            @Valid @ModelAttribute Borsa borsa,
            @RequestParam Long collezioneId,
            @RequestParam(required = false) Long scontoId,
            BindingResult bindingResult,
            Model model, Authentication authentication) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("collezioni", collezioneService.findAll());
            model.addAttribute("sconti", scontoService.findAll());
            model.addAttribute("users", authentication.getName());
            model.addAttribute("roles", authentication.getAuthorities());
            return "borse/edit";
        }

        borsa.setId(id);
        borsa.setCollezione(collezioneService.findById(collezioneId).orElse(null));
        borsa.setSconto(scontoId != null ? scontoService.findById(scontoId).orElse(null) : null);

        borsaService.save(borsa);
        return "redirect:/borse";
    }

    // delete
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        borsaService.deleteById(id);
        return "redirect:/borse";
    }
}
