package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ua.lviv.iot.algo.part1.lab2.model.KitchenTypes;
import ua.lviv.iot.algo.part1.lab2.model.Pub;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PubTest {
    Pub pub = new Pub("Kafe-bar Victoria", 90, 45, 1964, "Alcohol", 74);

    @Test
    public void testGetHeaders(){
        String expectedHeaders = "name,capacity,size,yearOfFoundation,typeOfDrinks,maxCapacityOfGuests";
        String actualHeaders = pub.getHeaders();
        assertEquals(expectedHeaders, actualHeaders);
    }

    @Test
    public void testAddGuests(){
        int result = pub.addGuests(3);
        assertEquals(93, result);
    }

    @Test
    public void testEnumMethodKitchenTypes(){
        KitchenTypes kitchenTypes = pub.kitchenType();
        Assertions.assertNotNull(kitchenTypes);
        Assertions.assertTrue(kitchenTypes instanceof KitchenTypes);
    }

}
