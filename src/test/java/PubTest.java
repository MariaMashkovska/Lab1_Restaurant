import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ua.lviv.iot.algo.part1.lab2.KitchenTypes;
import ua.lviv.iot.algo.part1.lab2.Pub;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PubTest {

    @Test
    public void testConstructor() {
        Pub pub = new Pub("Kafe-bar Victoria", 90, 45, 1964, "Alcohol", 74);
        assertEquals("Kafe-bar Victoria", pub.getName());
        assertEquals(90, pub.getCapacity());
        assertEquals(45, pub.getSize());
        assertEquals(1964, pub.getYearOfFoundation());
        assertEquals("Alcohol", pub.getTypeOfDrinks());
        assertEquals(74, pub.getMaxCapacityOfGuests());
    }

    @Test
    public void testToString() {
        Pub pub = new Pub();
        String expectedString = "Pub(super=AbstractKitchen(name=null, capacity=0, size=0), yearOfFoundation=0, typeOfDrinks=null, maxCapacityOfGuests=0)";
        String actualString = pub.toString();
        Assertions.assertEquals(expectedString, actualString);
    }

    @Test
    public void testAddGuests(){
        Pub pub = new Pub("Kafe-bar Victoria", 90, 45, 1964, "Alcohol", 74);
        int result = pub.addGuests(3);
        assertEquals(93, result);
    }

    @Test
    public void testEnumMethodKitchenTypes(){
        Pub pub = new Pub();
        KitchenTypes kitchenTypes = pub.kitchenType();
        Assertions.assertNotNull(kitchenTypes);
        Assertions.assertTrue(kitchenTypes instanceof KitchenTypes);
    }

}