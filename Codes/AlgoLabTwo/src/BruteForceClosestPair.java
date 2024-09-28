class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class BruteForceClosestPair {
    public static void main(String[] args) {
        Point[] points = {
                new Point(0, 1),
                new Point(1, 2),
                new Point(2, 3),
                new Point(3, 4),
                new Point(4, 0)
        };

        int[] closestPoints = findClosestPoints(points);
        int index1 = closestPoints[0];
        int index2 = closestPoints[1];

        // Print the closest points indexes
        System.out.println("Closest Points Indexes: " + index1 + ", " + index2);

        // Calculate and print the distance between the closest points
        double distance = computeDistance(points[index1], points[index2]);
        System.out.println("Distance between closest points: " + distance);
    }

    public static int[] findClosestPoints(Point[] points) {
        int n = points.length;
        double minDistance = Double.MAX_VALUE;
        int[] closestPoints = new int[2];

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double distance = computeDistance(points[i], points[j]);

                if (distance < minDistance) {
                    minDistance = distance;
                    closestPoints[0] = i;
                    closestPoints[1] = j;
                }
            }
        }

        return closestPoints;
    }

    public static double computeDistance(Point p1, Point p2) {
        int dx = p1.x - p2.x;
        int dy = p1.y - p2.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
}
