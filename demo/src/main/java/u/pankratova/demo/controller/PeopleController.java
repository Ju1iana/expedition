package u.pankratova.demo.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import u.pankratova.demo.model.Calculator;
import u.pankratova.demo.model.Person;
import u.pankratova.demo.model.Ration;
import u.pankratova.demo.service.PersonService;
import u.pankratova.demo.service.RationService;

import java.util.List;

@Controller
@RequestMapping("/people")
public class PeopleController {
    private final PersonService service;
    private final RationService service1;

    public PeopleController(PersonService service, RationService service1) {
        this.service = service;
        this.service1 = service1;
    }

    @GetMapping("/getById{id}")
    public String getPersonById(@RequestParam("id") int id, Model model) {
        model.addAttribute("person", service.getPersonById(id));
        return "show";
    }


    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person, Model model
            /* @ModelAttribute("d") Calculator calculator*/) {
        model.addAttribute("peopleAll", service.index());
        /*model.addAttribute("d", calculator.getAmount());*/
        return "new";
    }

    @PostMapping()
    public String addPerson(@ModelAttribute("person") @Valid Person person,
                            BindingResult bindingResult/*,
                            @RequestParam("calc") int duration, Model model*/) {
        if (bindingResult.hasErrors())
            return "people/new";
        person.setCalories(service.personCalories(person));

        /*model.addAttribute("calc", service.allCalories(duration));*/

        service.add(person);
        /*  service.allCalories(duration);*/
        return "redirect:/people/new";
    }

    @PostMapping("/duration")
    public String duration(@RequestParam(value = "val") double val) {
        /*double updateValue = service.allCalories(val);*/
        service.setDuration((int) val);
        service.allCalories(val);
        return "redirect:/people/new";
    }

    /*@GetMapping("/durat")
    public String allCalories(@ModelAttribute("calc") Calculator calculator) {
        *//*int val = 0;
        model.addAttribute("value", val);
        model.addAttribute("d", 0);*//*
        return "new";
    }*/

    @ModelAttribute("calc")
    public Calculator all() {
        return new Calculator();
    }

    @PostMapping("/dif")
    public String calcBetta(@RequestParam(value = "activity") String activity,
                            @RequestParam(value = "activity2") String activity2, Model model) {
        /*service.calcBetta(val);
        service.calcAll(service.getCalculator().getBetta());*/

        double gamma;
        if (activity2.equals("1")) {
            gamma = 1.0;
        } else if (activity2.equals("11")) {
            gamma = 1.1;
        } else if (activity2.equals("12")) {
            gamma = 1.2;
        } else if (activity2.equals("13")) {
            gamma = 1.3;
        } else if (activity2.equals("14")) {
            gamma = 1.4;
        } else {
            gamma = 1.5;
        }

        double betta;
        if (activity.equals("пеший")) {
            betta = 1.0;
        } else if (activity.equals("лыжный")) {
            betta = 1.2;
        } else {
            betta = 1.3;
        }


        Calculator calculator = new Calculator();
        calculator.setBetta(betta);
        calculator.setGamma(gamma);

       /* model.addAttribute("calculator", calculator); раньше это было. Но я убала и ничего не поменялось. В Thymeleaf "calculator" нет нигде...*/

        service.calcAll(betta, gamma);
        return "redirect:/people/new";
    }
}
