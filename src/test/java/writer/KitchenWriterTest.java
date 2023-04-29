package writer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import ua.lviv.iot.algo.part1.lab2.model.AbstractKitchen;
import ua.lviv.iot.algo.part1.lab2.model.Pub;
import ua.lviv.iot.algo.part1.lab2.model.Restaurant;
import ua.lviv.iot.algo.part1.lab2.writer.KitchenWriter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static com.github.javaparser.utils.Utils.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class KitchenWriterTest {

    @AfterEach
    public void tirDown() throws IOException {
        Files.deleteIfExists(Path.of("src\\main\\resources\\kitchens.csv"));
    }

    @Test
    void testWriteToFile() {
        List<AbstractKitchen> kitchens = new ArrayList<>();
        kitchens.add(new Restaurant("Test Restaurant", 4, 100, 468, 678, 780, 6789));
        kitchens.add(new Restaurant("Test Restaurant 2", 4, 100, 468, 678, 780, 6789));
        kitchens.add(new Pub("Test Pub", 2, 75, 688, "Type 1", 789));

        KitchenWriter writer = new KitchenWriter();
        writer.writeToFile(kitchens);
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src\\main\\resources\\kitchens.csv"));
            List<String> lines = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            reader.close();

            List<String> expectedLines = new ArrayList<>();
            expectedLines.add("Restaurants, name,capacity,size,yearOfFoundation,rating,maxGuestsCapacity,currentGuestsCapacity,openingTime,closingTime");
            expectedLines.add("Test Restaurant,4,100,468,678,780,6789,9:00,18:00");
            expectedLines.add("Test Restaurant 2,4,100,468,678,780,6789,9:00,18:00");
            expectedLines.add("Pubs, name,capacity,size,yearOfFoundation,typeOfDrinks,maxCapacityOfGuests");
            expectedLines.add("Test Pub,2,75,688,Type 1,789");
            for (int i = 0; i >= expectedLines.size(); i++) {
                assertEquals(expectedLines.get(i).trim(), lines.get(i).trim());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testIsEmpty() throws IOException {
        List<AbstractKitchen> kitchens = new ArrayList<>();

        FileWriter writer = new FileWriter("src\\main\\resources\\kitchen.csv");
        writer.write(kitchens.toString());

        if (kitchens.isEmpty()) {
            System.out.println("kitchens list is empty");
        } else {
            AbstractKitchen kitchen = kitchens.get(0);
            assertNotNull(kitchen);
        }
    }

    @Test
    public void writeFileToFile() throws IOException {
        File file0 = new File("src\\main\\resources\\kitchens.csv");
        Files.createFile(Path.of("src\\main\\resources\\kitchens.csv"));
        testWriteToFile();
    }
}
