import java.util.Arrays;

class Points {
    int x, y;

    public Points(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Points p) {
        return Math.sqrt(Math.pow(x - p.x, 2) + Math.pow(y - p.y, 2));
    }
}

class ClosestPair {

    private static double bruteForce(Points[] points, int start, int end) {
        double minDistance = Double.MAX_VALUE;

        for (int i = start; i <= end; i++) {
            for (int j = i + 1; j <= end; j++) {
                double distance = points[i].distance(points[j]);
                if (distance < minDistance) {
                    minDistance = distance;
                }
            }
        }

        return minDistance;
    }

    private static double closestUtil(Points[] points, int start, int end) {
        if (end - start < 3) {
            return bruteForce(points, start, end);
        }

        int mid = (start + end) / 2;
        double dl = closestUtil(points, start, mid);
        double dr = closestUtil(points, mid + 1, end);
        double d = Math.min(dl, dr);

        Points[] strip = new Points[end - start + 1];
        int j = 0;

        for (int i = start; i <= end; i++) {
            if (Math.abs(points[i].x - points[mid].x) < d) {
                strip[j++] = points[i];
            }
        }

        Arrays.sort(strip, 0, j, (a, b) -> a.y - b.y);

        for (int i = 0; i < j; i++) {
            for (int k = i + 1; k < j && strip[k].y - strip[i].y < d; k++) {
                double distance = strip[i].distance(strip[k]);
                if (distance < d) {
                    d = distance;
                }
            }
        }

        return d;
    }

    public static double closest(Points[] points) {
        Arrays.sort(points, (a, b) -> a.x - b.x);
        return closestUtil(points, 0, points.length - 1);
    }

    public static void main(String[] args) {
        Points[] points = {new Points(22, 23), new Points(84, 3), new Points(86, 14), new Points(53, 77), new Points(48, 97), new Points(89, 39),
                new Points(7, 100), new Points(51, 33), new Points(63, 14), new Points(74, 39)};
        double closestDist = ClosestPair.closest(points);
        System.out.println("the minimum distance between any two points is " + closestDist);
    }
}
//(22, 23), (84, 3), (86, 14), (53, 77), (48, 97), (89, 39), (7, 100), (51, 33), (63, 14), (74, 39)