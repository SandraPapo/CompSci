import java.util.Stack;


class BTreeNode {
	int data;
	BTreeNode left;
	BTreeNode right;
	public BTreeNode(int data) {
		this.data = data;
	}
}


public class BinaryTree {

	private BTreeNode root;
	private int size;
	private int depth;

	public BinaryTree() {
		root = null;
		size = 0;
		depth = 0;
	}
// Inserting an element into a tree
	public void insert(int data) {
		BTreeNode newNode = new BTreeNode(data);
		if(root == null) {
			root = newNode;
			root.right = null;
			root.left = null;
			depth ++;
		}
		else
			insertNode(newNode, root, 1);
	}

	public void insertNode(BTreeNode node, BTreeNode current, int level) {
		if (node.data < current.data) {
			if(current.left == null){
				current.left = node;
				if(level > depth)
					depth = ++level;
			}
			else
				insertNode(node, current.left, level+1);

		}
		else {
			if(current.right == null){
				current.right = node;
			}
			else
				insertNode(node, current.right, level+1);
				if(level > depth)
					depth = level;
		}
	}


	public BTreeNode search(int data) {
		return searchRecursive(root, data);
	}

	public BTreeNode searchRecursive(BTreeNode current, int data){
		if (current == null) 
			return null;
		if (current.data == data)
			return current;
		else if (data < current.data)
			return searchRecursive(current.left, data);
		else
			return searchRecursive(current.right, data);
	}
	

	public BTreeNode searchRecursive(BTreeNode current, BTreeNode findParent){
		if (current == null) 
			return null;
		if (current.left == findParent || current.right == findParent)
			return current;
		else if (findParent.data < current.data)
			return searchRecursive(current.left, findParent);
		else
			return searchRecursive(current.right, findParent);
	}

	public BTreeNode findParent(BTreeNode child){
		return searchRecursive(root, child);
	}

	public void delete(BTreeNode nodeToDelete) {
		if (nodeToDelete.left == null && nodeToDelete.right == null) {
			deleteLeaf(nodeToDelete);
		}
		else if(nodeToDelete.left != null && nodeToDelete.right == null) {
			deleteWithLeft(nodeToDelete);
		}
		else if (nodeToDelete.left == null && nodeToDelete.right != null) {
			deleteWithRight(nodeToDelete);
		}
		else if (nodeToDelete.left != null && nodeToDelete.right != null) {
			deleteWithBoth(nodeToDelete);
		}

	}

	public void deleteLeaf(BTreeNode nodeToDelete) {
		BTreeNode parent = findParent(nodeToDelete);
		if (parent.left == nodeToDelete)
			parent.left = null;
		else
			parent.right = null;

	}

	public void deleteWithLeft(BTreeNode nodeToDelete) {
		BTreeNode parent = findParent(nodeToDelete);
		if (parent.left == nodeToDelete){
			parent.left = nodeToDelete.left;
		}
		else{
			parent.right = nodeToDelete.left;
		}
	}

	public void deleteWithRight(BTreeNode nodeToDelete) {
		BTreeNode parent = findParent(nodeToDelete);
		if (parent.left == nodeToDelete){
			parent.left = nodeToDelete.right;
		}
		else{
			parent.right = nodeToDelete.right;
		}
	}

	public void deleteWithBoth(BTreeNode nodeToDelete) {
		BTreeNode parent = findParent(nodeToDelete);
		BTreeNode maxNode = findMaxLeftSubtree(nodeToDelete.left);
		nodeToDelete.data = maxNode.data;
		delete(maxNode);
		System.out.println(maxNode.data);

		
	}

	public BTreeNode findMaxLeftSubtree(BTreeNode current){
		if (current.right == null) {
			return current;
		}
		else {
			return findMaxLeftSubtree(current.right);
		}
	}

	public boolean isTreeEmpty() {
		return (root == null); // check this
	}
	
	public int treeSize() {
		return size; // check this
	}

	public boolean isTreeFull() {
		return false; // check this
	}	

	public void inOrderRecursive(BTreeNode root) {
		if(root != null){
			inOrderRecursive(root.left);
			System.out.print(root.data + " ");
			inOrderRecursive(root.right);
		}
	}
	public void preOrderRecursive(BTreeNode root) {
		if(root != null){
			System.out.print(root.data + " ");
			preOrderRecursive(root.left);
			preOrderRecursive(root.right);
		}
	}
	public void postOrderRecursive(BTreeNode root) {
		if(root != null){
			postOrderRecursive(root.left);
			postOrderRecursive(root.right);
			System.out.print(root.data + " ");
		}
	}

	public void inOrder() {
		inOrderRecursive(root);
		System.out.println();
		preOrderRecursive(root);
		System.out.println();
		postOrderRecursive(root);
		System.out.println("\n"+depth);
	}

	public void printByLevel() {

		for (int i = 1; i <= depth ;i++) {
			levelRecursive(root, i);
			System.out.println();
		}
	}

	public void levelRecursive(BTreeNode current, int level) {

		if (level == 1) {
			if(current != null)
				System.out.print(current.data + " ");
		}
		if (level > 1) {
			levelRecursive(current.left, level - 1);
			levelRecursive(current.right, level - 1);
		}

	}

	public void inOrderNonRecursive() {
		Stack<BTreeNode> stack = new Stack<BTreeNode>();
		BTreeNode current = root;

		while(true) {

			while(current != null) {
				stack.push(current);
				current = current.left;
			}
			if(stack.empty())
				break;
			current = stack.pop();
			System.out.print(current.data + " ");
			current = current.right;				

		}
	}

	//public void deleteLeaf

	public static void main(String[] args) {

		BinaryTree myTree = new BinaryTree();
		myTree.insert(6);
		myTree.insert(2);
		myTree.insert(8);
		myTree.insert(1);
		myTree.insert(4);
		myTree.insert(7);
		myTree.insert(9);
		myTree.printByLevel();
		myTree.delete(myTree.search(6));
		myTree.printByLevel();

		//myTree.inOrder();
		//System.out.println(myTree.search(7));

	}
}