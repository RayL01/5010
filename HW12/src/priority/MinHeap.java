package priority;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2022/12/04/15:51
 * @Description: Construct a heap where the root has the highest priority
 */
public class MinHeap<T> {
  private List<Node<T>> heap;

  public MinHeap() {
    heap = new ArrayList<>();
  }


  //sifting up

  /**
   *
   * @param n is the index of the heap array list
   */
  private void siftUp(int n) {
    while ((n > 0 && heap.get(n).compareTo(heap.get((n - 1) / 2)) == -1) || (n > 0 && (heap.get(n).compareTo(heap.get((n - 1) / 2)) == 0 ) && (heap.get(n).time > heap.get((n - 1) / 2).time))) {//current node is less than its father
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
    while (n <= (heap.size() - 2) / 2) {
      if (heap.size() == 1) return;
      //First, we assume the left child is the smaller node
      int minChild = (2 * n) + 1;

      // determine which child is smaller and we must determine whether the current node has a right child or not.
      if ((2 * n + 2 < heap.size() && heap.get(minChild).compareTo(heap.get(minChild + 1)) == 1) || ((2 * n + 2 < heap.size() && (heap.get(minChild).compareTo(heap.get(minChild + 1)) == 0 ) && (heap.get(minChild).time > heap.get(minChild + 1 ).time)))) {
        minChild += 1;
      }

      //Then we have to determine the relationship between the magnitude of two nodes.
      if (heap.get(n).compareTo(heap.get(minChild)) == 1 ||((heap.get(n).compareTo(heap.get(minChild)) == 0 ) && (heap.get(n).time > heap.get(minChild).time))) {// Larger than child
        //swap the elements
        swap(n, minChild);

        //update n
        n = minChild;
      } else {
        break;
      }
    }
  }


  /**
   * pop out the element with the highest priority
   * @return
   */
  public T extractMin(){
    if(heap.size() == 0){
      throw new IllegalStateException("the size can not be 0 !");
    }
    Node<T> min = heap.get(0);
    //swap the head and tail elements
    swap(0, heap.size() - 1);

    //delete the last element
    heap.remove(heap.size() - 1);

    //Sift down the root element
    siftDown(0);
    return min.item;

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
