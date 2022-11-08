public class GenericPrinter<T> {
    private T input;

    public GenericPrinter(T input) {
        this.input = input;
    }

    public void print() {
        System.out.println(input.toString());
    }

    public T getInput() {
        return this.input;
        //return new Integer(2);
    }

    public static void main(String[] args) {
        GenericPrinter<Integer> gp =
                new GenericPrinter<>(new Integer(2));
        gp.print();

        GenericPrinter<Node> gp2 =
                new GenericPrinter<>(new Node(3));
        gp2.print();
    }
}
