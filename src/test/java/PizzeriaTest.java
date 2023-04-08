import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ua.lviv.iot.algo.part1.lab2.KitchenTypes;
import ua.lviv.iot.algo.part1.lab2.Pizzeria;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PizzeriaTest {

    @Test
    public void testConstructor() {
        Pizzeria pizzeria = new Pizzeria("Freddy Fazbear`s Pizzeria", 70, 100, 1989, "Fuzzy drinks", 50, 4);
        assertEquals("Freddy Fazbear`s Pizzeria", pizzeria.getName());
        assertEquals(70, pizzeria.getCapacity());
        assertEquals(100, pizzeria.getSize());
        assertEquals(1989, pizzeria.getYearOfFoundation());
        assertEquals("Fuzzy drinks", pizzeria.getTypeOfDrinks());
        assertEquals(50, pizzeria.getCapacityOfSeats());
        assertEquals(4, pizzeria.getCapacityOfAnimatronics());
    }

    @Test
    public void testToString() {
        Pizzeria pizzeria = new Pizzeria();
        String expectedString = "Pizzeria(super=AbstractKitchen(name=null, capacity=0, size=0), yearOfFoundation=0, typeOfDrinks=null, capacityOfSeats=0, capacityOfAnimatronics=0)";
        String actualString = pizzeria.toString();
        Assertions.assertEquals(expectedString, actualString);
    }

    @Test
    public void testAddGuests(){
        Pizzeria pizzeria = new Pizzeria("Freddy Fazbear`s Pizzeria", 70, 100, 1989, "Fuzzy drinks", 50, 4);
        int result = pizzeria.addGuests(12);
        assertEquals(82, result);
    }

    @Test
    public void testEnumMethodKitchenTypes(){
        Pizzeria pizzeria = new Pizzeria("Freddy Fazbear`s Pizzeria", 70, 100, 1989, "Fuzzy drinks", 50, 4);
        assertEquals(KitchenTypes.AMERICAN, pizzeria.kitchenType());
    }

}