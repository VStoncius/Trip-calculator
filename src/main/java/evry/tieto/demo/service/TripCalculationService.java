package evry.tieto.demo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import evry.tieto.demo.model.CalculateTripRequest;

public interface TripCalculationService {
    public String calculateTrip(CalculateTripRequest request) throws JsonProcessingException;
}
