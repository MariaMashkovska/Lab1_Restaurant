package ua.lviv.iot.algo.part1.lab1;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Restaurant {
    private static Restaurant instance;
    private String name;
    private int rating;
    private int maxCapacity;
    private int currentCapacity;

    public static Restaurant getInstance() {
        if (instance == null) {
            instance = new Restaurant();
        }
        return instance;
    }

    public boolean acceptReservation(int numOfGuests) {
        if (currentCapacity + numOfGuests <= maxCapacity) {
            currentCapacity += numOfGuests;
            return true;
        }

        return false;
    }

    public void removeReservation(int numOfGuests) {
        currentCapacity = Math.max(currentCapacity - numOfGuests, 0);
    }

    public static void main(String[] args) {
        Restaurant[] restaurants = new Restaurant[4];
        restaurants[0] = new Restaurant("Kafe-bar Oksana ", 10, 23, 20);
        restaurants[1] = new Restaurant();
        restaurants[2] = getInstance();
        restaurants[3] = getInstance();

//        for (int i = 0; i < restaurants.length; i++) {
//            System.out.println(restaurants[i].toString());
//        }

        for (Restaurant restaurant : restaurants) {
            System.out.println(restaurant.toString());
        }

    }

}

