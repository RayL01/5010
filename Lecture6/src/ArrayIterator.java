import java.util.Iterator;

class ArrayIterator implements Iterator<Integer> {
    private int arr[];
    private int index;
    public ArrayIterator(int[] arr) {
        this.arr = arr;
        index = 0;
    }

    @Override
    public boolean hasNext() {
        return index != arr.length;
    }

    @Override
    public Integer next() {
        int cur = arr[index];
        index++;
        return cur;
    }

    public static void main(String[] args) {
        Array a = new Array();

        Iterator<Integer> it = a.iterator();
        while(it.hasNext()) {
            Integer i = it.next();
            System.out.println(i);
        }
    }
}