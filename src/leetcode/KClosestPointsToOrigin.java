package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;

public class KClosestPointsToOrigin {

    public static void main(String[] args) {


        kClosest(new int[][]{{1,3},{-2,2},{4,2}}, 1);
    }

    public static int[][] kClosest(int[][] points, int k) {

        int[][] arr = new int[k][2];

        ArrayList<DataHolder> arrayList = new ArrayList<>();


        for (int i = 0; i < points.length; i++) {
            int num1 = points[i][0];
            int num2 = points[i][1];

            double distance = Math.sqrt(num1*num1+num2*num2);
            arrayList.add(new DataHolder(distance, num1, num2));
        }

        arrayList.sort(Comparator.comparingDouble(d -> d.distance));
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = arrayList.get(i).x;
            arr[i][1] = arrayList.get(i).y;
        }
        return arr;
    }

    public static class DataHolder{
        double distance;
        int x;
        int y;

        public DataHolder(double distance, int x, int y) {
            this.distance = distance;
            this.x = x;
            this.y = y;
        }
    }

}
