package Lesson5;

class MyArr{
    private int[] arr;
    private int size;

    public MyArr(int size) {
        this.size = 0;
        this.arr = new int[size];
    }

    public String binaryFind(int search) throws Exception {
        return recBinaryFind(search, 0, size-1);
    }

    private String recBinaryFind(int searchKey, int low, int high) throws Exception {
        int curIn;
        curIn = (low + high ) / 2;
        if (arr[curIn] == searchKey)
            return String.format("Индекс искомого элемента - %d", curIn);
        else
        if(low > high)
            throw new Exception("Элемент не найден");
        else{
            if(arr[curIn] < searchKey)
                return recBinaryFind(searchKey, curIn+1, high);
            else
                return recBinaryFind(searchKey, low, curIn-1);
        }
    }

    public void insert(int value){
        int i;
        for(i=0;i<this.size;i++){
            if (this.arr[i]>value)
                break;
        }
        for(int j=this.size;j>i;j--){
            this.arr[j] = this.arr[j-1];
        }
        this.arr[i] = value;
        this.size++;
    }
}

class MyArrApp {
    public static void main(String[] args) {
        MyArr arr = new MyArr(6);
        arr.insert(1);
        arr.insert(2);
        arr.insert(3);
        arr.insert(14);
        arr.insert(18);
        arr.insert(20);

        int search = 14;

        try {
            System.out.println(arr.binaryFind(search));
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}

