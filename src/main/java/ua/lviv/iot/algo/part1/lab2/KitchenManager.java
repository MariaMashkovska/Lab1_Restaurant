package ua.lviv.iot.algo.part1.lab2;

import lombok.Getter;
import lombok.ToString;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

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
        return kitchens.stream()
                        .filter(kitch -> kitch.getCapacity() > capacity)
                        .collect(Collectors.toList());
    }

}
