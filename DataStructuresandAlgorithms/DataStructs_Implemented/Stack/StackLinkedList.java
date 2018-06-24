//Stack with linked list based implementation
class Node{
	int data;
	Node next;

	public Node(int data){
		this.data = data;
	}

}

class StackLinkedList{
	Node top;

	public void initializeStack(){
		top = null;
	}

	public void push(int data){
		Node newData = new Node(data);
		newData.next = top;
		top = newData;
	}

	public void pop(){
		top = top.next;
	}

	public void deleteStack(){
		top = null;
	}

	public int stackSize(){
		Node current = top;
		int size = 0;
		while(current!= null){
			size ++;
			current = current.next;
		}
		return size;
	}

	public void traverse(){
		Node current = top;
		while(current != null){
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println("");
	}

	public static void main(String[] args){
		StackLinkedList myList = new StackLinkedList();
		myList.initializeStack();
		myList.push(1);
		myList.push(2);
		myList.deleteStack();
		myList.push(3);
		myList.push(4);
		myList.push(5);
		myList.pop();
		myList.traverse();
		System.out.println("The size of the stack is " + myList.stackSize());
	}
}