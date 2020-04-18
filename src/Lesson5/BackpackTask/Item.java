package Lesson5.BackpackTask;

class Item implements Comparable<Item>{
    private String name;
    private int volume;
    private float price;

    public Item(String _name, int _volume, float _price) {
        this.name   = _name;
        this.volume = _volume;
        this.price  = _price;
    }

    public int getVolume() {
        return volume;
    }

    public float getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Item _item) {
        int cmpRes;
        if ((price / volume) > (_item.getPrice() / _item.getVolume())){
            cmpRes = 1;
        } else if ((price / volume) > (_item.getPrice() / _item.getVolume())){
            cmpRes = 0;
        }else{
            cmpRes = -1;
        }
        return cmpRes;
    }

    @Override
    public String toString() {
        return String.format("%s, занимаемый объем %d, цена %1.2f.", name, volume, price);
    }
}
