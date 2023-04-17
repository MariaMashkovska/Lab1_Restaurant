package ua.lviv.iot.algo.part1.lab2;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Random;

@Setter
@Getter
@NoArgsConstructor
@ToString(callSuper = true)
public class Restaurant extends AbstractKitchen {

    private static Restaurant instance;
    private static final Random RANDOM = new Random();
    private int yearOfFoundation;
    private int rating;
    private int maxGuestsCapacity;
    private int currentGuestsCapacity;
    private String openingTime = "9:00";
    private String closingTime = "18:00";

    public String getHeaders() {
        return super.getHeaders() + "," + "yearOfFoundation" +
                                    "," + "rating" +
                                    "," + "maxGuestsCapacity" +
                                    "," + "currentGuestsCapacity" +
                                    "," + "openingTime" +
                                    "," + "closingTime";
    }

    public String toCSV(){
        return  super.toCSV() + "," + yearOfFoundation + "," +
                rating + "," +
                maxGuestsCapacity + "," +
                currentGuestsCapacity + "," +
                openingTime + "," +
                closingTime;
    }

    public Restaurant(final String name,
                      final int capacity,
                      final int size,
                      final int yearOfFoundation,
                      final int rating,
                      final int maxGuestsCapacity,
                      final int currentGuestsCapacity
                        ) {
        super(name, capacity, size);
        this.yearOfFoundation = yearOfFoundation;
        this.rating = rating;
        this.maxGuestsCapacity = maxGuestsCapacity;
        this.currentGuestsCapacity = currentGuestsCapacity;
    }

    public static Restaurant getInstance() {
        if (instance == null) {
            instance = new Restaurant();
        }
        return Restaurant.instance;
    }

    public boolean acceptReservation(final int numOfGuests) {
        if (currentGuestsCapacity + numOfGuests <= maxGuestsCapacity) {
            currentGuestsCapacity += numOfGuests;
            return true;
        }

        return false;
    }

    public void removeReservation(final int numOfGuests) {
        currentGuestsCapacity = Math.
                max(currentGuestsCapacity - numOfGuests, 0);
    }

    @Override
    public int addGuests(final int guests) {
        int result;
        result = getCapacity() + guests;
        return result;
    }

    @Override
    public KitchenTypes kitchenType() {
        KitchenTypes[] types = KitchenTypes.values();
        KitchenTypes randomType = types[RANDOM.nextInt(types.length)];
        System.out.println("Type of kitchen: " + randomType);
        return randomType;
    }

}
