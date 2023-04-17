package ua.lviv.iot.algo.part1.lab2;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * This class represents a home kitchen that extends the abstract kitchen class.
 */
@ToString(callSuper = true)
@Setter
@NoArgsConstructor
@Getter
public class HomeKitchen extends AbstractKitchen {

    private String typeOfPlate;
    private String nameOfHood;

    public String getHeaders() {
        return super.getHeaders() + "," + "typeOfPlate"
                                  + "," + "nameOfHood";
    }
    public String toCSV(){
        return super.toCSV() + "," + typeOfPlate
                             + "," + nameOfHood;
    }

    public HomeKitchen(final String name,
                       final int capacity,
                       final int size,
                       final String typeOfPlate,
                       final String nameOfHood) {
        super(name, capacity, size);
        this.typeOfPlate = typeOfPlate;
        this.nameOfHood = nameOfHood;
    }

    @Override
    public int addGuests(final int guests) {
        final int result = getCapacity() + guests;
        return result;
    }

    @Override
    public KitchenTypes kitchenType() {
        System.out.println("Type of kitchen: " + KitchenTypes.UKRAINIAN);
        return KitchenTypes.UKRAINIAN;
    }

}
