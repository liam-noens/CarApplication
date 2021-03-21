package be.thomasmore.cars.controllers;

import be.thomasmore.cars.model.venue;
import be.thomasmore.cars.repositories.venueRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class VenueController {

    private Logger logger = LoggerFactory.getLogger(VenueController.class);

    @Autowired
    private venueRepository venueRepository;

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
        model.addAttribute("showFilters",false);
        return "venuelist";
    }

    @GetMapping({"/venuelist/filter"})
    public String venueListFilter(Model model,
                                  @RequestParam(required = false) Integer minPrice,
                                  @RequestParam(required = false) Integer maxPrice,
                                  @RequestParam(required = false) Integer minKm,
                                  @RequestParam(required = false) Integer maxKm,
                                  @RequestParam(required = false) String filterForSale,
                                  @RequestParam(required = false) String filterRadio,
                                  @RequestParam(required = false) String filterGPS,
                                  @RequestParam(required = false) String filterAirco,
                                  @RequestParam(required = false) String filterAutomatic,
                                  @RequestParam(required = false) String filterManual){
        logger.info(String.format("venueListFilter -- minPrice=%d, maxPrice=%d, minKm=%d, maxKm=%d, filterForSale=%s, filterRadio=%s, filterGPS=%s, filterAirco=%s, filterAutomatic=%s, filterManual=%s",
                minPrice, maxPrice, minKm, maxKm, filterForSale, filterRadio, filterGPS, filterAirco, filterAutomatic, filterManual));

        List<venue> venues = venueRepository.findByFilter(minPrice, maxPrice, minKm, maxKm,
                filterStringToBoolean(filterForSale), filterStringToBoolean(filterRadio), filterStringToBoolean(filterGPS),filterStringToBoolean(filterAirco),filterStringToBoolean(filterAutomatic),filterStringToBoolean(filterManual));

        model.addAttribute("venues", venues);
        model.addAttribute("nrOfVenues", venues.size());
        model.addAttribute("showFilters", true);
        model.addAttribute("minPrice", minPrice);
        model.addAttribute("maxPrice", maxPrice);
        model.addAttribute("minKm", minKm);
        model.addAttribute("maxKm", maxKm);
        model.addAttribute("filterForSale", filterForSale);
        model.addAttribute("filterRadio", filterRadio);
        model.addAttribute("filterGPS", filterGPS);
        model.addAttribute("filterAirco", filterAirco);
        model.addAttribute("filterAutomatic", filterAutomatic);
        model.addAttribute("filterManual",filterManual);

        return "venuelist";
    }
    private Boolean filterStringToBoolean(String filterString) {
        return (filterString == null || filterString.equals("all")) ? null : filterString.equals("yes");
    }
}
