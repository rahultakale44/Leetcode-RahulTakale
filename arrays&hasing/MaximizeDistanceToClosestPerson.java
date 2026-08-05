public class MaximizeDistanceToClosestPerson {

    public static int maxDistToClosest(int[] seats) {

        int n = seats.length;
        int maxDistance = 0;

        int lastPerson = -1;

        for (int i = 0; i < n; i++) {

            if (seats[i] == 1) {

                if (lastPerson == -1) {
                    maxDistance = i;
                } else {
                    int emptySeatsBetween = i - lastPerson - 1;
                    int distance = (emptySeatsBetween + 1) / 2;
                    maxDistance = Math.max(maxDistance, distance);
                }

                lastPerson = i;
            }
        }

        maxDistance = Math.max(maxDistance, n - 1 - lastPerson);

        return maxDistance;
    }

    public static void main(String[] args) {

        int[] seats1 = {1, 0, 0, 0, 1, 0, 1};
        int[] seats2 = {1, 0, 0, 0};
        int[] seats3 = {0, 1};

        System.out.println(maxDistToClosest(seats1)); // 2
        System.out.println(maxDistToClosest(seats2)); // 3
        System.out.println(maxDistToClosest(seats3)); // 1
    }
}