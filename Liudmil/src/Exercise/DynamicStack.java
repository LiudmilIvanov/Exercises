package Exercise;

public class DynamicStack {
	int size;
	int[] stack = new int[size];
	int count = 0;

	public DynamicStack(int size) {
		this.size = size;
		this.stack = new int[size];
	}

	private void expand() {
		int lenght = size;
		int newStack[] = new int[size * 2];
		for (int i = 0; i < stack.length; i++) {
			newStack[i] = stack[i];
			size = size * 2;
		}
		stack = newStack;
	}

	public int size() {
		return size;
	}

	public void push(int data) {

		if (stack.length == count) {
			expand();
		}

		stack[count] = data;
		count++;
	}

	public int pop() {
		int data;
		count--;
		data = stack[count];
		stack[count] = 0;
		return data;
	}

	public void print() {
		for (int i = 0; i < count; i++) {
			System.out.println(stack[i]);
		}
	}

	public static void main(String[] args) {

	}
}
