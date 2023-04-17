import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ua.lviv.iot.algo.part1.lab2.HomeKitchen;
import ua.lviv.iot.algo.part1.lab2.KitchenTypes;
import ua.lviv.iot.algo.part1.lab2.Pizzeria;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomeKitchenTest {
    @Test
    public void testConstructor() {
        HomeKitchen homeKitchen = new HomeKitchen("Home", 445, 2434,"Electrical" ,"Wink");
        assertEquals("Home", homeKitchen.getName());
        assertEquals(445, homeKitchen.getCapacity());
        assertEquals(2434, homeKitchen.getSize());
        assertEquals("Electrical", homeKitchen.getTypeOfPlate());
        assertEquals("Wink", homeKitchen.getNameOfHood());
    }

    @Test
    public void testToString() {
        HomeKitchen homeKitchen = new HomeKitchen();
        String expectedString = "HomeKitchen(super=AbstractKitchen(name=null, capacity=0, size=0), typeOfPlate=null, nameOfHood=null)";
        String actualString = homeKitchen.toString();
        Assertions.assertEquals(expectedString, actualString);
    }

    @Test
    public void testAddGuests(){
        HomeKitchen homeKitchen = new HomeKitchen("Home", 445, 2434,"Electrical" ,"Wink");
        int result = homeKitchen.addGuests(3);
        assertEquals(448, result);
    }

    @Test
    public void testEnumMethodKitchenTypes(){
        HomeKitchen homeKitchen = new HomeKitchen("Home", 445, 2434,"Electrical" ,"Wink");
        assertEquals(KitchenTypes.UKRAINIAN, homeKitchen.kitchenType());
    }
    }


