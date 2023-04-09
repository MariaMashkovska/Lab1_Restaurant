package ua.lviv.iot.algo.part1.lab2;

import lombok.Generated;
import lombok.Getter;
import lombok.ToString;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ToString
@Getter
public class KitchenManager {

    private List<AbstractKitchen> kitchens = new LinkedList<>();

    public void addKitchen(final AbstractKitchen kitchen) {
        kitchens.add(kitchen);
    }

    public List<AbstractKitchen> findAllBiggerThan(final int size) {
        return kitchens.stream()
                .filter(kitch -> kitch.getSize() > size)
                .collect(Collectors.toList());
    }

    public List<AbstractKitchen> findBiggerCapacityThan(final int capacity) {
        Stream<AbstractKitchen> abstractKitchenStream = kitchens.stream()
                .filter(kitch -> kitch.getCapacity() > capacity);
        return abstractKitchenStream
                .collect(Collectors.toList());
    }

    @Generated
    public static void main(final String[] args) {

        KitchenManager manager = new KitchenManager();

        manager.addKitchen(new Restaurant("5-star Restaurant Lola", 200,
                60, 2007, 10,
                150, 34));
        manager.addKitchen(new Restaurant("Restaurant Chebureki v Oleny", 20,
                30, 2017, 8,
                18, 7));

        manager.addKitchen(new HomeKitchen("GuestsHome", 3,
                17, "Gas", "Wink"));
        manager.addKitchen(new HomeKitchen("Home", 5,
                24, "Electrical", "Wink"));

        manager.addKitchen(new Pub("Kafe-bar Victoria", 90,
                45, 1964, "Alcohol", 74));
        manager.addKitchen(new Pub("Kafe-bar Oksana", 100,
                40, 1867, "Alcohol", 60));

        manager.addKitchen(new Pizzeria("Fredbear`s Family Diner", 42,
                58, 1973, "Fuzzy drinks",
                35, 2));
        manager.addKitchen(new Pizzeria("Freddy Fazbear`s Pizzeria", 70,
                100, 1989, "Fuzzy drinks",
                50, 4));

        for (AbstractKitchen kitchen : manager.kitchens) {
            System.out.println(kitchen.toString());
            kitchen.kitchenType();
        }

        System.out.println(manager.findAllBiggerThan(50));
        System.out.println(manager.findBiggerCapacityThan(100));
    }
}