package model;

import org.junit.jupiter.api.Test;
import ua.lviv.iot.algo.part1.lab2.model.HomeKitchen;
import ua.lviv.iot.algo.part1.lab2.model.KitchenTypes;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomeKitchenTest {

    HomeKitchen homeKitchen = new HomeKitchen("Home", 445, 2434,"Electrical" ,"Wink");

    @Test
    public void testGetHeaders(){
        String expectedHeaders = "name,capacity,size,typeOfPlate,nameOfHood";
        String actualHeaders = homeKitchen.getHeaders();
        assertEquals(expectedHeaders, actualHeaders);
    }

    @Test
    public void testAddGuests(){
        int result = homeKitchen.addGuests(3);
        assertEquals(448, result);
    }

    @Test
    public void testEnumMethodKitchenTypes(){
        assertEquals(KitchenTypes.UKRAINIAN, homeKitchen.kitchenType());
    }

}
