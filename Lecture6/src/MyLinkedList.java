import java.util.function.Predicate;

public interface MyLinkedList extends Iterable<Bird> {
    void add(Bird val);
    Bird get(int index);
    void remove(int index);
    int size();

}
