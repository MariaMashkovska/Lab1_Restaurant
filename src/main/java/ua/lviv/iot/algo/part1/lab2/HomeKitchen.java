package ua.lviv.iot.algo.part1.lab2;

import com.sun.source.tree.ReturnTree;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString(callSuper = true)
@Setter
@Getter
@NoArgsConstructor
public class HomeKitchen extends AbstractKitchen {

    private String typeOfPlate;
    private String nameOfHood;

    public HomeKitchen(String name, int capacity, int size, String typeOfPlate, String nameOfHood) {
        super(name, capacity, size);
        this.typeOfPlate = typeOfPlate;
        this.nameOfHood = nameOfHood;
    }

    @Override
    public void addGuests(int guests) {
        setCapacity(capacity + guests);
    }

    @Override
    public KitchenTypes kitchenType() {
        System.out.println("Type of kitchen: " + KitchenTypes.UKRAINIAN);
        return KitchenTypes.UKRAINIAN;
    }

}
