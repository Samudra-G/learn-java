class Lasagna {

    private int ovenTime;
    private int oneLayerPreprationTime;

    public Lasagna() {
        this.ovenTime = 40;
        this.oneLayerPreprationTime = 2;
    }

    public int expectedMinutesInOven() {
        return ovenTime;
    }

    public int remainingMinutesInOven(int timeInOven) {
        if (timeInOven > this.ovenTime) {
            System.out.println("Your lasagna is COOKED fr bro.");
            return -1;
        }
        return this.ovenTime - timeInOven;
    }

    public int preparationTimeInMinutes(int totalLayers) {
        return this.oneLayerPreprationTime * totalLayers;
    }

    public int totalTimeInMinutes(int totalLayers, int timeInOven) {
        return preparationTimeInMinutes(totalLayers) + timeInOven;
    }

    public static void main(String args[]) {
        System.out.println("Recipe: Lasagna");

        Lasagna lasagna = new Lasagna();

        System.out.println(lasagna.expectedMinutesInOven());

        int timeInOven = 25, totalLayers = 4;

        System.out.println(lasagna.remainingMinutesInOven(timeInOven));
        System.out.println(lasagna.preparationTimeInMinutes(totalLayers));
        System.out.println(lasagna.totalTimeInMinutes(totalLayers, timeInOven));
    }
}
