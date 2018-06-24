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
	int front;
	int rear;
	int maxQueue ;
	Item[] elements;

	public Queue(){
		front = 0;
		rear = -1;
		size = 0;

		maxQueue = 5;
		elements = new Item[maxQueue];

	}

	public void enqueue(int data, int itemPriority){
		if(size >= maxQueue ){
			System.out.println("Can't insert, queue is at max capacity");
			return;
		}
		if(itemPriority > 5 ){
			System.out.println("Invalid priority, only put priority <= 5");
			return;
		}

		Item element = new Item(data, itemPriority);
		
		if(rear == -1){
			rear = (rear + 1) % maxQueue;
			elements[rear] = element;
			size++;
		}
		else{
			rear = (rear + 1) % maxQueue;
			int insertIndex = rear;

			for(int i = ((rear - 1)%maxQueue+ maxQueue)%maxQueue; i != ((front - 1)%maxQueue+ maxQueue)%maxQueue; i = ((i-1)%maxQueue+ maxQueue)%maxQueue){
				if(elements[i].priority > element.priority){
					insertIndex = i;
					elements[(i+1)%maxQueue] = elements[i];

				}
			}
			
			elements[insertIndex] = element;
			size++;
		}
	}



	public void enqueue(int data){
		if(size >= maxQueue){
			System.out.println("Can't insert, queue is at max capacity");
			return;
		}

		Item element = new Item(data);

			rear = (rear + 1) % maxQueue;
			elements[rear] = element;
			size++;

	}

	public void dequeue(){
		front = (front + 1) % maxQueue;
		size--;
	}

	public Item peek(){
		System.out.println( elements[front].data + " " + elements[front].priority + " ");
		return elements[front];
	}

	public boolean isRegular(){
		return (elements[front].priority == elements[rear].priority);
	}

	public int size(){
		return size;
	}

	public boolean isEmptyQueue(){
		return size == 0;
	}

	public boolean isFullQueue(){
		return size == maxQueue;
	}

	public void display(){
		int count = 1;
		int index = front;
		System.out.println("the front and end indexes are " + front + " " + rear);
		while(count <= size){
			System.out.print("("+ elements[index].data + " " + elements[index].priority + ") ");
			index = (index + 1)%maxQueue;
			count++;
		}
		System.out.println("");



	}


}

public class PriorityQueueArray{
	public static void main(String[] args){
		Queue myQueue = new Queue();
		myQueue.enqueue(1,1);
		myQueue.enqueue(2,1);
		myQueue.enqueue(3,1);
		myQueue.enqueue(4,1);
		myQueue.isRegular();
		myQueue.peek();
		myQueue.display();
		System.out.println(myQueue.size());
		myQueue.dequeue();
		myQueue.display();
		System.out.println(myQueue.size());


	
	} 


}