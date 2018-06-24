/*
Sandra Papo
104213584
Assignment4.java

*/

import java.io.*;
import java.util.Stack;
import java.util.Arrays;

//Circular Array based implementation of a queue
class Queue {
	private int size;
	private int front;
	private int rear;
	private int maxQueue ;
	private int[] elements;

	public Queue(){
		front = 0;
		rear = -1;
		size = 0;

		maxQueue = 100;
		elements = new int[maxQueue];

	}

	public void enqueue(int data){
		rear = (rear + 1) % maxQueue;
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

	public int dequeue(){
		int temp = elements[front];
		front = (front + 1) % maxQueue;
		size--;
		return temp;
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
	public void reverseTraverse(){
		int count = 1;
		int index = rear;
			System.out.print(elements[index]);
		while(count < size){
			index = ((index - 1) % maxQueue + maxQueue) % maxQueue;
			System.out.print(", " + elements[index]);			
			count++;

		}
		System.out.println("");
	}

}
class Vertex {
	public Vertex parent;
	public int label;
	public boolean wasVisited;

	public Vertex(int label) {
		this.label = label;
		wasVisited = false;
	}
	public boolean equals(Vertex v){
		return (label == v.label);
	}
}

class Graph {
	private Vertex vertexArray[];
	private int[][] adjacencyMatrix;
	private Queue myQueue; 

	public Graph(int[][] adjacencyMatrix, int ROOMS) {
		vertexArray = new Vertex[ROOMS];
		
		for (int i = 0; i < ROOMS; i++) {
			vertexArray[i] = new Vertex(i);
		}

		this.adjacencyMatrix = adjacencyMatrix;
		myQueue = new Queue();
	}

	public void displayVertex(int v) {
		System.out.print(vertexArray[v].label + " ");
	}

	public void dfs(int start) {
		
		Stack<Integer> myStack =  new Stack<>();

		myStack.push(start);

		int current = start;

		while(myStack.empty() == false) {
			   
			System.out.print(current + " ");
			if(vertexArray[current].wasVisited != true){
				vertexArray[current].wasVisited = true;
				while((current = getAdjUnvisitedVertex(current)) != -1){
					System.out.println(current + " ");
						myStack.push(current);
						vertexArray[current].wasVisited = true;
						System.out.print(current + " ");
					

				}
			}
		}

	}
	/*public void bfs(int start, int end) {
		vertexArray[start].wasVisited = true;
		//displayVertex(start);
		myQueue.enqueue(start);
		int v2;
		

		Queue path = new Queue();


		while(!(myQueue.isEmptyQueue())) {
			int v1 = myQueue.dequeue(); 
			while( (v2 = getAdjUnvisitedVertex(v1)) != -1 ) {
				vertexArray[v2].wasVisited = true;
				//displayVertex(v2);
				myQueue.enqueue(v2);
				vertexArray[v2].parent = vertexArray[v1];
			}
			if(v1 == end) {
				Vertex current = vertexArray[end];
				path.enqueue(current.label);
				while(current.parent != null) {
					current = current.parent;
					path.enqueue(current.label);
				}
				path.reverseTraverse();
				break;
			}
		}

		if(path.isEmptyQueue()){
			System.out.println("No path found");
		}
		for(int i = 0; i < vertexArray.length; i++)
			vertexArray[i].wasVisited = false;

	}*/

	public int getAdjUnvisitedVertex(int v) {
		for(int j = 0; j < vertexArray.length; j++)
			if(adjacencyMatrix[v][j]==1 && vertexArray[j].wasVisited==false)
				return j;
		return -1;
	}


}


public class Assignment4 {
	public static void main(String[] args) throws IOException {

		/*String filePath = "file.txt";

		InputStream inputStream = new FileInputStream(filePath);
		InputStreamReader isr = new InputStreamReader(inputStream);
		BufferedReader br = new BufferedReader(isr);
		
		int ROOMS = Integer.parseInt(br.readLine());
		int initialRoom = Integer.parseInt(br.readLine());
		int finalRoom = Integer.parseInt(br.readLine());

		int[][] maze = new int[ROOMS][ROOMS];

		String[] currentLine = new String[ROOMS];

		for(int i = 0; i < ROOMS; i++){
			currentLine = br.readLine().split(",");
			for(int j = 0; j < ROOMS; j++) {
				maze[i][j] = Integer.parseInt(currentLine[j]);
			}
		}*/
		int[][] maze = {{0, 1, 1, 1, 1},{1, 0, 1, 0, 0},{1, 1, 0, 1, 0},{1, 0, 1, 0, 1},{1, 0, 0, 1, 1}};


		Graph shortestPath = new Graph(maze, 5);
		shortestPath.dfs(1);

		
	}
}

/*
Sample Input:
8
0
6
1,1,0,0,1,1,0,0
1,1,0,0,1,0,0,0
0,0,1,1,0,0,0,1
0,0,1,1,0,1,1,0
1,1,0,0,1,1,0,0
1,0,0,1,1,1,0,0
0,0,0,1,0,0,1,1
0,0,1,0,0,0,1,1
*/