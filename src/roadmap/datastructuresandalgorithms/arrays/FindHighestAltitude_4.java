package roadmap.datastructuresandalgorithms.arrays;

public class FindHighestAltitude_4 {

    public int largestAltitude(int[] gain) {
        int maxAltitude = 0;
        int currentAltitude = 0;
        for (int num : gain) {
            currentAltitude =  num;
            maxAltitude = Math.max(maxAltitude, currentAltitude);

        }

        return maxAltitude;
    }
}
