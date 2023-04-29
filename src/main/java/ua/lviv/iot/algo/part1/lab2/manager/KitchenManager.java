package ua.lviv.iot.algo.part1.lab2.manager;

import lombok.Getter;
import lombok.ToString;
import ua.lviv.iot.algo.part1.lab2.model.AbstractKitchen;
import ua.lviv.iot.algo.part1.lab2.writer.KitchenWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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

    public void print(String word, int n) throws IOException {
        FileWriter file = new FileWriter("fgfje");
        for (n = 1; n<=5; n++) {
            file.write(word);
        }
        // передаю стрінгу, записати в файл стрінгу н разів
        //
    }

}
