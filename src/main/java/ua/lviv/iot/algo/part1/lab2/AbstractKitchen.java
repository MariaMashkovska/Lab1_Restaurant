package ua.lviv.iot.algo.part1.lab2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

enum KitchenTypes{
    UKRAINIAN,
    JAPANESE,
    POLISH,
    CHINESE,
    AMERICAN,
    KOREAN
}

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public abstract class AbstractKitchen {

    private String name;
    private int capacity;
    private int size;

    public abstract void addGuests(int guests);
    public abstract KitchenTypes kitchenType();

}
