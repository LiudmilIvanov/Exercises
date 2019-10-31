package Exercise;

import java.util.ArrayList;

public class Tree<T> {

	public static class TreeNode<T> {

		private T value;
		private boolean hasParent;
		// contains the children of the node
		private ArrayList<TreeNode<T>> children;

		public TreeNode(T value) {
			if (value == null) {
				throw new IllegalArgumentException("Can not insert null value");
			}
			this.value = value;
			this.children = new ArrayList<TreeNode<T>>();
		}

		public T getValue() {
			return value;
		}

		public void setValue(T value) {
			this.value = value;
		}

		public void addChild(TreeNode<T> child) {
			if (child == null) {
				throw new IllegalArgumentException("Child can not be null");
			}
			if (child.hasParent) {
				throw new IllegalArgumentException("Already has parent");
			}
			child.hasParent = true;
			this.children.add(child);
		}

		// get the child of the node at a given index;
		public TreeNode<T> getChild(int index) {
			return this.children.get(index);
		}

		public int getChildrenCount() {
			return this.children.size();

		}
	}

	private TreeNode<T> root;

	public Tree(T value) {
		if (value == null) {
			throw new IllegalArgumentException("Cannot insert null value");
		}
		this.root = new TreeNode<T>(value);
	}

	public Tree(T value, Tree<T>... children) {
		this(value);
		for (Tree<T> child : children) {
			this.root.addChild(child.root);
		}
	}

	public TreeNode<T> getRoot() {
		return this.root;
	}

	public ArrayList<TreeNode<T>> getChildNodes() {
		if (this.root != null) {
			return this.root.children;
		}
		return new ArrayList<Tree.TreeNode<T>>();
	}

	private void printDFS(TreeNode<T> root, String spaces) {
		if (this.root != null) {
			return;
		}
		System.out.println(spaces + root.getValue());
		TreeNode<T> child = null;
		for (int i = 0; i < root.getChildrenCount(); i++) {
			child = root.getChild(i);
			printDFS(child, spaces + " ");
		}
	}

	public void printDFS() {
		this.printDFS(this.root, new String());
	}

	public static void main(String[] args) {

	}

}
