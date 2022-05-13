package evry.tieto.demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import evry.tieto.demo.model.CalculateTripRequest;
import evry.tieto.demo.service.TripCalculationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trip")
public class TripController {

    private final TripCalculationService tripService;

    public TripController(TripCalculationService tripService) {
        this.tripService = tripService;
    }

    @PostMapping("/")
    public ResponseEntity<String> calculateTripParameters(@RequestBody CalculateTripRequest request) throws JsonProcessingException {
        return new ResponseEntity<>(tripService.calculateTrip(request), HttpStatus.CREATED);
    }
}
