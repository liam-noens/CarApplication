package be.thomasmore.cars.controllers;

import be.thomasmore.cars.model.Car;
import be.thomasmore.cars.repositories.carRepository;
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
public class CarController {

    private Logger logger = LoggerFactory.getLogger(CarController.class);

    @Autowired
    private carRepository carRepository;

    @GetMapping({"/cardetails", "/cardetails/{id}"})
    public String carDetails(Model model,
                               @PathVariable(required = false) Integer id) {
        if (id == null) return "cardetails";

        Optional<Car> optionalCar = carRepository.findById(id);
        if (optionalCar.isPresent()) {
            long nrOfCar = carRepository.count();
            model.addAttribute("car", optionalCar.get());
            model.addAttribute("prevId", id > 1 ? id - 1 : nrOfCar);
            model.addAttribute("nextId", id < nrOfCar ? id + 1 : 1);
        }
        return "cardetails";
    }
    @GetMapping("/carlist")
    public String carlist(Model model){
        Iterable<Car> cars = carRepository.findAll();
        model.addAttribute("cars", cars);
        model.addAttribute("showFilters",false);
        return "carlist";
    }

    @GetMapping({"/carlist/filter"})
    public String carListFilter(Model model,
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
        logger.info(String.format("carListFilter -- minPrice=%d, maxPrice=%d, minKm=%d, maxKm=%d, filterForSale=%s, filterRadio=%s, filterGPS=%s, filterAirco=%s, filterAutomatic=%s, filterManual=%s",
                minPrice, maxPrice, minKm, maxKm, filterForSale, filterRadio, filterGPS, filterAirco, filterAutomatic, filterManual));

        List<Car> Cars = carRepository.findByFilter(minPrice, maxPrice, minKm, maxKm,
                filterStringToBoolean(filterForSale), filterStringToBoolean(filterRadio), filterStringToBoolean(filterGPS),filterStringToBoolean(filterAirco),filterStringToBoolean(filterAutomatic),filterStringToBoolean(filterManual));

        model.addAttribute("cars", Cars);
        model.addAttribute("nrOfCars", Cars.size());
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

        return "carlist";
    }
    private Boolean filterStringToBoolean(String filterString) {
        return (filterString == null || filterString.equals("all")) ? null : filterString.equals("yes");
    }
}
