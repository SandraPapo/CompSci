public class ComboLock {
	private int secret1;
	private int secret2;
	private int secret3;
	private int dial;
	private boolean valid;
	private int state;

	public ComboLock(int secret1, int secret2, int secret3) {
		this.secret1 = secret1;
		this.secret2 = secret2;
		this.secret3 = secret3;
		dial = 0;
		valid = true;
		state = 0;
	}

	public void reset() {
		dial = 0;
		valid = true;
		state = 0;
	}

	public void turnLeft(int ticks) {
		dial = ((dial - ticks) + 40) % 40;
		if (state == 1 && dial == secret2) {
			unLocked2 == true;
			state++;
		}
		else {
			valid = false;
		}

	}

	public void turnRight(int ticks) {
		dial = ((dial + ticks) % 40;
		if (state == 0 && dial == secret1) {
			unLocked1 == true;
			state++;
		}
		else if (state == 2 && dial == secret3) {
			unLocked3 == true;
			state++;
		}
		else {
			 valid = false;
		}
	}

	public boolean open() {
		return (state == 3 && valid);
	}


}

public class Bonus {
	public static void main(String[] args) {
		System.out.println("FUCK OFF JURKO");
	}
}