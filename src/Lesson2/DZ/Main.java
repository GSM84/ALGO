package Lesson2.DZ;

import java.util.Arrays;

public class Main {
    private static final int MAX = 1000;
    private static final int MIN = 1;

    private int   length;
    private int[] arr;

    public Main(int _length){
        this.length = _length;
        this.arr    = new int[_length];
    }

    public static void main(String[] args) {
        Main arrOper = new Main(10);
        arrOper.init();

        arrOper.printArray();

        System.out.println(arrOper.getElementByIndex(5));

        System.out.println(arrOper.getIndexByValue(arrOper.arr[4]));

        arrOper.deleteByIndex(3);

        arrOper.printArray();

        /*
        Main buble = new Main(1000000);
        buble.init();
        buble.bubleSort();

        Main select = new Main(1000000);
        select.init();
        select.selectSort();

        Main insert = new Main(1000000);
        insert.init();
        insert.inserSort();
        */
    }

    public void init(){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * ((MAX - MIN) + 1)) + MIN;
        }
    }

    public int getElementByIndex(int _index){
        return (_index < arr.length)?arr[_index]:-1;
    }

    public int getIndexByValue(int _value){
        int i;
        for (i = 0; i < length; i++) {
            if (arr[i] == _value)
                break;
        }

        return i;
    }

    void add(int _newElement){
        if (length == arr.length) {
            System.out.println("create new array");

            arr = Arrays.copyOf(arr, arr.length + 1);
            arr[arr.length - 1] = _newElement;
            length = arr.length;
        } else {
            System.out.println("add at last position");

            arr[length] = _newElement;
            length++;
        }
    }

    void deleteByIndex(int _index){
        length--;
        for (int i = _index; i < length; i++) {
            arr[i] = arr[i+1];
        }
    }

    void deleteByValue(int _element){
        int i = 0;

        for (i = 0; i < length; i++) {
            if (arr[i] == _element)
                break;
        }

        length--;
        for (int j = i; j < length; j++) {
            arr[j] = arr[j + 1];
        }
    }

    public void printArray(){
        System.out.print("[");
        for (int i = 0; i < length; i++) {
            System.out.print(arr[i] + ((i == length-1)?"]" : ", "));
        }
        System.out.println();
    }

    public void bubleSort(){
        long start = System.currentTimeMillis();

        for (int i = length -1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if(arr[j] > arr[i])
                    replace(i, j);
            }
        }
        System.out.println("Time spent - " + (System.currentTimeMillis() - start) + " mils.");
    }

    public void selectSort(){
        long start = System.currentTimeMillis();

        int maxIndex;
        int iterations = arr.length;

        while (iterations > 1) {
            maxIndex = 0;
            for (int i = 1; i < iterations; i++) {
                if (arr[i] > arr[maxIndex])
                    maxIndex = i;
            }
            replace(maxIndex, iterations - 1);
            iterations--;
        }
        System.out.println("Time spent - " + (System.currentTimeMillis() - start) + " mils.");
    }

    public void inserSort(){
        long start = System.currentTimeMillis();

        for(int i = 1;i < arr.length;i++) {
            for (int j = i; j > 0 && arr[j - 1] > arr[j]; j--) { // пока j>0 и элемент j-1 > j
                replace(j - 1, j);
            }
        }
        System.out.println("Time spent - " + (System.currentTimeMillis() - start) + " mils.");
    }


    public void replace(int _i, int _j){
        int temp = arr[_i];
        arr[_i] = arr[_j];
        arr[_j] = temp;
    }
}
