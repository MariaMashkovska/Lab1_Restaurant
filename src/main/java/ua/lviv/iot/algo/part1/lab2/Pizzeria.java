package ua.lviv.iot.algo.part1.lab2;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString(callSuper = true)
@Getter
@NoArgsConstructor
@Setter
public class Pizzeria extends AbstractKitchen{

    private int yearOfFoundation;
    private String typeOfDrinks;
    private int capacityOfSeats;
    private int capacityOfAnimatronics;

    public Pizzeria(String name, int capacity, int size, int yearOfFoundation, String typeOfDrinks, int capacityOfSeats, int capacityOfAnimatronics) {
        super(name, capacity, size);
        this.yearOfFoundation = yearOfFoundation;
        this.typeOfDrinks = typeOfDrinks;
        this.capacityOfSeats = capacityOfSeats;
        this.capacityOfAnimatronics = capacityOfAnimatronics;
    }

    @Override
    public void addGuests(int guests) {
        setCapacity(capacity + guests);
    }

    @Override
    public KitchenTypes kitchenType() {
        System.out.println("Type of kitchen: " + KitchenTypes.AMERICAN);
        return KitchenTypes.AMERICAN;
    }

}
