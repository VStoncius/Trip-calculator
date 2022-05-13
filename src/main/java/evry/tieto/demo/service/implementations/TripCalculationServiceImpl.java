package evry.tieto.demo.service.implementations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import evry.tieto.demo.model.CalculateTripRequest;
import evry.tieto.demo.model.CalculateTripResponse;
import evry.tieto.demo.service.ItemService;
import evry.tieto.demo.service.TripCalculationService;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class TripCalculationServiceImpl implements TripCalculationService {

    private final ItemService itemService;
    private final ObjectMapper mapper;

    public TripCalculationServiceImpl(ItemService itemService) {
        this.itemService = itemService;
        this.mapper = new ObjectMapper();
    }

    @Override
    public String calculateTrip(CalculateTripRequest request) throws JsonProcessingException {
        CalculateTripResponse response = new CalculateTripResponse();

        response.setTripLength(request.getLength());
        response.setExpectedTripTime(request.getLength()/5); //length is in km

        if (response.getExpectedTripTime() > 8){ //time is in hours
            response.setLodgingsNeeded(true);
        }

        response.setRecommendedItems(itemService.getAllItemsForSeason(request.getSeason())
                .stream()
                .filter(item -> item.getTripLongerThan() < request.getLength())
                .collect(Collectors.toList()));
        return mapper.writeValueAsString(response);
    }
}
