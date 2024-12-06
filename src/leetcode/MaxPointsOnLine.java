package leetcode;

public class MaxPointsOnLine {

    public static void main(String[] args) {

    }

    public int maxPoints(int[][] points) {

        int x1 = points[0][0];
        int y1 = points[0][1];

        int x2 = points[1][0];
        int y2 = points[1][1];


        float angle;

        if (x2-x1 == 0){
            angle = -1;
        }else {
            angle = ((float) Math.abs(y2 - y1)) / Math.abs(x2-x1);
        }
        int i = 0;

        int initialHolder = i;
        int max = 0;

        while (i < points.length){
            x1 = points[initialHolder][0];
            y1 = points[initialHolder][1];

            x2 = points[i+1][0];
            y2 = points[i+1][1];

            if (angle != angle){
                initialHolder = i;
                int gcd = findGCD(Math.abs(x1-x2), Math.abs(y1-y2));
                max = Math.max(gcd, max);
            }
            if (x2-x1 == 0){
                angle = -1;
            }else {
                angle = ((float) Math.abs(y2 - y1)) / Math.abs(x2-x1);
            }
            i++;
        }

        return max;
    }

    public static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }




}
