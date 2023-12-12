package u.pankratova.demo.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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
    public String getPersonById(@RequestParam("id") int id, Model model){
        model.addAttribute("person", service.getPersonById(id));
        return "show";
    }


    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person, Model model){
        model.addAttribute("peopleAll", service.index());
        return "new";
    }

    @PostMapping()
    public String addPerson(@ModelAttribute("person") @Valid Person person,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "people/new";
        service.add(person);
        return "redirect:/people/new";
    }
}
