import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ua.lviv.iot.algo.part1.lab2.KitchenTypes;
import ua.lviv.iot.algo.part1.lab2.Restaurant;

import static org.junit.jupiter.api.Assertions.*;

class   RestaurantTest {
    @Test
    public void testConstructor() {
        Restaurant restaurant = new Restaurant("5-star Restaurant Lola", 200, 60, 2007, 10, 150, 34);
        assertEquals("5-star Restaurant Lola", restaurant.getName());
        assertEquals(200, restaurant.getCapacity());
        assertEquals(60, restaurant.getSize());
        assertEquals(2007, restaurant.getYearOfFoundation());
        assertEquals(10, restaurant.getRating());
        assertEquals(150, restaurant.getMaxGuestsCapacity());
        assertEquals(34, restaurant.getCurrentGuestsCapacity());
    }

    @Test
    public void testAcceptReservation() {
        Restaurant restaurant = new Restaurant("5-star Restaurant Lola", 200, 60, 2007, 10, 150, 34);
        boolean reservationAccepted = restaurant.acceptReservation(20);
        Assertions.assertTrue(reservationAccepted);
        Assertions.assertEquals(54, restaurant.getCurrentGuestsCapacity());
    }

    @Test
    public void testAcceptReservationCapacityExceeded() {
        Restaurant restaurant = new Restaurant();
        restaurant.setCurrentGuestsCapacity(40);
        boolean reservationAccepted = restaurant.acceptReservation(15);
        Assertions.assertFalse(reservationAccepted);
        Assertions.assertEquals(40, restaurant.getCurrentGuestsCapacity());
    }

    @Test
    public void testRemoveReservation() {
        Restaurant restaurant = new Restaurant();
        restaurant.setCurrentGuestsCapacity(30);
        restaurant.removeReservation(10);
        Assertions.assertEquals(20, restaurant.getCurrentGuestsCapacity());
    }

    @Test
    public void testRemoveReservationBelowZero() {
        Restaurant restaurant = new Restaurant();
        restaurant.setCurrentGuestsCapacity(20);
        restaurant.removeReservation(25);
        Assertions.assertEquals(0, restaurant.getCurrentGuestsCapacity());
    }

    @Test
    public void testToString() {
        Restaurant restaurant = new Restaurant();
        String expectedString = "Restaurant(super=AbstractKitchen(name=null, capacity=0, size=0), yearOfFoundation=0, rating=0, maxGuestsCapacity=0, currentGuestsCapacity=0, openingTime=9:00, closingTime=18:00)";
        String actualString = restaurant.toString();
        Assertions.assertEquals(expectedString, actualString);
    }

    @Test
    public void testAddGuests(){
        Restaurant restaurant = new Restaurant("5-star Restaurant Lola", 200, 60, 2007, 10, 150, 34);
        int result = restaurant.addGuests(50);
        assertEquals(250, result);
    }

    @Test
    public void testEnumMethodKitchenTypes(){
        Restaurant restaurant = new Restaurant();
        KitchenTypes kitchenTypes = restaurant.kitchenType();
        Assertions.assertNotNull(kitchenTypes);
        Assertions.assertTrue(kitchenTypes instanceof KitchenTypes);
    }
}