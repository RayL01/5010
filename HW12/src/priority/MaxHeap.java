package priority;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2022/12/04/14:28
 * @Description: Construct a heap where the root has the highest priority
 */
public class MaxHeap<T> {
  private List<Node<T>> heap;
  T item;

  public MaxHeap() {
    this.heap = new ArrayList<>();
  }

  //sifting up

  /**
   *
   * @param n is the index of the heap array list
   */
  private void siftUp(int n) {
    while (n > 0 && heap.get(n).compareTo(heap.get((n - 1) / 2)) == 1 || (n > 0 &&(heap.get(n).compareTo(heap.get((n - 1) / 2)) == 0 ) && (heap.get(n).time > heap.get((n - 1) / 2).time))){//current node is bigger than its father
      //swap Nodes
      swap(n, (n - 1) / 2);

      //update n and keep sifting up
      n = (n - 1) / 2;
    }
  }

  /**
   *
   * @param n is the index of heap array list
   */
  private void siftDown(int n) {
    //First, we have to make sure the current node does have children
    if(heap.size() == 1) return;
    while (n <= (heap.size() - 2) / 2) {
      //First, we assume the left child is the bigger node
      int maxChild = (2 * n) + 1;

      // determine which child is bigger and we must determine whether the current node has a right child or not.
      if ((2 * n + 2 < heap.size() && heap.get(maxChild).compareTo(heap.get(maxChild + 1)) == -1) || ((2 * n + 2 < heap.size() && (heap.get(maxChild).compareTo(heap.get(maxChild + 1)) == 0 ) && (heap.get(maxChild).time < heap.get(maxChild + 1 ).time)))) {
        maxChild += 1;
      }

      //Then we have to determine the relationship between the magnitude of two nodes.
      if ((heap.get(n).compareTo(heap.get(maxChild)) == -1) ||((heap.get(n).compareTo(heap.get(maxChild)) == 0 ) && (heap.get(n).time < heap.get(maxChild).time))) {// less than child
        //swap the elements
        swap(n, maxChild);

        //update n
        n = maxChild;
      } else {
        break;
      }
    }
  }


  /**
   * pop out the element with the highest priority
   * @return
   */
  public T extractMax(){
    if(heap.size() == 0){
      throw new IllegalStateException("the size can not be 0 !");
    }
    Node<T> max = heap.get(0);
    //swap the head and tail elements
    swap(0, heap.size() - 1);

    //delete the last element
    heap.remove(heap.size() - 1);

    //Sift down the root element
    siftDown(0);
    return max.item;
  }


  /**
   * Add a new element to the heap
   * @param node
   */
  public void add(Node node){
    heap.add(node);

    //Sifting up from the bottom of the heap
    siftUp(heap.size() - 1);
  }


  /**
   * swap the elements in the heap
   * @param i
   * @param j
   */
  public void swap(int i, int j){
      Node TMP = heap.get(i);
      heap.set(i, heap.get(j));
      heap.set(j, TMP);
  }
  public int size(){
    return heap.size();
  }




}
