package ua.lviv.iot.algo.part1.lab2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public abstract class AbstractKitchen {
    private String name;
    private int capacity;
    private int size;
    public String getHeaders() {
        return  "name" + "," +
                "capacity" + "," +
                "size";
    }

    public String toCSV() {
        return  name + "," +
                capacity + "," +
                size;
    }



    public abstract int addGuests(int guests);
    public abstract KitchenTypes kitchenType();

}
