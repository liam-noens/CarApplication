package be.thomasmore.cars.repositories;

import be.thomasmore.cars.model.Place;
import org.springframework.data.repository.CrudRepository;

public interface placeRepository extends CrudRepository<Place, Integer> {
}
