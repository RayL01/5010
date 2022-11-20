package lookandsay;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2022/11/18/14:11
 * @Description:
 */

import java.util.Iterator;

/**
 * @author novo
 * @since 2021/11/11
 */
public interface RIterator<T> extends Iterator<T> {
  T prev();

  boolean hasPrevious();
}
