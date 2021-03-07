package be.thomasmore.cars.repositories;
import be.thomasmore.cars.model.venue;
import org.springframework.data.repository.CrudRepository;

public interface venueRepository extends CrudRepository<venue, Integer> {
}
