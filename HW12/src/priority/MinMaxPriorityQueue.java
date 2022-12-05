package priority;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2022/12/03/21:42
 * @Description:
 */
public interface MinMaxPriorityQueue <T>{


  /**
   * add an item with the given priority into the queue.
   * @param item
   * @param priority
   */
  void add(T item, int priority);

  /**
   * remove and return the item with the minimum priority (as defined by the lowest numeric priority above). If such an item does not exist, this method should return null.
   * @return
   */
  T minPriorityItem();


  /**
   * remove and return the item with the maximum priority (as defined by the highest numeric priority above). If such an item does not exist, this method should return null.
   * @return
   */
  T maxPriorityItem();

  /**
   * return the size of the maxheap
   * @return
   */
   int sizeofMaxHeap();

  /**
   * return the size of the minheap
   * @return
   */
   int sizeofMinHeap();



}
