package priority;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2022/12/04/19:31
 * @Description:
 */
public class Node<R> implements Comparable<Node<R>>{
    R item;
    int priority;
    int time;

    public Node(R item, int priority, int time) {
      this.item = item;
      this.priority = priority;
      this.time = time;
    }


    @Override
    public int compareTo(Node o) {
      if(this.priority > o.priority){
        return 1;
      }else if(this.priority < o.priority){
        return -1;
      }else{//priority is equal
        if(this.priority == o.priority){
          if(this.time > o.time){
            return 1;
          }else if (this.time < o.time){
            return -1;
          }else{
            return 0;
          }
        }
      }
      throw new RuntimeException("error!");
    }

    public R getItem(){
      return this.item;
    }



}
