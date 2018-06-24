class Person {
	private String name;
	private String friends;
	private int friendCount;

	public Person(String name){
		this.name = name;
		friends = "";
		friendCount = 0;
	}

	public void befriend(Person newFriend){
		friends += newFriend.getName() + " ";
		friendCount ++;
	}

	public void unfriend(Person oldFriend){
		friends = friends.replaceFirst(oldFriend.getName() + " " , "");
		friendCount --;
	}

	public String getName(){
		return name;
	}

	public String getFriendNames(){
		return friends;
	}
	public int getFriendCount(){
		return friendCount;
	}
}

public class Activity2{
	public static void main(String[] args) {
		Person sandra = new Person("Sandra");
		Person rosario = new Person("Rosario");
		Person leah = new Person("Leah");
		Person jurko = new Person("Jurko");

		sandra.befriend(rosario);
		sandra.befriend(leah);
		sandra.befriend(jurko);
		sandra.unfriend(rosario);
		System.out.println(sandra.getFriendNames());
		System.out.println(sandra.getFriendCount());
	}
}