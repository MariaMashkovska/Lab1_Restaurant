package ua.lviv.iot.algo.part1.lab1;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Random;

@ToString(callSuper = true)
@Setter
@Getter
@NoArgsConstructor
public class Pub extends AbstractKitchen{
    private int yearOfFoundation;
    private String typeOfDrinks;
    private int maxCapacityOfGuests;

    public Pub(String name, int capacity, int size, int yearOfFoundation, String typeOfDrinks, int maxCapacityOfGuests) {
        super(name, capacity, size);
        this.yearOfFoundation = yearOfFoundation;
        this.typeOfDrinks = typeOfDrinks;
        this.maxCapacityOfGuests = maxCapacityOfGuests;
    }

    @Override
    public void addGuests(int guests) {
        setCapacity(+guests);
    }

    @Override
    public KitchenTypes kitchenType() {
        KitchenTypes[] types = KitchenTypes.values();
        Random random = new Random();
        KitchenTypes randomType = types[random.nextInt(types.length)];
        System.out.println("Type of kitchen: " + randomType);
        return randomType;
    }
}
