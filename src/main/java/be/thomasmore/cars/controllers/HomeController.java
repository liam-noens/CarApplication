package be.thomasmore.cars.controllers;
import be.thomasmore.cars.model.venue;
import be.thomasmore.cars.repositories.venueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    private venueRepository venueRepository;

    @GetMapping({"/", "/home"})
    public String home(Model model) {
        return "home";
    }

    @GetMapping("/about")
    public String about(Model model) {
        return "about";
    }

    @GetMapping({"/venuedetails", "/venuedetails/{id}"})
    public String venueDetails(Model model,
                               @PathVariable(required = false) Integer id) {
        if (id == null) return "venuedetails";

        Optional<venue> optionalVenue = venueRepository.findById(id);
        if (optionalVenue.isPresent()) {
            long nrOfVenues = venueRepository.count();
            model.addAttribute("venue", optionalVenue.get());
            model.addAttribute("prevId", id > 1 ? id - 1 : nrOfVenues);
            model.addAttribute("nextId", id < nrOfVenues ? id + 1 : 1);
        }
        return "venuedetails";
    }
    @GetMapping("/venuelist")
    public String venuelist(Model model){
        Iterable<venue> venues = venueRepository.findAll();
        model.addAttribute("venues", venues);
        return "venuelist";
    }
}
