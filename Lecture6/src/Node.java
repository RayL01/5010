public class Node {
    Bird p;
    Node next;

    public Node(Bird p, Node next) {
        this.p = p;

        this.next = next;
    }

    public Node(Bird p) {
        this.p = p;
        this.next = null;
    }


}
