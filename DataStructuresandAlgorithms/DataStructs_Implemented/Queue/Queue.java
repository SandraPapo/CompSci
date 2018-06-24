//Circular Array based implementation of a queue
class Queue {

	int size;
	int front;
	int rear;
	int maxQueue ;
	int[] elements;

	public void initiateQueue(){
		front = 0;
		rear = -1;
		size = 0;

		maxQueue = 100;
		elements = new int[maxQueue];

	}

	public void enqueue(int data){
		rear = (rear + 1)% maxQueue;
		elements[rear] = data;
		size++;
	}

	public boolean isFullQueue(){
		return size == maxQueue;
	}

	public boolean isEmptyQueue(){
		return size == 0;
	}

	public int queueSize(){
		return size;
	}

	public void dequeue(){
		front = (front + 1) % maxQueue;
		size--;
	}

	public void deleteQueue(){
		front = 0;
		rear = -1;
		size = 0;
	}

	public void traverse(){
		int count = 1;
		int index = front;
		while(count <= size){
			System.out.print(elements[index]+ " ");
			index = (index + 1)%maxQueue;
			count++;
		}
		System.out.println("");
	}

	public static void main(String[] args){
		Queue myQueue = new Queue();
		myQueue.initiateQueue();
		myQueue.enqueue(1);
		myQueue.enqueue(2);
		myQueue.enqueue(3);
		myQueue.enqueue(4);
		myQueue.traverse();
		myQueue.dequeue();
		myQueue.traverse();
		System.out.println(myQueue.queueSize());
				myQueue.enqueue(4);
	}
}