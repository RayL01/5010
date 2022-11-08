package bignumber;

/**
 * @author novo
 * @since 2021/10/7
 */
public interface BigNumber extends Comparable<BigNumber> {
  int length();

  void shiftLeft(int times);

  void shiftRight(int times);

  void addDigit(int number) throws IllegalArgumentException;

  int getDigitAt(int index) throws IllegalArgumentException;

  BigNumber copy();

  BigNumber add(BigNumber number);

  Node getHead();

  void setHead(Node head);

  @Override
  int compareTo(BigNumber number);
}