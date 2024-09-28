import java.util.Arrays;

    public class Knapsack {

        public static void main(String[] args) {
            int[] weights = {11, 2, 1, 4, 1};
            int[] values = {4, 2, 1, 10, 2};
            int capacity = 15;

            knapsack(weights, values, capacity);
        }

        public static void knapsack(int[] weights, int[] values, int capacity) {
            int n = weights.length;
            int[][] dp = new int[n + 1][capacity + 1];

            for (int i = 1; i <= n; i++) {
                for (int w = 1; w <= capacity; w++) {
                    if (weights[i - 1] <= w) {
                        dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                    } else {
                        dp[i][w] = dp[i - 1][w];
                    }
                }
            }

            int totalValue = dp[n][capacity];
            int totalWeight = capacity;

            int[] pickedItems = new int[n];
            int i = n;
            int w = capacity;
            while (i > 0 && w > 0) {
                if (dp[i][w] != dp[i - 1][w]) {
                    pickedItems[i - 1] = 1;
                    totalWeight -= weights[i - 1];
                    w -= weights[i - 1];
                }
                i--;
            }

            System.out.println("Items picked: " + Arrays.toString(pickedItems));
            System.out.println("Total value of picked items: " + totalValue);
            System.out.println("Total weight of picked items: " + (capacity - totalWeight));
        }
    }
