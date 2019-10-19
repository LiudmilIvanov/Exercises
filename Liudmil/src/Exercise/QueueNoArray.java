package Exercise;

import java.util.NoSuchElementException;

public class QueueNoArray {

	int lenght;
	Node front;
	Node rear;

	public QueueNoArray() {
		this.front = null;
		this.rear = null;
		this.lenght = 0;
	}

	private class Node {

		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public void print() {
		if (isEmpty()) {
			System.out.println("No Elements in the queue");
		}
		Node node = front;
		while (node != null) {
			System.out.println(node.data + "-->");
			node = node.next;
		}
	}

	public boolean isEmpty() {
		return lenght == 0;
	}

	public int deQueue() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		int result = front.data;
		front = front.next;
		if (front == null) {
			rear = null;
		}
		lenght--;
		return result;
	}

	public void enQueue(int data) {
		Node node = new Node(data);
		if (isEmpty()) {
			front = node;
		} else {
			rear.next = node;
		}
		rear = node;
		lenght++;
	}

	public static void main(String[] args) {

	}
}
