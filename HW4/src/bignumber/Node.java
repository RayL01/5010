package bignumber;

/**
 * Node represents each digit
 *
 * @author novo
 * @since 2021/10/7
 */
public class Node {
  public int val;
  public Node prev;
  public Node next;

  public Node(int val) {
    this.val = val;
  }
}