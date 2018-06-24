class Node {
	int key;
	Node left;
	Node right;
	int height;
	
	public Node(int key) {
		this.key = key;
	}
}

class AVLTree {
	Node root;
	public void insertNode(Node current, int value) {
		if (value < current.key) {
			if (current.left == null) {
				current.left = new Node(value);
			}
			else {
				insertNode(current.left, value)
			}
		}
		else {
			if (current.right == null) {
				current.right = new Node(value);
			}
			else { 
				insertNode(current.right, value);
			}
		}
		checkBalance(current);
	}

	public void checkBalance(Node current) {
		if (current.left == null && current.right == null) {
			current.height = 0;
		}
		else {
			current.height = Math.max(current.left.height, current.right.height) + 1;
		}
		if (current.left.height - current.right.height > 1) {
			if (current.left.left.height - current.left.right.height > 0) {
				rightRotation(current);
			}
			else {
				leftAndRightRotation(current);
			}
		}
		else if (current.left.height - current.right.height < -1) {
			if (current.right.left.height - current.right.right.height < 0) {
				leftRotation(current);
			}
			else {
				rightAndLeftRotation(current);
			}

		}
	}
}