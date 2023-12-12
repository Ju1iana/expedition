package u.pankratova.demo.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import u.pankratova.demo.model.Calculator;
import u.pankratova.demo.model.Person;
import u.pankratova.demo.service.PersonService;

@Controller
@RequestMapping("/people")
public class PeopleController {
    private final PersonService service;

    public PeopleController(PersonService service) {
        this.service = service;
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
}
