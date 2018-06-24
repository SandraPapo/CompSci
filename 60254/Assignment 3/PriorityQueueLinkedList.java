/*
Implement the Priority Queue as an ADT using two different underlying representations:
1. Static array that stores the elements in priority order
2. Linked list that stores the elements in priority order


Your Priority Queue ADT should provide the following interfaces (functions)
1. enqueue(element, priority, queue): add an element into the queue at the
appropriate position in the queue based on the associated priority. If the priority
parameter is missing, assign to the element 5 as default priority, which is the
lowest priority.
2. deque(queue): remove the element with the highest priority from the queue. If
two elements have the same priority, they are served according to their order in
the queue.
3. peek(queue):​ return the element to be served from the queue without removing it
4. IsRegular(queue): return true if all the current elements in the queue have the
same priority.
5. size(queue):​ returns the total number of elements in the queue.
6. isEmpty(queue):​ returns true if the queue is empty.
7. isFull(queue):​ returns true if the queue is full.
8. display(queue):​ prints all the elements in the queue with their priority.
*/


//Circular Array based implementation of a queue

class Item{
	int data;
	int priority;
	Item next;
	public Item(int data, int priority){
		this.data = data;
		this.priority = priority;

	}
	public Item(int data){
		this.data = data;
		priority = 5;
	}
}

class Queue {

	int size;
	Item head;

	public Queue(){
		size = 0;
	}

	public void enqueue(int data, int itemPriority){

		if(itemPriority > 5 ){
			System.out.println("Invalid priority, only put priority <= 5");
			return;
		}
		Item element = new Item(data, itemPriority);


		if(head == null || head.priority > element.priority){
			element.next = head;
			head = element;
			size++;
		}
		else{
			Item current = head;
			while(current.next != null){
				if(current.next.priority > element.priority){
					break;
				}
				current = current.next;
			}

			Item temp = current.next;
			current.next = element;
			element.next = temp;
			size++;
		}
		

	}

	public void enqueue(int data){
		Item element = new Item(data);
			element.next = head;
			head = element;
			size++;

	}

	public void dequeue(){
		head = head.next;
		size--;
	}

	public Item peek(){
		System.out.println( "("+head.data + ", " + head.priority + ") ");
		return head;
	}

	public boolean isRegular(){
		Item current = head;
		int elementPriority = current.priority;
		while(current.next != null) {
			if (elementPriority != current.priority)
				return false;
			else
				current = current.next;
		}
		return true;
	}

	public int size(){
		return size;
	}

	public boolean isEmptyQueue(){
		return size == 0;
	}

	public boolean isFullQueue(){
		return false;
	}

	public void display(){
		Item current = head;
		while(current != null){
			System.out.println("("+current.data + ", " + current.priority + ") ");
			current = current.next;
		}



	}


}

public class PriorityQueueLinkedList{
	public static void main(String[] args){
		Queue myQueue = new Queue();
		myQueue.enqueue(2,1);
		myQueue.enqueue(1,1);
		myQueue.enqueue(3,1);
		myQueue.enqueue(4,1);
		myQueue.enqueue(5);

		myQueue.display();
		myQueue.dequeue();
		System.out.println(myQueue.size());
		myQueue.peek();

		System.out.println(myQueue.isRegular());

		
	} 






	
}