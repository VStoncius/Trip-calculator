package evry.tieto.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CalculateTripRequest {

    private int length;
    private String season;

}
