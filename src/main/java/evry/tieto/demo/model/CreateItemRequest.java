package evry.tieto.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateItemRequest {

    private String name;
    private boolean usedInSummer;
    private boolean usedInWinter;
    private int tripLongerThan;
}
