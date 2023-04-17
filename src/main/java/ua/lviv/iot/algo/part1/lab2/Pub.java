package ua.lviv.iot.algo.part1.lab2;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Random;

@ToString(callSuper = true)
@Setter
@Getter
@NoArgsConstructor
public class Pub extends AbstractKitchen {

    private static final Random random = new Random();
    private int yearOfFoundation;
    private String typeOfDrinks;
    private int maxCapacityOfGuests;

    public String getHeaders() {
        return super.getHeaders() + "," + "yearOfFoundation" +
                                    "," + "typeOfDrinks" +
                                    "," + "maxCapacityOfGuests";
    }

    public String toCSV(){
        return  super.toCSV()  + "," + yearOfFoundation + "," +
                typeOfDrinks + "," +
                maxCapacityOfGuests;
    }

    public Pub(final String name,
               final int capacity,
               final int size,
               final int yearOfFoundation,
               final String typeOfDrinks,
               final int maxCapacityOfGuests) {
        super(name, capacity, size);
        this.yearOfFoundation = yearOfFoundation;
        this.typeOfDrinks = typeOfDrinks;
        this.maxCapacityOfGuests = maxCapacityOfGuests;
    }

    @Override
    public int addGuests(int guests) {
        int result;
        result = getCapacity() + guests;
        return result;
    }

    @Override
    public KitchenTypes kitchenType() {
        KitchenTypes[] types = KitchenTypes.values();
        KitchenTypes randomType = types[random.nextInt(types.length)];
        System.out.println("Type of kitchen: " + randomType);
        return randomType;
    }

}
