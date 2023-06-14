package ua.lviv.iot.algo.part1.lab2.writer;

import ua.lviv.iot.algo.part1.lab2.model.AbstractKitchen;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class KitchenWriter {
    public void writeToFile(List<AbstractKitchen> kitchens) {

        File file = new File("src\\main\\resources\\kitchens.csv");

        Collections.sort(kitchens,
                Comparator.comparing(o -> o.getClass().getName()));

        Collections.sort(kitchens, Comparator.comparing(l -> l.getClass().getSimpleName()));
        try (PrintWriter pw = new PrintWriter(file)) {
            AbstractKitchen writtenKitchen = kitchens.get(0);
            pw.println(kitchens.get(0).getHeaders());
            for (var kitchen : kitchens) {
                if (writtenKitchen.getClass() != kitchen.getClass()) {
                    writtenKitchen = kitchen;
                    pw.println(kitchen.getHeaders());
                }
                pw.println(kitchen.toCSV());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    }
