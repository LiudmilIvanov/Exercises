package DataStructures;

public class TreeRepresentation {

	public static int leftLeavesSum = 0;
	public static int rootSum = 0;
	public static int sum = 0;

	private static TreeNode root;

	public class TreeNode {
		private int data;
		private TreeNode left;
		private TreeNode right;

		public TreeNode(int data) {
			this.data = data;
		}
	}

	public boolean checkBalance(TreeNode root) {
		int result = isBalanced(root);
		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}

	public int isBalanced(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftH = isBalanced(root.left);
		if (leftH == -1) {
			return -1;
		}
		int rightH = isBalanced(root.right);
		if (rightH == -1) {
			return -1;
		}
		int difference = leftH - rightH;
		if (Math.abs(difference) > 1) {
			return -1;
		}
		return 1 + Math.max(leftH, rightH);
	}

	public static TreeNode deleteTree(TreeNode root) {
		if (root != null) {
			deleteTree(root.left);
			deleteTree(root.right);
			System.out.println("Nodes deleted " + root.data);
			root = null;
			return root;
		}
		return null;
	}

	public boolean isRoot(int value) {
		TreeNode current = root;
		while (current.left != null || current.right != null) {
			if (current.data == value) {
				return true;
			} else if (current.data > value) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		return false;
	}

	public static void leafSum(TreeNode root) {
		if (root == null) {
			return;

		}
		if (root.left == null && root.right == null) {
			sum += root.data;
		}
		leafSum(root.left);
		leafSum(root.right);
	}

	public static void countRoots(TreeNode root) {
		if (root == null) {
			return;

		}
		if (root.left != null || root.right != null) {
			rootSum += root.data;
		}
		countRoots(root.left);
		countRoots(root.right);
	}

	public int countOcc(int value, TreeNode root) {
		if (root == null) {
			return 0;
		} else if (root.data == value) {
			return 1 + countOcc(value, root.left) + countOcc(value, root.right);
		}
		return countOcc(value, root.left) + countOcc(value, root.right);
	}

	public int countNodes(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + countNodes(root.left) + countNodes(root.right);
	}

	public static void leftSum(TreeNode root, TreeNode parent) {
		if (root != null) {
			leftSum(root.left, root);
			if (root.left == null && root.right == null && parent.left == null) {
				leftLeavesSum += root.data;
			}
			leftSum(root.right, root);
		}

	}

	public boolean contains(int value) {
		TreeNode current = root;
		while (current != null) {
			if (current.data == value) {
				return true;
			} else if (current.data > value) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		return false;
	}

	public void insert(int value) {
		TreeNode newNode = new TreeNode(value);
		if (root == null) {
			root = newNode;
			return;
		}
		TreeNode current = root;
		TreeNode parent = null;
		while (true) {
			parent = current;
			if (value < current.data) {
				current = current.left;
				if (current == null) {
					parent.left = newNode;
					return;
				}
			} else {
				current = current.right;
				if (current == null) {
					parent.right = newNode;
					return;
				}
			}
		}

	}

	public void inOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		inOrder(root.left);
		System.out.println(" " + root.data);
		inOrder(root.right);
	}

	public static void main(String[] args) {
		TreeRepresentation tree = new TreeRepresentation();
		tree.insert(10);
		tree.insert(5);

		tree.inOrder(tree.root);
		System.out.println(tree.countNodes(root));
		System.out.println(tree.contains(7));
		tree.leftSum(root, root);
		System.out.println("Sum of the left leaves " + leftLeavesSum);
		System.out.println(tree.countOcc(10, root));
		System.out.println(tree.isRoot(12));
		tree.countRoots(root);
		leafSum(root);
		countRoots(root);
		System.out.println(rootSum);
		System.out.println(tree.checkBalance(root));
	}
}
