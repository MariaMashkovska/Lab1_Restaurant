package ua.lviv.iot.algo.part1.lab2;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Pizzeria class represents a pizzeria kitchen.
 * It extends AbstractKitchen class.
 */
@ToString(callSuper = true)
@Getter
@NoArgsConstructor
@Setter
public class Pizzeria extends AbstractKitchen {

    private int yearOfFoundation;
    private String typeOfDrinks;
    private int capacityOfSeats;
    private int capacityOfAnimatronics;

    public Pizzeria(final String name,
                    final int capacity,
                    final int size,
                    final int yearOfFoundation,
                    final String typeOfDrinks,
                    final int capacityOfSeats,
                    final int capacityOfAnimatronics) {
        super(name, capacity, size);
        this.yearOfFoundation = yearOfFoundation;
        this.typeOfDrinks = typeOfDrinks;
        this.capacityOfSeats = capacityOfSeats;
        this.capacityOfAnimatronics = capacityOfAnimatronics;
    }

    @Override
    public int addGuests(final int guests) {
        return getCapacity() + guests;
    }

    @Override
    public KitchenTypes kitchenType() {
        System.out.println("Type of kitchen: " + KitchenTypes.AMERICAN);
        return KitchenTypes.AMERICAN;
    }

}