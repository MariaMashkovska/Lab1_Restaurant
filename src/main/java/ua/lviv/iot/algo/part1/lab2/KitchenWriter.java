package ua.lviv.iot.algo.part1.lab2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KitchenWriter {

    public void writeToFile(List<AbstractKitchen> kitchens){

        FileWriter fileWriter = null;
        Map<Class, List<AbstractKitchen>> listMap = new HashMap<>();

        try {
            fileWriter = new FileWriter("kitchens.csv");

            for (AbstractKitchen data : kitchens) {
                Class cls = data.getClass();
                List<AbstractKitchen> dataList = listMap.get(cls);
                if (dataList == null) {
                    dataList = new ArrayList<>();
                    listMap.put(cls, dataList);
                }
                dataList.add(data);
            }

            for (Map.Entry<Class, List<AbstractKitchen>> entry : listMap.entrySet()) {
                Class cls = entry.getKey();
                List<AbstractKitchen> dataList = entry.getValue();

                fileWriter.write(cls.getSimpleName() + "s\n");
                for (AbstractKitchen data : dataList) {

                    fileWriter.write(data.getHeaders() + "\n");
                    fileWriter.write(data.toCSV() + "\n");

                }
            }

            fileWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
