package lookandsay;

import java.math.BigInteger;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2022/11/17/21:53
 * @Description:
 * Define a new RIterator interface that extends Iterator and adds two methods: T prev() and boolean hasPrevious().
 * Their meanings are self-explanatory. Then define a class LookAndSayIterator that implements RIterator.
 * This iterator will return the numbers as BigInteger objects.
 */
public interface  RIterator<T> extends Iterator<T> {
  T prev();
  boolean hasPrevious();
}
