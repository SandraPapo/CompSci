public int compareTo(Object otherPlayer) {
	Player other = (Player) otherPlayer;
	return goalsScored - other.goalsScored;
}