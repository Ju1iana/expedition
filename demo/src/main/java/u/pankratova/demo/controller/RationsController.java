package u.pankratova.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import u.pankratova.demo.model.Ration;
import u.pankratova.demo.service.RationService;

@Controller
@RequestMapping("/ration")
public class RationsController {
    private final RationService service;

    public RationsController(RationService service) {
        this.service = service;
    }

   /* @RequestMapping()
    public String getRation(Model model) {

        int index = service.numberOfRation();
        List<Ration> list = service.index();

        model.addAttribute("rationAll", list.get(index));

        return "redirect:/people/new";

    }*/
/*
    @PostMapping()
    public String show(Model model){
        System.out.println("1");
        Ration ration = service.numberOfRation().get();
        model.addAttribute("rationAll", ration);
        return "redirect:/people/new";
    }
*/

// В этом методе получите все сущности из базы данных, используя репозиторий, и добавьте их в модель представления.
    @GetMapping()
    public String showRation(Model model) {
        //List <Ration> list = service.numberOfRation();
        /*Ration newRation = new Ration();

        newRation.setId(ration.getId());
        newRation.setCalories(ration.getCalories());
        newRation.setBzhu(ration.getBzhu());
        newRation.setWeight(ration.getWeight());
        newRation.setDescription(ration.getDescription());*/

        //service.numberOfRation();

        Ration ration = service.numberOfRation();
        model.addAttribute("rationAll", ration);
        System.out.println("2");

        /*model.addAttribute("rationAll", new Ration());*/

        /*model.addAttribute("rationAll", service.numberOfRation().get());
        Ration ration = service.numberOfRation().get();
        model.addAttribute("rationAll", ration);
        rationAll();*/
        return "ration";
    }

   /* @ModelAttribute("rationAll")
    public Ration rationAll(){
        System.out.println("3");
        return service.numberOfRation();
    }*/

/*    @PostMapping()
    public String showRightRation(@ModelAttribute("rationAll") Ration ration){
        System.out.println("34");
        //model.addAttribute("ration", service.numberOfRation());
        ration = service.numberOfRation();

        return "ration";
    }*/
}
