import java.util.Iterator;

public class Array implements Iterable<Integer> {
    private int[] arr;

    public Array() {
        arr = new int[5];
        arr[0] = 1;
        arr[1] = 10;
        arr[2] = 11;
        arr[3] = 31;
        arr[4] = 21;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new ArrayIterator(arr);
    }
}
