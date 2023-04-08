package ua.lviv.iot.algo.part1.lab2;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString(callSuper = true)
@Setter
@NoArgsConstructor
@Getter

public class HomeKitchen extends AbstractKitchen {
    private String typeOfPlate;
    private String nameOfHood;

    public HomeKitchen(String name, int capacity, int size, String typeOfPlate, String nameOfHood) {
        super(name, capacity, size);
        this.typeOfPlate = typeOfPlate;
        this.nameOfHood = nameOfHood;
    }

    @Override
    public int addGuests(int guests) {
        int result;
        result = getCapacity() + guests;
        return result;
    }

    @Override
    public KitchenTypes kitchenType() {
        System.out.println("Type of kitchen: " + KitchenTypes.UKRAINIAN);
        return KitchenTypes.UKRAINIAN;
    }

}
