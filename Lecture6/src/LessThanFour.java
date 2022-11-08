import java.util.function.Function;
import java.util.function.Predicate;

public class LessThanFour implements Predicate<Integer>
{
    private int y;

    public LessThanFour(int y) {
        this.y = y;
    }

    @Override
    public boolean test(Integer x) {
        return x + y < 4;
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedListImpl<>();
        list.add(3);
        list.add(1);
        list.add(5);
        //Predicate<Integer> pred = new LessThanFour();
        //Predicate<Integer> pred = x -> x < 4;
        //Function<Integer, Boolean> pred = x -> x < 4;
        int y = 3;
        Predicate<Integer> pred = new LessThanFour(y);
        //Predicate<Integer> pred = x -> x+y < 4;
        MyLinkedList<Integer> newlist = list.subList(pred);
        System.out.println(newlist.size());
    }

}
