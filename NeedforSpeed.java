public class NeedforSpeed {

    private int speed;
    private int battery;
    private int batteryDrain;
    private int distanceDriven;

    public NeedforSpeed() {
        this(5,2);
    }

    public NeedforSpeed(int speed, int batteryDrain) {
        this.speed = speed;
        this.battery = 100;
        this.batteryDrain = batteryDrain;
        this.distanceDriven = 0;
    }

    public int getSpeed() {
        return this.speed;
    }

    public int getBatteryDrain() {
        return this.batteryDrain;
    }

    public int getBatteryLeft() {
        return this.battery;
    }

    public void drive() {
        if(!batteryDrain())
            this.distanceDriven += this.speed;
            this.battery -= this.batteryDrain;
    }

    public int distanceDriven() {
        return this.distanceDriven;
    }

    public boolean batteryDrain() {
        return (this.battery - batteryDrain) < 0 || this.battery == 0;
    }

    public static NeedforSpeed nitro() {
        return new NeedforSpeed(50,4);
    }

    public static void main(String[] args) {
        // 1. Create cars
        NeedforSpeed car = new NeedforSpeed(10, 3);
        NeedforSpeed nitroCar = NeedforSpeed.nitro();

        // 2. Test driving
        car.drive();
        car.drive();
        nitroCar.drive();

        System.out.println("Normal car distance: " + car.distanceDriven());
        System.out.println("Nitro car distance: " + nitroCar.distanceDriven());

        System.out.println("Normal car battery: " + car.getBatteryLeft());
        System.out.println("Nitro car battery: " + nitroCar.getBatteryLeft());

        // 3. Create race tracks
        RaceTrack race1 = new RaceTrack(100);
        RaceTrack race2 = new RaceTrack(300);
        RaceTrack race3 = new RaceTrack(1000);

        // 4. Test race completion
        System.out.println("\n--- Race Results ---");

        System.out.println("Normal car - 100m: " + race1.canFinishRace(car));
        System.out.println("Normal car - 300m: " + race2.canFinishRace(car));
        System.out.println("Normal car - 1000m: " + race3.canFinishRace(car));

        System.out.println("Nitro car - 100m: " + race1.canFinishRace(nitroCar));
        System.out.println("Nitro car - 300m: " + race2.canFinishRace(nitroCar));
        System.out.println("Nitro car - 1000m: " + race3.canFinishRace(nitroCar));

    }
}

class RaceTrack {

    private int distance;

    public RaceTrack(int distance) {
        this.distance = distance;
    }

    public boolean canFinishRace(NeedforSpeed obj) {
        int totalDrivesRequired = (int) Math.ceil(this.distance / obj.getSpeed());
        return totalDrivesRequired * obj.getBatteryDrain() <= obj.getBatteryLeft();
    }
}
