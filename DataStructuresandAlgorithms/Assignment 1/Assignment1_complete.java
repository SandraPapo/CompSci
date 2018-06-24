import java.util.Scanner;

class Link {
	//Data Items
	public int numLikes;	
	public int numComments;
	public int numCharacters;
	public String accountName;
	public int postDate;
	//next link in list
	public Link next; 

	public Link(int numberOfLikes, int numberOfComments, int numberOfCharacters, String postOwner, int datePosted) { // constructor
		//constructor initializing data
		numLikes = numberOfLikes;
		numComments = numberOfComments;
		numCharacters = numberOfCharacters;
		accountName = postOwner;
		postDate = datePosted;
	} 
	public void displayLink(){ 
		//function displayss all data items in the class
		System.out.println("");
		System.out.println("Post date: " + postDate);		
		System.out.println("Number of likes: " + numLikes);
		System.out.println("Number of comments: " + numComments);
		System.out.println("Number of Characters: "+ numCharacters);
		System.out.println("Account name: " + accountName );
	}
} 
class LinkList {
	private Link first;  // reference to first item linklist 
	private int storedPosts; //keeps track of items stored in linklist

	public LinkList() {
		//constructor initializes data
		first = null;
		storedPosts = 0;
	}
	
	public void displayList(){
		//function displays full list of all stored posts
		System.out.println("All Stored Posts: ");
		Link current = first; 
		while(current != null){ 
			current.displayLink(); 
			current = current.next; 
		}
		System.out.println("");
	}

	public Link find(String key){ 
		//function finds first post based of the given account name
		Link current = first; 
		while(!current.accountName.equals(key)) { 
			if(current.next == null) 
				return null; 
			else 
				current = current.next; 
		}
	return current;
	}

	public int numStoredPosts(){
		return storedPosts;		// gives the value of stored posts
	}

	public void insertFirst(int numberOfLikes, int numberOfComments, int numberOfCharacters, String postOwner, int datePosted) { 
		//funcion inserts a link into the beginning of the linked list
		Link newLink = new Link(numberOfLikes, numberOfComments, numberOfCharacters, postOwner, datePosted);
		newLink.next = first;
		first = newLink;
		storedPosts++;		//increment stored post
	}


	public Link delete(int key){ 
		//function deletes post based off post date
		Link current = first; 
		Link previous = first;
		while(current.postDate != key){
			if(current.next == null)
				return null; 
			else {
				previous = current; 
				current = current.next;
			}
		} 
		if(current == first) 
			first = first.next; 
		else 
			previous.next = current.next;
		storedPosts--;
		return current;
	}

	public void deleteAll(){ 
		//function deletes all posts
		first = null; 
		storedPosts = 0;
	}

	private Link findMinDateNode(){ 
		//function finds item with minimum date stored in the linkedlist
		Link current = first; 
		Link min = first; 
		while(current != null){ 
			if(current.postDate < min.postDate) 
				min = current ; 
			current = current.next;
		} 
		return min;
	} 
	
	public LinkList sortByDate(){ 
		//function temporarily creates a new sorted linked list and equates the original to the new sorted one
		LinkList sorted = new LinkList();
		while (first != null){
			Link minLink = findMinDateNode();
			sorted.insertFirst(minLink.numLikes, minLink.numComments, minLink.numCharacters, minLink.accountName, minLink.postDate);
			delete(minLink.postDate);
		}
		first = sorted.first;
		return sorted;
	} 
} 

class Assignment1_complete {

	public static int checkInput(Scanner temp){
		//function gets input from user checks if there is an when making the input an integer 
		try {
			int test = Integer.parseInt(temp.nextLine());
			return test;
    	}catch(Exception e){
    		System.out.println("Invalid Entry, Try again.");
    		return checkInput(temp);
    	}
	}

	public static void main(String[] args) {
		//all the facebook posts are initialized as a linked list object
		LinkList allPosts = new LinkList(); 
		//creates a scanner object
	    Scanner userInput = new Scanner(System.in);
		while(true){
			//loop outlines the interface structure
			System.out.println("Select one of the following options: \n(1) Display the stored posts \n(2) Display the first post with a given author (e.g John)\n(3) Display the current total number of stored posts\n(4) Store the data of a new post\n(5) Delete a post by date\n(6) Delete all stored posts\n(7) Sort the post based on date\n(8) Exit ");
	    	int optionSelected = checkInput(userInput);
	    	int likes, comments, characters, date;
	    	String name;
			//chooses what to execute based off user input
			switch(optionSelected) {
			   	case 1 :
			   		// Displays all the stored posts
			   		System.out.println("Press Enter to Continue...");
			      	userInput.nextLine();
			     	break;
			  	case 2 :
			  		//Displays the first post with a given author
			  		System.out.println("Enter Account Name to search by");
			  		String accountName = userInput.nextLine();
			  		Link current = allPosts.find(accountName);
			    	System.out.print("\nFOUND POST:" );
					current.displayLink();
					System.out.println("Press Enter to Continue...");	
					userInput.nextLine();
			   		break; 
			   	case 3 :
			   		//Displays the current total number of stored posts
			    	System.out.println("the number of stored posts is " + allPosts.numStoredPosts());
					System.out.println("Press Enter to Continue");					
					userInput.nextLine();     
			     	break; 
			   	case 4 :
			   		//Stores data for a new post provided by the user
			  		System.out.println("Enter the following data to make a new post:");
			  		System.out.print("Enter the number of likes: ");
					likes = checkInput(userInput);
			  		System.out.print("Enter the number of comments: ");
					comments = checkInput(userInput);		  		
			  		System.out.print("Enter the number of characters: ");
					characters = checkInput(userInput);				
					System.out.print("Enter the name of the post owner: ");
					name = userInput.nextLine();				
					System.out.print("Enter the date posted as a number (ex. 20170922): ");
					date = checkInput(userInput);
					allPosts.insertFirst(likes, comments, characters, name, date);
					System.out.println("The post was successfully added! Press Enter to Continue...");
					userInput.nextLine(); 
			    	break; 
			   	case 5 :
			   		//Deletes a post based off date(only deletes first instance it catches)
					System.out.println("Enter post date you want to delete");
			   		date = checkInput(userInput);
			   		if(allPosts.delete(date) == null){
			   			System.out.println("Could not find element with date! Press Enter to Continue... " + date );	
			   		}
			   		else{
			   			System.out.println("Successfully Deleted Element with " + date + " as date! Press Enter to Continue...");	
			   		}
					userInput.nextLine();		    	
			    	break; 
			   	case 6 :
			   		//Deletes all stored posts
			    	allPosts.deleteAll();
					System.out.println("Successfully Deleted All Elements! Press Enter to Continue...");
			      	userInput.nextLine();		    	
			    	break; 
			   	case 7 :
			   		//Sorts all the posts based on date
			    	allPosts.sortByDate(); 
					System.out.println("Successfully Sorted by Date! Press Enter to Continue...");	
			      	userInput.nextLine();		   	   	
			   	   	break; 
			   	case 8 :
			   		//Terminates the program
					System.out.println("Goodbye!");		   	
			    	return;
			   default : 
					System.out.println("Invalid Entry, Try again.");	
			   		break;
			}
		}
	} 
}
