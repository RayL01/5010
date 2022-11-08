import java.util.function.Function;

public class JobDispatcher {
    public static void main(String[] args) {
        Function<Integer, Integer> func = x -> x + 1;
        Worker<Integer, Integer> w = new Worker<>();
        Integer yield = w.exec(func, new Integer(2));
        System.out.println(yield);
    }
}
