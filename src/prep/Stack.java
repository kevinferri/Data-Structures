package prep;

import java.util.Arrays;

public class Stack {
	private int[] stackArray;
	private int stackSize;
	private int topOfStack = - 1; // Symbolizes empty
	
	Stack(int size) {
		stackSize = size;
		stackArray = new int[size];
	}
	
	public void push(int input) {
		if (topOfStack + 1 < stackSize) { // Make sure there is room
			topOfStack++;
			stackArray[topOfStack] = input;
		} else {
			System.out.println("The stack is full, can't push");
		}
		System.out.println("PUSH " + input + " was added to the stack");
	}
	
	public int pop() {
		if (topOfStack >= 0) {
			System.out.println("POP " + stackArray[topOfStack] + " was removed from the stack");
			stackArray[topOfStack] = -1;
			return stackArray[topOfStack--];
		} else {
			System.out.println("The stack is empty");
			return -1;
		}
	}
	
	public int peek() {
		System.out.println("PEEK " + stackArray[topOfStack] + " is at the top of the stack");
		return stackArray[topOfStack];
	}
	
	/*public void pushMany(int multipleValues) {
		int[] temp = multipleValues.split(" ");
		
		for (int i = 0; i < temp.length; i++) {
			push(temp[i]);
		}
	}*/
	
	public void popAll() {
		for (int i = topOfStack; i >= 0; i--) {
			pop();
		}
	}
	
	public static void main(String[] args) {
		Stack s = new Stack(10);
		s.push(6);
		s.push(4);
		s.push(1);
		s.push(7);
		s.push(10);
	}
}