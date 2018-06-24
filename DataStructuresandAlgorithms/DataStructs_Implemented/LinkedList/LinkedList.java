class Node {
	Node next;
	int data;
	
	public Node(int data){
		this.data = data;
	}
}

class LinkedList{
	Node head;

	

	//Traverse
	public void traverse(){
		Node current = head;
		while(current!= null){
			System.out.println(current.data + " ");
			current = current.next;
		}
	}

	//Insert

	public void insertFirst(int data){
		Node newHead = new Node(data);
		newHead.next = head;
		head = newHead;
	}

	public void insertLast(int data){
		if(head == null){
			head = new Node(data);
			return;
		}
		Node current = head;
		while(current.next != null){
			current.next = current.next.next;
		}
		current.next = new Node(data);
	}


	public void insertMiddle(int data, int index){
		Node newNode = new Node(data);
		Node current = head;
		int counter = 0;
		
		while(current.next != null && counter < index-1){
			counter++;
			current.next = current.next.next;
		}

		if(index == 0){
			newNode.next = head;
			head = newNode;
			return;
		}

		Node temp = current.next;
		current.next = newNode;
		newNode.next = temp;
	}

	//Delete
	public void deleteFirst(){
		head = head.next;
	}

	public void deleteLast(){
		Node current = head;
		while(current.next.next != null)
			current = current.next;
		current.next = null;
	}
	//Search
	//Sort
	//Merge

	public void reverse(){
		Node current = head;
		LinkedList reversed = new LinkedList();
		while(current != null){
			reversed.insertFirst(current.data);
			current = current.next;
		}
		head = reversed.head;
	}

	public static void main(String[] args){
		LinkedList myList = new LinkedList();
		myList.insertFirst(1);
		myList.insertLast(4);
		myList.insertMiddle(3,1);
		myList.insertMiddle(2,1);
		myList.traverse();
		myList.reverse();
		myList.traverse();
	}

}
































