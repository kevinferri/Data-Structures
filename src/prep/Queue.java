package prep;

import java.util.Arrays;

public class Queue {
  private String[] queueArray;
  private int queueSize;
  private int front, rear, numberOfItems = 0;
  
  Queue(int size) {
    queueSize = size;
    queueArray = new String[size];
    Arrays.fill(queueArray, null);
  }
  
  public void insert(String input) {
    if (numberOfItems + 1 <= queueSize) {
      queueArray[rear] = input;
      rear++;
      numberOfItems++;
      System.out.println("INSERT " + input + " was added to the queue");
    } else {
      System.out.println("Queue is full");
    }
  }
  
  public void remove() {
    if (numberOfItems > 0) {
      System.out.println("REMOVE " + queueArray[front] + " was removed from the queue");
      queueArray[front] = null;
      front++;
      numberOfItems--;
    } else {
      System.out.println("Queue is empty");
    }
  }
  
  public void peek() {
    System.out.println("The first element is " + queueArray[front]);
  }
  
  
  public static void main(String[] args) {
    
  }
}
