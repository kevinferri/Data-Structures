package prep;

public class SList {
  
  private SListNode head;
  private int size;
  
  public SList() {
    size = 0;
    head = null;
  }
  
  
  public boolean isEmpty() {
    return size == 0;
  }
  
  public int length() {
    return size;
  }
  
  public void insertFront(int data) {
    head = new SListNode(data, head);
    size++;
  }
  
  
  public void insertEnd(int item) {
    if (head == null) {
      head = new SListNode(item);
    } else {
      SListNode node = head;
      while (node.next != null) {
        node = node.next;
      }
      node.next = new SListNode(item);
    }
    size++;
  }
  
  public boolean deleteNode(SListNode n) {
    if (n == null || n.next == null) {
      return false;
    }
    
    n.item = n.next.item;
    n.next = n.next.next;
    
    size--;
    
    return true;
  }
  
  public Object nth(int position) {
    SListNode currentNode;
    
    if ((position < 1) || (head == null)) {
      return null;
    } else {
      currentNode = head;
      while (position > 1) {
        currentNode = currentNode.next;
        if (currentNode == null) {
          return null;
        }
        position--;
      }
      return currentNode.item;
    }
  }
  
  public static SListNode partitionList(SListNode node, int pivot) {
    
    SListNode lessThan = null;
    SListNode greaterThan = null;
    
    while (node != null) {
      SListNode next = node.next;
      if (node.data < pivot) {
        node.next = lessThan;
        lessThan = node;
      } else {
        node.next = greaterThan;
        greaterThan = node;
      }
      node = next;
    }
    
    SListNode head = lessThan;
    
    while (lessThan.next != null) {
      lessThan = lessThan.next;
    }
    
    lessThan.next = greaterThan;
    
    return head;
  }
  
  public static SListNode FindBeginning(SListNode head) {
    SListNode slow = head;
    SListNode fast = head;
    
    // Find meeting point
    while (fast != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) { // Collision!
        break;
      }
    }
    
    // Error check - no meeting point, and therefore no loop
    if (fast == null || fast.next == null) {
      return null;
    }
    
    // Move slow to head, keep fast at meeting point. Each are k steps from loop start. If they move at same pace, they must meet at loop start
    slow = head;
    while (slow != fast) {
      slow = slow.next;
      fast = fast.next;
    }
    
    // Both now point to the start of the loop
    return fast;
  }
  
  public static void deleteDups(SListNode head) {
    if (head == null) return;
    
    while (head != null) {
      SListNode runner = head;
      while (runner.next != null) {
        if (runner.next.item.equals(head.item)) {
          runner.next = runner.next.next;
        } else {
          runner = runner.next;
        }
      }
      head = head.next;
    }
  }
  
  public SListNode reverseList(SListNode list) {
    if (list == null) return null;
    if (list.next == null) return list;
    
    // Grab the second element (which will be the last after we reverse it)
    SListNode secondElem = list.next;
    
    // Bug fix - need to unlink list from the rest or you will get a cycle
    list.next = null;
    
    // Then we reverse everything from the second element on
    SListNode reverseRest = reverseList(secondElem);
    
    // Then we join the two lists
    secondElem.next = list;
    
    return reverseRest;
  }
  
  
  public static void main (String[] args) {
    
  }
  
}

class SListNode {
  Object item;
  int data;
  SListNode next;
  
  SListNode(Object item, SListNode next) {
    this.item = item;
    this.next = next;
  }
  
  SListNode(int data) {
    this.item = null;
    this.data = data;
    this.next = null;
  }
  
  SListNode(int data, SListNode next) {
    this.item = null;
    this.data = data;
    this.next = next;
  }
  
  SListNode(Object item) {
    this(item, null);
  }
}
