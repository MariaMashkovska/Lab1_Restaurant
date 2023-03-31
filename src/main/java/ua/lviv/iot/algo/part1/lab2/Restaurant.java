package ua.lviv.iot.algo.part1.lab2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Random;

@Setter
@Getter
@NoArgsConstructor
@ToString(callSuper = true)
public class Restaurant extends AbstractKitchen{

    private static Restaurant instance;
    private int yearOfFoundation;
    private int rating;
    private int maxGuestsCapacity;
    private int currentGuestsCapacity;
    private final String openingTime="9:00";
    private final String closingTime="18:00";

    public Restaurant(String name, int capacity, int size, int yearOfFoundation, int rating, int maxGuestsCapacity, int currentGuestsCapacity) {
        super(name, capacity, size); //сапер викликає конструктор з батьківського класу який приймає поля з абстракт класу
        this.yearOfFoundation = yearOfFoundation;
        this.rating = rating;
        this.maxGuestsCapacity = maxGuestsCapacity;
        this.currentGuestsCapacity = currentGuestsCapacity;
    }

    public static Restaurant getInstance() {
        if (instance == null) {
            instance = new Restaurant();
        }
        return instance;
    }

    public boolean acceptReservation(int numOfGuests) {
        if (currentGuestsCapacity + numOfGuests <= maxGuestsCapacity) {
            currentGuestsCapacity += numOfGuests;
            return true;
        }
        return false;
    }

    public void removeReservation(int numOfGuests) {
        currentGuestsCapacity = Math.max(currentGuestsCapacity - numOfGuests, 0);
    }

    @Override
    public void addGuests(int guests) {
        setCapacity(capacity + guests);
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
