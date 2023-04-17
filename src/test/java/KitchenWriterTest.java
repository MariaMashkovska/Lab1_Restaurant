import org.junit.jupiter.api.Test;
import ua.lviv.iot.algo.part1.lab2.AbstractKitchen;
import ua.lviv.iot.algo.part1.lab2.KitchenWriter;
import ua.lviv.iot.algo.part1.lab2.Pub;
import ua.lviv.iot.algo.part1.lab2.Restaurant;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KitchenWriterTest {

    @Test
    void testWriteToFile() {
        List<AbstractKitchen> kitchens = new ArrayList<>();
        kitchens.add(new Restaurant("Test Restaurant", 4, 100, 468, 678, 780, 6789));
        kitchens.add(new Pub("Test Pub", 2, 75, 688, "Type 1", 789));

        KitchenWriter writer = new KitchenWriter();
        writer.writeToFile(kitchens);

        try {
        BufferedReader reader = new BufferedReader(new FileReader("kitchens.csv"));
        List<String> lines = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        reader.close();

        List<String> expectedLines = new ArrayList<>();
        expectedLines.add("Restaurants, name,capacity,size,yearOfFoundation,rating,maxGuestsCapacity,currentGuestsCapacity,openingTime,closingTime");
        expectedLines.add("Test Restaurant,4,100,468,678,780,6789,9:00,18:00");
        expectedLines.add("Pubs, name,capacity,size,yearOfFoundation,typeOfDrinks,maxCapacityOfGuests");
        expectedLines.add("Test Pub,2,75,688,Type 1,789");

        for(int i = 0; i>=expectedLines.size(); i++) {
            assertEquals(expectedLines.get(i).trim(), lines.get(i).trim());
        }
    } catch (IOException e) {
    throw new RuntimeException(e);
        }
    }

}
