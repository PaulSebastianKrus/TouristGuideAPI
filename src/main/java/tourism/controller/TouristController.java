package tourism.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tourism.model.TouristAttraction;
import tourism.service.TouristService;

import java.util.List;
@Controller
@RestController
@RequestMapping({"/", "/attractions"})
public class TouristController {

    private final TouristService touristService;

    public TouristController(TouristService touristService) {
        this.touristService = touristService;
    }

    // Endpoint to get all attractions
    @GetMapping
    public ResponseEntity<List<TouristAttraction>> getAttractions() {
        List<TouristAttraction> attractions = touristService.getAllAttractions();
        return ResponseEntity.ok(attractions);
    }

    @GetMapping("/{name}")
    public ResponseEntity<String> getDescriptionForAttraction(@PathVariable String name) {
        TouristAttraction attraction = touristService.getAttractionByName(name);

        if (attraction != null) {
            String description = attraction.getDescription();
            return ResponseEntity.ok(description);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint to add a new attraction
    @PostMapping("/add")
    public ResponseEntity<TouristAttraction> addAttraction(@RequestBody TouristAttraction attraction) {
        TouristAttraction addedAttraction = touristService.addAttraction(attraction);
        return ResponseEntity.status(201).body(addedAttraction);
    }

    // Endpoint to update an existing attraction
    @PostMapping("/update")
    public ResponseEntity<TouristAttraction> updateAttraction(@RequestBody TouristAttraction updatedAttraction) {
        TouristAttraction attraction = touristService.updateAttraction(updatedAttraction.getName(), updatedAttraction);
        if (attraction != null) {
            return ResponseEntity.ok(attraction);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint to delete an attraction by name
    @DeleteMapping("/delete/{name}")
    public ResponseEntity<Void> deleteAttraction(@PathVariable String name) {
        boolean deleted = touristService.deleteAttraction(name);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
