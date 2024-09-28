import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SalesPerson {
    public static void main(String[] args) {
        int[][] distanceMatrix = {
                {0, 2, 8, 5},
                {2, 0, 3, 4},
                {8, 3, 0, 7},
                {5, 4, 7, 0}
        };

        TSPResult result = tspExhaustiveSearch(distanceMatrix);

        System.out.println("Best Path: " + result.bestPath);
        System.out.println("Minimum Distance: " + result.minDistance);
    }

    static class TSPResult {
        List<Integer> bestPath;
        int minDistance;

        TSPResult(List<Integer> bestPath, int minDistance) {
            this.bestPath = bestPath;
            this.minDistance = minDistance;
        }
    }

    static TSPResult tspExhaustiveSearch(int[][] distanceMatrix) {
        int numNodes = distanceMatrix.length;
        int[] nodes = new int[numNodes];
        for (int i = 0; i < numNodes; i++) {
            nodes[i] = i;
        }

        List<Integer> bestRoute = new ArrayList<>();
        int minDistance = Integer.MAX_VALUE;

        do {
            int currentDistance = calculateTotalDistance(nodes, distanceMatrix);

            if (currentDistance < minDistance) {
                minDistance = currentDistance;
                bestRoute = new ArrayList<>(Arrays.asList(Arrays.stream(nodes).boxed().toArray(Integer[]::new)));
            }

        } while (nextPermutation(nodes));

        return new TSPResult(bestRoute, minDistance);
    }

    static int calculateTotalDistance(int[] path, int[][] distanceMatrix) {
        int totalDistance = 0;
        for (int i = 0; i < path.length - 1; i++) {
            totalDistance += distanceMatrix[path[i]][path[i + 1]];
        }
        totalDistance += distanceMatrix[path[path.length - 1]][path[0]]; // Return to the starting node
        return totalDistance;
    }

    static boolean nextPermutation(int[] array) {
        int i = array.length - 1;
        while (i > 0 && array[i - 1] >= array[i]) {
            i--;
        }

        if (i <= 0) {
            return false;
        }

        int j = array.length - 1;
        while (array[j] <= array[i - 1]) {
            j--;
        }

        int temp = array[i - 1];
        array[i - 1] = array[j];
        array[j] = temp;

        j = array.length - 1;
        while (i < j) {
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
        return true;
    }
}
