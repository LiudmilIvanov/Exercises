package Exercise;

import java.util.NoSuchElementException;

public class DoublyLinkedList {

	private static ListNode head;
	private static ListNode tail;
	static int lenght;

	private static class ListNode {

		private int data;
		private ListNode next;
		private ListNode previous;

		public ListNode(int data) {
			this.data = data;
		}
	}	

	public DoublyLinkedList() {
		this.head = null;
		this.tail = null;
		this.lenght = 0;
	}

	// checks if the list is empty and returns true/false
	public static boolean isEmpty() {
		return lenght == 0;
	}

	public int lenght() {
		return lenght;
	}

	public ListNode removeLastNode() {
		ListNode temp = tail;
		if (lenght == 0) {
			throw new NoSuchElementException();
		}
		if (head == tail) {
			head = null;
		}
		tail.previous.next = null;
		tail.previous = tail;
		temp.previous = null;
		return temp;
	}

	// inserts element at beginning
	public void insertNewNode(int value) {
		ListNode newNode = new ListNode(value);
		if (isEmpty()) {
			tail = newNode;
		} else {
			head.previous = newNode;
		}
		newNode.next = head;
		head = newNode;
		lenght++;
	}

	public ListNode insertAtIndex(ListNode head, int data, int position) {
		ListNode newNode = new ListNode(data);
		ListNode temp = head;
		int count = 1;
		if (position == 1) {
			newNode.next = head;
			return newNode;
		} else {
			while (count < position - 1) {
				temp = temp.next;
				count++;
			}
			ListNode current = temp.next;
			newNode.next = current;
			temp.next = newNode;
			return head;
		}
	}

	// prints the linked list
	public void printNode() {
		ListNode temp = head;
		while (temp != null) {
			System.out.println(temp.data + "-->");
			temp = temp.next;
		}
	}

	// remove the first node
	public ListNode removeFrist() {
		ListNode temp = head;
		if (lenght == 0) {
			throw new NoSuchElementException();
		}
		if (head == tail) {
			tail = null;
		}
		head.next.previous = null;
		head = head.next;
		temp.next = null;
		lenght--;
		return temp;
	}

	public boolean searchForElement(int key) {
		ListNode current = head;
		while (current != null) {
			if (current.data == key) {
				System.out.println("Found");
				return true;
			}
			current = current.next;
		}
		System.out.println("Not found");
		return false;
	}

	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		list.insertNewNode(10);
		list.insertNewNode(15);
		list.insertNewNode(30);
		list.printNode();
		System.out.println();
		list.removeLastNode();
		list.printNode();
		System.out.println();
		list.insertAtIndex(head, 13, 2);
		list.insertAtIndex(head, 14, 2);
		list.printNode();
	}

}
