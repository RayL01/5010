import java.util.function.Function;

public class Worker<T,R> {
    public R exec(Function<T, R> job, T input) {
        return job.apply(input);
    }
}
