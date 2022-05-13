package evry.tieto.demo.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name="ITEMS")
@Getter
@Setter
@RequiredArgsConstructor
public class Item {
    @Id
    @GeneratedValue
    private int id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private int tripLongerThan;

    private boolean usedInSummer;

    private boolean usedInWinter;

    public Item(String name, boolean usedInSummer, boolean usedInWinter, int tripLongerThan) {
        this.name = name;
        this.usedInSummer = usedInSummer;
        this.usedInWinter = usedInWinter;
        this.tripLongerThan = tripLongerThan;
    }
}
