package Exercise;

public class SortedLinkedList {

	static Node head;
	int lenght;

	private class Node {

		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}

	}

	public boolean isEmpty() {
		return lenght == 0;
	}

	public SortedLinkedList() {
		this.head = null;
		this.lenght = 0;
	}

	public void sortList() {

		Node temp = head;
		while (temp != null) {

			Node second = temp.next;
			while (second != null) {

				if (temp.data > second.data) {
					int tmp = temp.data;
					temp.data = second.data;
					second.data = tmp;
				}
				second = second.next;
			}
			temp = temp.next;
		}

	}

	public void push(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
		lenght++;
	}

	public void print() {

		Node temp = head;
		while (temp != null) {
			System.out.println(temp.data + "-->");
			temp = temp.next;
		}
	}

	public static void main(String[] args) {

		SortedLinkedList listNode = new SortedLinkedList();
		listNode.push(15);
		listNode.push(22);
		listNode.push(33);
		listNode.push(8);
		listNode.push(166);
		listNode.sortList();
		System.out.println(listNode.isEmpty());
		System.out.println(listNode.lenght);
		listNode.print();
	}

}
