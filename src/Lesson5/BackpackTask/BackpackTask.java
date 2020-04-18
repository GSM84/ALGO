package Lesson5.BackpackTask;

import java.util.ArrayList;

public class BackpackTask {

    public static void main(String[] args) {
        BackPack b = new BackPack(20);

        ArrayList<Item> itemList = new ArrayList<>();

        itemList.add(new Item("Часы", 1, 200));
        itemList.add(new Item("Карта", 2, 10));
        itemList.add(new Item("Вода", 5, 20));
        itemList.add(new Item("Спальный мешок", 10, 50));
        itemList.add(new Item("Одежда", 5, 10));
        itemList.add(new Item("Еда", 5, 30));

        b.pack(itemList);

        b.print();
    }

}

