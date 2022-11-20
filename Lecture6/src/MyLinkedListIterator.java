import java.util.Iterator;

public class MyLinkedListIterator implements Iterator<Bird> {
    Node head;
    Node tp;
    Bird tp2;

    // The input `head` is the head of the linked list
    // that user will traverse using this iterator.
    public MyLinkedListIterator(Node head) {
        this.head = head;
        this.tp = this.head;
        tp2 = this.tp.p;
    }

    @Override
    public boolean hasNext() {
        if(tp2 == null){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public Bird next() {
        Bird bird = tp2;
        if(tp2.next == null){
            if(tp.next == null){

                tp2 = null;
            }
            while(tp.next != null){
                tp = tp.next;
                tp2 = tp.p;
            }


        }else{
            tp2 = tp2.next;
        }
        return bird;

    }

}
