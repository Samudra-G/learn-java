import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

interface RemoteControlCar {
	void drive();
	int getDistanceTravelled();
}

class ProductionRemoteControlCar implements RemoteControlCar, Comparable<ProductionRemoteControlCar> {
    private static final int TRAVEL_UNITS = 10;
    private int distanceTravelled;
    private int numberOfVictories;

    public void setNumberOfVictories(int victories) {
        this.numberOfVictories = victories;
    }

    public void drive() {
        this.distanceTravelled += TRAVEL_UNITS;
    }

    public int getDistanceTravelled() {
        return this.distanceTravelled;
    }

    @Override
    public int compareTo(ProductionRemoteControlCar other) {
        // Null safety check
        if(other == null) {
            throw new NullPointerException("Cannot compare with null.");
        }
        return Integer.compare(this.numberOfVictories, other.numberOfVictories);
    }

    @Override
    public String toString() {
        return "Car(victories=" + this.numberOfVictories + ")";
    }
}

class ExperimentalRemoteControlCar implements RemoteControlCar {
    private static final int TRAVEL_UNITS = 20;
    private int distanceTravelled;

    public void drive() {
        this.distanceTravelled += TRAVEL_UNITS;
    }

    public int getDistanceTravelled() {
        return this.distanceTravelled;
    }
}

class TestTrack {
    // Let JVM invoke default constructor

    public static void race(RemoteControlCar obj) {
        obj.drive();
    }

    public static List<ProductionRemoteControlCar> getRankedCars(List<ProductionRemoteControlCar> list) {
        list.sort(Comparator.reverseOrder());
        return list;
    }
}

class RemoteControlCarExample {
    public static void main(String[] args) {

        ProductionRemoteControlCar prod = new ProductionRemoteControlCar();
        prod.drive();
        System.out.println("Distance travlled by production car: " + prod.getDistanceTravelled());

        ExperimentalRemoteControlCar exp = new ExperimentalRemoteControlCar();
        exp.drive();
        System.out.println("Distance travlled by experimental car: " + exp.getDistanceTravelled());

        TestTrack.race(new ProductionRemoteControlCar());
        TestTrack.race(new ExperimentalRemoteControlCar());

        ProductionRemoteControlCar prc1 = new ProductionRemoteControlCar();
        ProductionRemoteControlCar prc2 = new ProductionRemoteControlCar();
        prc1.setNumberOfVictories(2);
        prc2.setNumberOfVictories(3);
        List<ProductionRemoteControlCar> unsortedCars = new ArrayList<>();
        unsortedCars.add(prc1);
        unsortedCars.add(prc2);
        List<ProductionRemoteControlCar> rankings = TestTrack.getRankedCars(unsortedCars);
        System.out.println(rankings);

    }
}
