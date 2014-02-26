package prep;

public class ListNode {
	int item;
	ListNode next;
	
	public ListNode() {}
	
	public ListNode(int item, ListNode next) {
		this.item = item;
		this.next = next;
	}
	
	public ListNode(int item) {
		this(item, null);
	}
	
	// Inserts a new item after "this"
	public void insertAfter(int item) {
		this.next = new ListNode(item, next); // This right next is the ListNode's old next
	}
	
	public void insertBefore(int item) {
		ListNode current = this;
		ListNode newNode = new ListNode(item, current);
		
		current.next = newNode;
	}
	
	// Returns ListNode of nth position
	public ListNode nth(int position) {
		if (position == 1) {
			return this;
		} else if ((position < 1) || (this.next == null)) {
			return null;
		} else {
			return this.next.nth(position - 1);
		}
	}
	
	// Returns the ListNode that is n positions away from the end of the list
	public ListNode nthAway(int spotsAway) {
		if (spotsAway < 1) return null;
		
		ListNode n1 = this;
		ListNode n2 = this;
		
		for (int i = 0; i < spotsAway - 1; i++) {
			if (n2 == null) return null;
			n2 = n2.next;
		}
		
		while (n2.next != null) {
			n2 = n2.next;
			n1 = n1.next;
		}
		
		return n1;
	}
	
	// Delete a node in an list
	public static boolean deleteNode(ListNode n) {
		if (n == null || n.next == null) {
			return false; // Failure
		}
		
		n.item = n.next.item;
		n.next = n.next.next;
		return true;
	}
	
	
	/* MAIN */
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
		l1.insertBefore(100);
		while (l1 != null) {
			System.out.println(l1.item);
			l1 = l1.next;
		}
	}
	
	public static void deleteDups (ListNode head) {
		if (head == null) return;
		
		while (head != null) {
			ListNode runner = head;
			
			while (runner.next != null) {
				if (runner.next.item == head.item) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			head = head.next;
		}
	}
	
}
