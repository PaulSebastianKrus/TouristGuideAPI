package tourism.service;
import tourism.model.TouristAttraction;
import tourism.repository.TouristRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TouristService {

    private final TouristRepository touristRepository;

    @Autowired
    public TouristService(TouristRepository touristRepository) {
        this.touristRepository = touristRepository;
    }

    public List<TouristAttraction> getAllAttractions() {
        return touristRepository.getAllAttractions();
    }

    public TouristAttraction getAttractionByName(String name) {
        return touristRepository.getAttractionByName(name);
    }

    public TouristAttraction addAttraction(TouristAttraction attraction) {
        return touristRepository.addAttraction(attraction);
    }

    public TouristAttraction updateAttraction(String name, TouristAttraction updatedAttraction) {
        return touristRepository.updateAttraction(name, updatedAttraction);
    }

    public boolean deleteAttraction(String name) {
        return touristRepository.deleteAttraction(name);
    }
}