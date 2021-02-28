package be.thomasmore.cars.controllers;
import be.thomasmore.cars.model.venue;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

    private final venue[] venues={
            new venue("Opel Corsa 120 year 70","Opel",9999,12848,"benzine","04.2019","zwart",true,true,false,true,false,true),
            new venue("Renault Clio Grandtour life 74","Renault",9499,46410,"benzine","04.2018","wit",true,true,false,false,false,true),
            new venue("Renault Twingo TCE intens 92","Renault",11499,0,"benzine","09.2020","zwart",true,true,true,true,false,true),
            new venue("Mini 3 doors ONE first OPF 75","Mini",15999,33258,"benzine","05.2019","blauw",true,true,false,true,false,true),
            new venue("Volkswagen Golf VII Variant TDI comfortline 115","Volkswagen",14999,71830,"diesel","07.2017","donker blauw",true,true,true,true,false,true),
            new venue("Aiways U5 electric 170","Aiways",31999,2087,"elektrische","11.2020","zwart",true,true,true,true,true,false),
            new venue("Audi A3 Sportback FSI s line 110","Audi",27999,0,"benzine","10.2020","zwart",true,true,true,true,false,true),

    };

    @GetMapping({"/", "/home"})
    public String home(Model model) {
        return "home";
    }

    @GetMapping("/about")
    public String about(Model model) {
        return "about";
    }

    @GetMapping({"/venuedetails", "/venuedetails/{index}"})
    public String venueDetails(Model model,
                               @PathVariable(required = false) Integer index) {
        if (index != null && index >= 0 && index < venues.length) {
            model.addAttribute("venueName", venues[index]);
            model.addAttribute("prevIndex", index > 0 ? index - 1 : venues.length - 1);
            model.addAttribute("nextIndex", index < venues.length - 1 ? index + 1 : 0);
        }
        return "venuedetails";
    }
    @GetMapping("/venuelist")
    public String venuelist(Model model){
        model.addAttribute("venues", venues);
        return "venuelist";
    }
}
