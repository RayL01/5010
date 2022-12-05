package priority;


import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

import javax.swing.text.Keymap;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2022/12/03/21:45
 * @Description: In order to implement a priority queue, I
 */
public class MinMaxPriorityQueueImpl<T> implements MinMaxPriorityQueue<T>{
  MaxHeap<T> maxHeap;
  MinHeap<T> minHeap;
  int timer;


  public MinMaxPriorityQueueImpl() {
    maxHeap = new MaxHeap<>();
    minHeap = new MinHeap<>();
    timer = 0;
  }


  @Override
  public void add(T item, int priority) {

    Node<T> node = new Node<>(item, priority,timer--);
    maxHeap.add(node);
    minHeap.add(node);
  }

  @Override
  public T minPriorityItem() {
    return minHeap.extractMin();
  }

  @Override
  public T maxPriorityItem() {
    return maxHeap.extractMax();
  }
  public int sizeofMaxHeap(){
    return maxHeap.size();
  }
  public int sizeofMinHeap(){
    return minHeap.size();
  }
}
