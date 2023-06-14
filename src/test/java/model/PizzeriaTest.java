package model;

import org.junit.jupiter.api.Test;

import ua.lviv.iot.algo.part1.lab2.model.KitchenTypes;
import ua.lviv.iot.algo.part1.lab2.model.Pizzeria;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PizzeriaTest {

    Pizzeria pizzeria = new Pizzeria("Freddy Fazbear`s Pizzeria", 70, 100, 1989, "Fuzzy drinks", 50, 4);

    @Test
    public void testGetHeaders(){
        String expectedHeaders = "name,capacity,size,yearOfFoundation,typeOfDrinks,capacityOfSeats,capacityOfAnimatronics";
        String actualHeaders = pizzeria.getHeaders();
        assertEquals(expectedHeaders, actualHeaders);
    }

    @Test
    public void testAddGuests(){
        int result = pizzeria.addGuests(12);
        assertEquals(82, result);
    }

    @Test
    public void testEnumMethodKitchenTypes(){
        assertEquals(KitchenTypes.AMERICAN, pizzeria.kitchenType());
    }

}
