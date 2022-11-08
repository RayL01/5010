import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class MyLinkedListImpl implements MyLinkedList {
    // common mistake
    //private int[] elements;
    Node head;

    public MyLinkedListImpl() {
        head = null;
    }

    public MyLinkedListImpl(Node head) {
        this.head = head;
    }

    @Override
    public Iterator<Bird> iterator() {
        return new MyLinkedListIterator(this.head);
    }
    Iterator iterator = lsit.iterater();
    while(iterator.hasnext()){
        Bird bird =  iterator.next();
    }
    public int size() {
        Node tp = head;
        int counter = 0;

        while(tp != null) {
            counter++;
            tp = tp.next;
        }

        return counter;

    }

    @Override
    public void add(Bird val) {
        if (head == null) {
            // list is empty.
            head = new Node(val);
            return;
        }

        Node tp = head;
        while(tp.next != null) {
            tp = tp.next;
        }

        // when reaching here, tp is pointing to
        // the last node
        /**
         *
         */

        Bird tp2 = tp.p;

        while(tp2.next != null){
            tp2 = tp2.next;
        }
        tp2.next = new Bird(val.val,null);

        tp.next = new Node(val);
    }

    @Override
    public Bird get(int index) {
        if (index >= this.size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Node tp = head;
        int counter = 0;

        while(tp != null) {
            if (counter == index) {
                // reached the target index
                break;
            }
            counter++;
            tp = tp.next;
        }

        return tp.val;
    }

    @Override
    public void remove(int index) {
        if (index >= this.size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (index == 0) {
            // removing the first node
            Bird val = head.val;
            head = head.next;
            return;
        }

        Node tp = head;
        // prev is always updated to point to
        // the one before `tp`.
        Node prev = null;
        int counter = 0;

        while(tp != null) {
            if (counter == index) {
                // reached the target index
                break;
            }
            counter++;
            prev = tp;
            tp = tp.next;
        }

        // when reaching out, tp is pointing to
        // the node at `index`.
        prev.next = tp.next;
    }

    // condition: elements >= 4
    @Override
    public MyLinkedList subList(Bird target) {
        MyLinkedList newList = new MyLinkedListImpl();
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).compareTo(target) > 0) {
                newList.add(this.get(i));
            }
        }
        return newList;
    }

    public MyLinkedList subList(Predicate<Bird> cond) {
        MyLinkedList newList = new MyLinkedListImpl();
        for (int i = 0; i < this.size(); i++) {
            if (cond.test(this.get(i)) == true) {
                newList.add(this.get(i));
            }
        }
        return newList;
    }

    public static void main(String[] args) {
        /*
        Node<Integer> node1 = new Node<>(1, null);
        Node<Integer> node7 = new Node<>(7, node1);
        Node<Integer> node3 = new Node<>(3, node7);

        MyLinkedList<Integer> list =
                new MyLinkedListImpl<>(node3);
        System.out.println(list.size());
        System.out.println(list.size());

        System.out.println(list.get(1));
        System.out.println(list.get(0));
        System.out.println(list.get(list.size()-1));

        MyLinkedList<Integer> list1 =
                new MyLinkedListImpl<>();
        list1.add(2);
        list1.add(3);
        System.out.println(list1.size());

        list1.remove(0);
        System.out.println(list1.size());
        */

        //System.out.println(list.subList().size());

//        List<Node> list3 = new ArrayList<>();
//        list3.add(new Node(3));
        //Collections.sort(list3);

        //List<Integer> myDS = new ArrayList<>();
        //Set<Integer> myDS = new TreeSet<>();
        MyLinkedList<Integer> myDS = new MyLinkedListImpl<>();
        myDS.add(3);
        myDS.add(5);
//        for (int i = 0; i < myDS.size(); i++) {
//            System.out.print(myDS.get(i));
//        }
        Iterator<Integer> it = myDS.iterator();
        while(it.hasNext()) {
            Integer i = it.next();
            System.out.println(i);
        }

    }

}
