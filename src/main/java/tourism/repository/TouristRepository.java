package tourism.repository;

import org.springframework.stereotype.Repository;
import tourism.model.TouristAttraction;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristRepository {

    private List<TouristAttraction> attractions = new ArrayList<>();

    //constructor
    public TouristRepository() {

        attractions.add(new TouristAttraction("Eiffel Tower", "Iconic iron lattice tower in Paris."));
        attractions.add(new TouristAttraction("Statue of Liberty", "Symbol of freedom in New York Harbor."));
        attractions.add(new TouristAttraction("Tivoli", "Tivoli Gardens amusement park in central Copenhagen offers rides."));
    }

    public List<TouristAttraction> getAllAttractions() {
        return attractions;
    }

    public TouristAttraction getAttractionByName(String name) {
        // Implement logic to retrieve attraction by name
        for (TouristAttraction attraction : attractions) {
            if (attraction.getName().equals(name)) {
                return attraction;
            }
        }
        return null;
    }

    public TouristAttraction addAttraction(TouristAttraction attraction) {
        // Implement logic to add attraction
        attractions.add(attraction);
        return attraction;
    }

    public TouristAttraction updateAttraction(String name, TouristAttraction updatedAttraction) {
        // Implement logic to update attraction
        for (int i = 0; i < attractions.size(); i++) {
            if (attractions.get(i).getName().equals(name)) {
                attractions.set(i, updatedAttraction);
                return updatedAttraction;
            }
        }
        return null;
    }

    public boolean deleteAttraction(String name) {
        // Implement logic to delete attraction
        for (TouristAttraction attraction : attractions) {
            if (attraction.getName().equals(name)) {
                attractions.remove(attraction);
                return true;
            }
        }
        return false;
    }









}