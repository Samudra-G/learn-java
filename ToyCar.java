public class ToyCar {

	private int batteryLeft;
	private double distanceDriven;

	public ToyCar() {
	    this.batteryLeft = 100;
		this.distanceDriven = 0.0;
	}

	public void setBattery(int batteryLeft) {
	    this.batteryLeft = batteryLeft;
	}

	public static ToyCar buy() {
	    return new ToyCar();
	}

	public void distanceDisplay() {
	     System.out.println(this.distanceDriven + "m");
	}

	public void batteryDisplay() {
        if(this.batteryLeft == 0) {
            System.out.println("Battery empty!");
            return;
        }
	    System.out.println(this.batteryLeft + "%");
	}

	public void drive() {
	    if(this.batteryLeft == 0) {
			System.out.println("Battery empty!");
			return;
		}
	    this.distanceDriven += 20.0;
		this.batteryLeft--;
	}

	public static void main(String[] args) {
		ToyCar car = ToyCar.buy();
		car.batteryDisplay();
		car.distanceDisplay();
		car.drive();
		car.drive();
		car.batteryDisplay();
		car.distanceDisplay();

		car.setBattery(0);
		car.drive();
		car.batteryDisplay();
		car.distanceDisplay();
	}
}
