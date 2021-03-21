package be.thomasmore.cars.repositories;

import be.thomasmore.cars.model.venue;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface venueRepository extends CrudRepository<venue, Integer> {

    @Query("SELECT v FROM venue v WHERE " +
            "(:minPrice IS NULL OR :minPrice <= v.price) AND " +
            "(:maxPrice IS null OR v.price <= :maxPrice) AND " +
            "(:minKm IS NULL OR :minKm <= v.kilometers) AND " +
            "(:maxKm IS NULL OR v.kilometers <= :maxKm) AND " +
            "(:forSale IS NULL OR v.forSale=:forSale) AND " +
            "(:radio is null or v.radio=:radio) and " +
            "(:gps is null or v.gps=:gps) and " +
            "(:airConditioning is null or v.airConditioning=:airConditioning) and " +
            "(:automatic is null or v.automatic=:automatic) and " +
            "(:manual is null or v.manuall=:manual)")

    List<venue> findByFilter(@Param("minPrice") Integer minPrice,
                             @Param("maxPrice") Integer maxPrice,
                             @Param("minKm") Integer minKm,
                             @Param("maxKm") Integer maxKm,
                             @Param("forSale") Boolean forSale,
                             @Param("radio") Boolean radio,
                             @Param("gps") Boolean gps,
                             @Param("airConditioning") Boolean airConditioning,
                             @Param("automatic") Boolean automatic,
                             @Param("manual") Boolean manual);
}
