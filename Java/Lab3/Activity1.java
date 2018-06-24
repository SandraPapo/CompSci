class Car {

	private double fuelEfficiency; // liters/km
	private double fuel;

	public Car(double fuelEfficiency){
		this.fuelEfficiency = fuelEfficiency;
		fuel = 0;
	}

	public void addGas(double newFuel){
		fuel += newFuel;
	}

	public void drive(double distanceDriven){
		fuel -= (distanceDriven/fuelEfficiency);
	}

	public double getGasInTank(){
		return fuel;
	}

}

public class Activity1{
	public static void main(String[] args) {
		Car myHybrid = new Car(50); // 50 miles per gallon
		myHybrid.addGas(20); // Tank 20 gallons
		myHybrid.drive(100); // Drive 100 miles
		double gasLeft = myHybrid.getGasInTank();
		System.out.println(gasLeft);
	}
}