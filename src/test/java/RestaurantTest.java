import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ua.lviv.iot.algo.part1.lab2.KitchenTypes;
import ua.lviv.iot.algo.part1.lab2.Restaurant;

import static org.junit.jupiter.api.Assertions.*;

class RestaurantTest {

    Restaurant restaurant = new Restaurant("5-star Restaurant Lola", 200, 60, 2007, 10, 150, 34);

    @Test
    public void testGetHeaders(){
        String expectedHeaders = "name,capacity,size,yearOfFoundation,rating,maxGuestsCapacity,currentGuestsCapacity,openingTime,closingTime";
        String actualHeaders = restaurant.getHeaders();
        assertEquals(expectedHeaders, actualHeaders);
    }
    @Test
    public void testToCSV(){
        String expectedValues = "5-star Restaurant Lola,200,60,2007,10,150,34,9:00,18:00";
        String actualValues = restaurant.toCSV();
        assertEquals(expectedValues, actualValues);
    }
    @Test
    public void testAcceptReservation() {
        boolean reservationAccepted = restaurant.acceptReservation(20);
        Assertions.assertTrue(reservationAccepted);
        Assertions.assertEquals(54, restaurant.getCurrentGuestsCapacity());
    }

    @Test
    public void testRemoveReservation() {
        Restaurant restaurant = new Restaurant();
        restaurant.setCurrentGuestsCapacity(34);
        restaurant.removeReservation(10);
        Assertions.assertEquals(24, restaurant.getCurrentGuestsCapacity());
    }

    @Test
    public void testRemoveReservationBelowZero() {
        restaurant.setCurrentGuestsCapacity(34);
        restaurant.removeReservation(35);
        Assertions.assertEquals(0, restaurant.getCurrentGuestsCapacity());
    }

    @Test
    public void testAddGuests(){
        int result = restaurant.addGuests(50);
        assertEquals(250, result);
    }

    @Test
    public void testEnumMethodKitchenTypes(){
        KitchenTypes kitchenTypes = restaurant.kitchenType();
        Assertions.assertNotNull(kitchenTypes);
        Assertions.assertTrue(kitchenTypes instanceof KitchenTypes);
    }

}
