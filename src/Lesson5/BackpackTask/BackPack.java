package Lesson5.BackpackTask;
import java.util.ArrayList;
import java.util.HashSet;

class BackPack extends HashSet<Item> {
    private int volume;
    private int occupiedVloume;

    public BackPack(int volume) {
        this.volume         = volume;
        this.occupiedVloume = 0;
    }

    public int getVolume() {
        return volume;
    }

    public int getFreeSpace(){
        return  volume - occupiedVloume;
    }

    @Override
    public boolean add(Item item) {
        this.occupiedVloume += item.getVolume();
        return super.add(item);
    }

    public void pack(ArrayList<Item> _itemList){
        System.out.println(String.format("Доступный объем %d литра(ов).", getFreeSpace()));
        if (_itemList.stream().noneMatch(e -> e.getVolume() <= getFreeSpace())){
            System.out.println("Нет вещей подходящего размера.");
        } else {
            Item temp = _itemList.stream().filter(e -> e.getVolume() <= getFreeSpace()).max(Item::compareTo).get();
            System.out.println("Предмет " + temp + " Добавлен в рюкзак.");
            add(temp);
            _itemList.remove(temp);
            pack(_itemList);

        }
    }

    public void print(){
        System.out.println("----Уложено----");
        this.stream().forEach(e -> System.out.println(e.toString()));
        System.out.println("----------------");
        System.out.println(String.format("Осталось свободного метса %d литров.", getFreeSpace()));
    }
}