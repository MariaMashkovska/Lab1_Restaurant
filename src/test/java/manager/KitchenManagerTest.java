package manager;

import org.junit.jupiter.api.Test;

import ua.lviv.iot.algo.part1.lab2.manager.KitchenManager;
import ua.lviv.iot.algo.part1.lab2.model.Restaurant;
import ua.lviv.iot.algo.part1.lab2.model.AbstractKitchen;
import ua.lviv.iot.algo.part1.lab2.model.HomeKitchen;
import ua.lviv.iot.algo.part1.lab2.model.Pizzeria;
import ua.lviv.iot.algo.part1.lab2.model.Pub;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class KitchenManagerTest {

    @Test
    public void testAddKitchen() {

        KitchenManager manager = new KitchenManager();
        AbstractKitchen kitchen = new Restaurant("5-star Restaurant Lola", 200, 60, 2007, 10, 150, 34);

        manager.addKitchen(kitchen);

        assertTrue(manager.getKitchens().contains(kitchen));

    }

    @Test
    public void testFindAllBiggerThan() {
        KitchenManager manager = new KitchenManager();

        manager.addKitchen(new Restaurant("5-star Restaurant Lola", 200, 60, 2007, 10, 150, 34));
        manager.addKitchen(new HomeKitchen("GuestsHome", 3, 17, "Gas", "Wink"));
        manager.addKitchen(new Pizzeria("Fredbear`s Family Diner", 30, 58, 1973, "Fuzzy drinks", 35, 2));

        List<AbstractKitchen> kitchens = manager.findAllBiggerThan(40);

        assertEquals(2, kitchens.size());

        for (AbstractKitchen kitchen : kitchens) {
            assertTrue(kitchen.getSize() > 40);
        }
    }

    @Test
    public void testFindBiggerCapacityThan(){
        KitchenManager manager = new KitchenManager();

        manager.addKitchen(new Restaurant("5-star Restaurant Lola", 200, 60, 2007, 10, 150, 34));
        manager.addKitchen(new HomeKitchen("GuestsHome", 3, 17, "Gas", "Wink"));
        manager.addKitchen(new Pub("Kafe-bar Victoria", 90, 45, 1964, "Alcohol", 74));
        manager.addKitchen(new HomeKitchen("Home", 5, 24, "Electrical", "Wink"));
        manager.addKitchen(new Pizzeria("Freddy Fazbear`s Pizzeria", 70, 100, 1989, "Fuzzy drinks", 50, 4));


        List<AbstractKitchen> kitchens = manager.findBiggerCapacityThan(10);

        assertEquals(3, kitchens.size());

        for (AbstractKitchen kitchen : kitchens) {
            assertTrue(kitchen.getCapacity() > 10);
        }

    }

}
