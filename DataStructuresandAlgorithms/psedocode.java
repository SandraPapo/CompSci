UserNode {
	int user_id;
	int circle_id;
	LinkedList<Integer> circles_subscribed;

}

StackComponent {
	int user_id;
	String msg;
	
	StackComponent(	int user_id, String msg) {
		this.user_id = user_id;
		this.msg = msg;
	}

}

CircleNode {
	int circle_id;
	LinkedList<UserNode> users_subscribed;
	Stack<StackComponent> recentMessages;
}

Application {

	BinaryTree<UserNode> userTree;
	BinaryTree<CircleNode> circleTree;

	posting(user_id, msg, circle_id) {
		CircleNode foundNode = circleTree.search(circle_id);
		StackComponent new = StackComponent(user_id, msg);
		foundNode.recentMessages.push(new);	
	}

	getMessages(user_id, circle_id) {
		CircleNode foundNode = circleTree.search(circle_id)
		Stack<StackComponent> temp;
		StackComponent current;

		for(i = 0; i < 10; i++) {
			current = foundNode.recentMessages.pop()
			print(current) // will print 10 most recent messages
			temp.push(current)
		}
		for(i = 0; i < 10; i++) {
			current = temp.pop()
			foundNode.recentMessages.push(current);
		}
	}

	joinCircle(user_id, circle_id) {
		UserNode foundNode = userTree.search(user_id);
		foundNode.circles_subscribed.add(circle_id);
		CircleNode foundCircleNode = circleTree.search(circle_id);
		foundCircleNode.users_subscribed.add(foundNode);

	}

	leaveCircle(user_id, circle_id) {
		CircleNode foundCircleNode = circleTree.search(circle_id);
		foundCircleNode.users_subscribed.remove(user_id);
		
		UserNode foundNode = userTree.search(user_id)

		if(circle_id == foundNode.circle_id){//if it is the owner
			foundNode = foundCircleNode.users_subscribed.getFirst();
		}

		foundNode.circles_subscribed.remove(circle_id)

	}
}


