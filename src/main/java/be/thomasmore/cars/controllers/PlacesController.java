package be.thomasmore.cars.controllers;
import be.thomasmore.cars.model.place;
import be.thomasmore.cars.repositories.placeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class PlacesController {

    @Autowired
    private placeRepository placeRepository;

    @GetMapping("/placelist")
        public String placeList(Model model){
        Iterable<place> places = placeRepository.findAll();
        model.addAttribute("places", places);
        model.addAttribute("showFilters", false);
        return "placelist";
    }

    @GetMapping({"/placedetails","/placedetails/{id}"})
    public String placeDetails(Model model, @PathVariable(required = false) Integer id){
        if (id == null) return "placedetails";

        Optional<place> optionalPlace = placeRepository.findById(id);
        if (optionalPlace.isPresent()){
            long nrOfPLace = placeRepository.count();
            model.addAttribute("place", optionalPlace.get());
            model.addAttribute("prevId", id > 1 ? id - 1 : nrOfPLace);
            model.addAttribute("nextId", id < nrOfPLace ? id + 1 : 1);
        }
        return "placedetails";
    }
}
