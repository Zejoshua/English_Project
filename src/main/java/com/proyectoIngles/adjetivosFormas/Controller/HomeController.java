package com.proyectoIngles.adjetivosFormas.Controller;

import com.proyectoIngles.adjetivosFormas.Model.Adjective;
import com.proyectoIngles.adjetivosFormas.Model.OperatorsAdjective;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class HomeController {
    OperatorsAdjective operators = new OperatorsAdjective();

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/show")
    public String show(Model model) {
        ArrayList<Adjective> list = operators.readArchiveCSV();
        model.addAttribute("List", list);
        return "show";
    }

    @GetMapping("/AdjectiveForms")
    public String Busqueda(String letra, Model model) {
        ArrayList<Adjective> list = operators.search(letra);
        String exampleComparative = operators.ReturnExampleComparative(letra);
        String exampleSuperlative = operators.ReturnExampleSuperlative(letra);
        model.addAttribute("comparative", exampleComparative);
        model.addAttribute("superlative", exampleSuperlative);
        model.addAttribute("List", list);
        return "AdjectiveForms";
    }

    @GetMapping("/add")
    public String showAddAdjectiveForm(Model model) {
        model.addAttribute("adjective", new Adjective());
        return "addAdjective";
    }

    @PostMapping("/add")
    public String addAdjective(@ModelAttribute Adjective adjective) {
        operators.addNewAdjective(adjective);
        return "redirect:/show";
    }
}
