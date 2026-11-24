import java.util.*;
class BirdWatcher {
    private int[] lastWeek = {0, 2, 5, 3, 7, 8, 4};
    private int[] birdsPerDay = new int[7];

    public BirdWatcher(int[] birdsArray) {
        this.birdsPerDay = birdsArray;
    }

    public int[] getLastWeek() {
        return this.lastWeek;
    }

    public int getToday() {
        return birdsPerDay[birdsPerDay.length-1];
    }

    public void incrementTodayCount() {
        birdsPerDay[birdsPerDay.length-1]++;
    }

    public boolean hasDayWithoutBirds() {
        for(int count : birdsPerDay) {
            if(count == 0) return true;
        }
        return false;
    }

    public int getCountForFirstDays(int days) {
        int totalBirds = 0;
        for(int i=0; i<days; ++i) {
            totalBirds += birdsPerDay[i];
        }
        return totalBirds;
    }

    public int getBusyDays() {
        int days = 0;
        for(int count : birdsPerDay) {
            if(count >= 5) days++;
        }

        return days;
    }

    public static void main(String[] args) {
            int[] birds = {2, 0, 5, 3, 7, 8, 4};

            BirdWatcher watcher = new BirdWatcher(birds);

            // Last week
            System.out.println("Last week: " +
                    Arrays.toString(watcher.getLastWeek()));

            // Today's count
            System.out.println("Today's count: " + watcher.getToday());

            // Increment today's count
            watcher.incrementTodayCount();
            System.out.println("After increment: " + watcher.getToday());

            // Check for a day without birds
            System.out.println("Day without birds? " +
                    watcher.hasDayWithoutBirds());

            // Count birds in first N days
            System.out.println("Birds in first 4 days: " +
                    watcher.getCountForFirstDays(4));

            // Count busy days (5 or more birds)
            System.out.println("Busy days: " + watcher.getBusyDays());
    }
}
