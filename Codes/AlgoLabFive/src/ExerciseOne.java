/*
  Sadeem Aljahdali
  2116258
  CNL
 */

import java.util.Arrays;

public class ExerciseOne {

    public static double[] TnC_closest_pair_1D(double P[]) {
        Arrays.sort(P);

        // Initialize variables to store minimum distance and indices of closest points
        double MinDis = Double.POSITIVE_INFINITY;
        int indexP1 = 0;
        int indexP2 = 0;

        // Iterate through the sorted array to find the closest pair
        for (int i = 0; i < P.length - 1; i++) {
            double Dist = Math.abs(P[i] - P[i + 1]); /* The Math.abs method takes one  parameter that is of number type and returns its absolute value
            positive value of the number, without using the negative sign*/

            // if the current distance is smaller the minimum distance and indices will update
            if (Dist < MinDis) {
                MinDis = Dist;
                indexP1 = i;
                indexP2 = i + 1;
            }
        }

        // Return the minimum distance and indices of closest points
        return new double[]{MinDis, indexP1, indexP2};
    }

    public static void main(String[] args) {
        double points[] = {3, 2, 3.3, 6, 7, 12, 3.9, 1, 9, 18, 8, 56};
        double result[] = TnC_closest_pair_1D(points);

        double MinDis = result[0];
        int IndexP1 = (int) result[1];
        int IndexP2 = (int) result[2];


        System.out.println("\tSort the data first");
        System.out.println("Sorted Points = " + Arrays.toString(points));
        System.out.println("Minimum Distance = " + MinDis);
        System.out.println("Index P1 = " + IndexP1);
        System.out.println("Index P2 = " + IndexP2);
    }
}

