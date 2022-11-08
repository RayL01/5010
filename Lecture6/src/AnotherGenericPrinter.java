public class AnotherGenericPrinter {
    private Object input;

    public AnotherGenericPrinter(Object input) {
        this.input = input;
    }
    public void print() {
        System.out.println(input.toString());
    }

    public Object getInput() {
        //return this.input;
        return new Integer(2);
    }

    public static void main(String[] args) {
        AnotherGenericPrinter gp =
                new AnotherGenericPrinter(new Integer(2));
        gp.print();

        AnotherGenericPrinter gp2 =
                new AnotherGenericPrinter(new Node(3));
        gp2.print();
    }
}
