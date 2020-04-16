package Lesson4.Structure;

public class DoubleLinkedList<T> {
    private DoubleLink first;
    private DoubleLink last;
    private int        size;

    public DoubleLinkedList(){
        first = null;
    }

    public boolean isEmpty(){
        return (first == null);
    }

    public void insertFirst(T _item){
        DoubleLink dLink = new DoubleLink<>(_item);
        if (isEmpty()){
            last = dLink;
        } else {
            dLink.setNext(first);
            first.setPrev(dLink);
        }
        first = dLink;
        size++;
    }

    public void insertLast(T _item){
        DoubleLink dlink = new DoubleLink(_item);
        if (isEmpty()){
            first = dlink;
        } else {
            dlink.setPrev(last);
            last.setNext(dlink);
        }
        last = dlink;
        size++;
    }

    public T removeFirst(){
        if(isEmpty()){
            return null;
        }
        DoubleLink oldFirst = first;
        first = oldFirst.next;

        if(isEmpty()) {
            last  = null;
        } else {
            first.setPrev(null);
        }
        size--;
        return (T) oldFirst.getValue();
    }

    public T removeLast(){
        if(isEmpty()){
            return  null;
        }
        DoubleLink oldLast = last;
        if(last.getPrev() != null){
            last.getPrev().setNext(null);
        } else {
            first = null;
        }
        last = oldLast.getPrev();
        size--;
        return (T) oldLast.getValue();
    }

    @Override
    public String toString() {
        DoubleLink current = first;
        StringBuilder sb = new StringBuilder();
        while (current != null) {
            sb.append(current.getValue() + ", ");
            current = current.next;
        }
        return sb.toString();
    }

    public int indexOf(T _item) {
        DoubleLink current = first;
        int index = 0;
        while (current != null) {
            if (current.getValue().equals(_item)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    public void insert(T _item, int _index) {
        if (_index <= 0) {
            insertFirst(_item);
            return;
        }

        if (_index > size) {
            _index = size;
        }

        DoubleLink current = first;

        int i = 0;
        while (i < _index - 1) {
            current = current.next;
            i++;
        }

        DoubleLink newNode = new DoubleLink(_item);
        newNode.setNext(current.next);
        newNode.setPrev(current);
        current.setNext(newNode);
        newNode.getNext().setPrev(newNode);
        size++;
    }

    public boolean remove(T _item) {
        if (isEmpty()) {
            return false;
        }

        if (first.getValue().equals(_item)) {
            removeFirst();
            return true;
        } else if (last.getValue().equals(_item)){
            removeLast();
            return true;
        }

        DoubleLink current = first;
        while (current != null && !current.getValue().equals(_item)) {
            current = current.next;
        }

        if (current == null) {
            return false;
        }

        current.getNext().setPrev(current.prev);
        current.getPrev().setNext(current.next);
        size--;
        return true;

    }

    public boolean contains(T _item) {
        return indexOf(_item) > -1;
    }

    class DoubleLink<T> {
        private T       dLink;
        private DoubleLink<T> next;
        private DoubleLink<T> prev;

        public DoubleLink(T dLink) {
            this.dLink = dLink;
        }

        public DoubleLink<T> getNext() {
            return next;
        }

        public void setNext(DoubleLink<T> next) {
            this.next = next;
        }

        public DoubleLink<T> getPrev() {
            return prev;
        }

        public void setPrev(DoubleLink<T> prev) {
            this.prev = prev;
        }

        public T getValue(){
            return dLink;
        }
    }
}
