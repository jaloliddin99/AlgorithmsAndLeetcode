package leetcode;

public class MaxPointsOnLine {

    public static void main(String[] args) {

    }

    public int maxPoints(int[][] points) {
        return pointsFinder(points, 0, 2);
    }

    public int pointsFinder(int[][] points, int index, int max){
        int x0 = points[index][0];
        int y0 = points[index][1];
        int x1 = points[index+1][0];
        int y1 = points[index+1][1];

        int dx = x1 - x0;
        int dy = y1 - y0;

        for (int i = index+2; i < points.length; i++) {
            int x2 = points[i][0];
            int y2 = points[i][1];

            if ((y2 - y1) * dx != (x2 - x1) * dy) {
                pointsFinder(points, i, max);
            }else {
                max++;
            }
        }
        return max;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }


}
