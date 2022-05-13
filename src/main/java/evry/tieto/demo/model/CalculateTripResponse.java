package evry.tieto.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CalculateTripResponse {

    private boolean lodgingsNeeded;

    private int expectedTripTime;

    private int tripLength;

    private List<Item> recommendedItems;

}
