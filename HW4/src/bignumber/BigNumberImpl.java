package bignumber;

/**
 * we will go from rear to head
 * like 32411, we will store like 1 -> 1 -> 4 -> 2 -> 3
 *
 * @author novo
 * @since 2021/10/7
 */
public class BigNumberImpl implements BigNumber {

  public Node head;

  /**
   * default
   */
  public BigNumberImpl() {
    head = new Node(0);
  }

  /**
   * convert a number to bignumber.BigNumber
   *
   * @param number origin number
   */
  public BigNumberImpl(String number) throws IllegalArgumentException {
    head = new Node(0);
    int n = number.length();
    // add every digit
    // will not have carry
    for (int i = 0; i < n; i++) {
      shiftLeft(1);
      if (number.charAt(i) < '0' || number.charAt(i) > '9') {
        throw new IllegalArgumentException("argument is not a valid number");
      }
      int curr = number.charAt(i) - '0';
      addDigit(curr);
    }
  }

  @Override
  public int length() {
    int count = 0;
    // traverse from head
    Node temp = head;
    while (temp != null) {
      count++;
      temp = temp.next;
    }
    return count;
  }

  @Override
  public void shiftLeft(int number) {
    // multiply by 10
    // 321 3210
    // 123 -> 1230
    if (number < 0) {
      // negative, using shift right
      shiftRight(-number);
      return;
    }
    if (head.val == 0 && head.next == null) {
      return;
    }
    // move 'times' times
    while (number-- != 0) {
      Node newHead = new Node(0);
      newHead.next = head;
      head = newHead;
      head.next.prev = head;
    }
  }

  @Override
  public void shiftRight(int number) {
    // almost same as shiftRight
    if (number < 0) {
      shiftLeft(-number);
      return;
    }


    for (int i = 0; i < number; i++) {
      if(head.next == null){
        head.val = 0;
        return ;
      }
      head = head.next;
      head.prev = null;
    }

  }

  @Override
  public void addDigit(int number) throws IllegalArgumentException {
    if (number < 0 || number > 9) {
      throw new IllegalArgumentException("number should be a single digit");
    }
    // by default, we will not have carry
    boolean carry = false;
    // start from head
    // 1 2 3 4
    // 4 -> 3 -> 2 -> 1
    // 9
    Node temp = head;
    // add current node
    temp.val += number;
    // if value of current node is bigger than 9, that means we've got a carry
    // current value will be the current value % 10
    if (temp.val >= 10) {
      temp.val %= 10;
      carry = true;
    }
    // if we've got a carry, then move to next node and increase next node by 1
    while (carry) {
      if (temp.next == null) {
        temp.next = new Node(0);
        temp.next.prev = temp;
      }
      // 9 9 9 9
      // 9
      temp = temp.next;
      temp.val += 1;
      if (temp.val >= 10) {
        temp.val %= 10;
        carry = true;
      } else {
        carry = false;
      }
    }
  }

  @Override
  public int getDigitAt(int index) throws IllegalArgumentException {
    // start from head
    Node temp = head;
    while (index-- != 0) {

      temp = temp.next;
    }
    return temp.val;
  }

  @Override
  public BigNumber copy() {
    // use a dummyHead to return the head of copy
    Node dummyHead = new Node(-1);
    Node copyTemp = dummyHead;
    Node temp = head;
    // traverse current big number
    while (temp != null) {
      copyTemp.next = new Node(temp.val);
      copyTemp = copyTemp.next;
      temp = temp.next;
    }
    //dummy -> 1 - > 2 -> 3
    // create result
    BigNumber copyNumber = new BigNumberImpl();
    copyNumber.setHead(dummyHead.next);
    // construct prev
    setPrev(dummyHead.next);
    return copyNumber;
  }

  @Override
  public BigNumber add(BigNumber number) {
    // result node
    Node dummyHead = new Node(-1);
    Node resTemp = dummyHead;
    // two temp nodes used to traverse
    Node temp1 = head;
    Node temp2 = number.getHead();

    /**
     *   4321
     *  12345
     *
     *  1 - > 2 -> 3 -> 4
     *  5 - > 4 -> 3 -> 2 -> 9 -> 9
     */
    // next digit has carry or not
    boolean carry = false;
    // start traversing
    while (temp1 != null && temp2 != null) {
      int currSum = temp1.val + temp2.val;
      // check carry
      currSum += carry ? 1 : 0;
      if (currSum >= 10) {
        currSum %= 10;
        carry = true;
      } else {
        // important to reset
        carry = false;
      }
      // create new node
      resTemp.next = new Node(currSum);
      // move three pointers
      resTemp = resTemp.next;
      temp1 = temp1.next;
      temp2 = temp2.next;
    }
    // check we have reached both ends or not
    while (temp1 != null) {
      int nextVal = temp1.val;
      if (carry) {
        nextVal += 1;
      }
      if (nextVal >= 10) {
        nextVal %= 10;
        carry = true;
      } else {
        // important to reset
        carry = false;
      }
      // create new node
      resTemp.next = new Node(nextVal);
      // move two pointers
      resTemp = resTemp.next;
      temp1 = temp1.next;
    }
    while (temp2 != null) {
      int nextVal = temp2.val;
      if (carry) {
        nextVal += 1;
      }
      if (nextVal >= 10) {
        nextVal %= 10;
        carry = true;
      } else {
        // important to reset
        carry = false;
      }
      // create new node
      resTemp.next = new Node(nextVal);
      // move two pointers
      resTemp = resTemp.next;
      temp2 = temp2.next;
    }
    // check if there's still a carry
    if (carry) {
      resTemp.next = new Node(1);
    }
    // create result
    BigNumberImpl result = new BigNumberImpl();
    result.setHead(dummyHead.next);
    // construct prev
    setPrev(dummyHead.next);
    return result;
  }

  private void setPrev(Node head) {
    Node temp = head;
    while (temp.next != null) {
      Node prev = temp;
      temp = temp.next;
      temp.prev = prev;
    }
  }

  @Override
  public Node getHead() {
    return head;
  }

  @Override
  public void setHead(Node head) {
    this.head = head;
  }

  @Override
  public int compareTo(BigNumber number) {
    // firstly, compare length
    int length1 = this.length();
    int length2 = number.length();
    if (length1 < length2) {
      return -1;
    } else if (length1 > length2) {
      return 1;
    }
    // both length are equal
    // both start from rear, so we should move to rear first
    /**
     * 1244
     * 5648
     *
     * 4->4->2->1
     * 8->4->6->5
     */
      Node head1 = getHead();
      Node head2 = number.getHead();
      //move the pointers to rear first.
      while(head1.next != null){
        head1 = head1.next;
        head2 = head2.next;
      }
      while(head1 != null){
        if(head1.val > head2.val){
          return 1;
        }else if(head1.val < head2.val){
          return -1;
        }else{
          head1 = head1.prev;
          head2 = head2.prev;
        }
      }
      return 0;





//    Node i = head;
//    Node j = number.getHead();
//    while (i.next != null && j.next != null) {
//      i = i.next;
//      j = j.next;
//    }
//    // start moving backwards
//    while (i != null && j != null && i.val == j.val) {
//      i = i.prev;
//      j = j.prev;
//    }
//    if (i != null && j != null) {
//      // we've reached a node that two digits are different
//      if (i.val < j.val) {
//        return -1;
//      } else {
//        return 1;
//      }
//    } else if (i != null) {
//      // j is null, that means i have more digits, definitely bigger than j
//      return 1;
//    } else if (j != null) {
//      // reversed as above
//      return -1;
//    } else {
//      // both are null, means they are same
//      return 0;
//    }
  }

  @Override
  public String toString() {
    StringBuilder res = new StringBuilder();
    Node temp = head;

    while (temp != null) {
      res.insert(0, temp.val);
      temp = temp.next;
    }

    return res.toString();
  }
}