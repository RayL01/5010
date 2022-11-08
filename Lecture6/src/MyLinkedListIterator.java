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
            while(tp.next != null){
                if(tp.next.p == null){
                    tp = tp.next;
                }else{
                    tp = tp.next;
                    tp2 = tp.p;
                    return true;
                }
            }
            if(tp.p == null){
                return false;
            }else{
                tp2 = tp.p;
                return true;
            }
        }else{
            return true;
        }
    }

    @Override
    public Bird next() {
        int val = tp2.val;
        tp2 = tp2.next;
        return tp2;

    }

}
