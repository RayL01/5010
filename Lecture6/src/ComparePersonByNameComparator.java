import java.util.*;

public class ComparePersonByNameComparator
    implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        String name1 = o1.getName();
        String name2 = o2.getName();
        return name1.compareTo(name2);
    }

    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person(2, "A"));
        list.add(new Person(1, "B"));
        Collections.sort(list);
        for (Person p : list) {
            System.out.println(p);
        }
        Collections.sort(list,
                new ComparePersonByNameComparator());
        for (Person p : list) {
            System.out.println(p);
        }
    }
}
