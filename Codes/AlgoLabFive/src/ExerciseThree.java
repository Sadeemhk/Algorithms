/*
  Sadeem Aljahdali
  2116258
  CNL
 */

import java.util.Arrays;
import java.util.Random;

    public class ExerciseThree {

        public static void main(String[] args) {
            // This is the entry point of the program. It defines the main method which will be executed when the program is run.
            // These are the suggested values in the lab file
            int InputPoints[] = {10, 20, 100, 1000, 5000};
            int TrialsNum = 10;

            // These arrays will store the execution times of the brute force and Transform and Conquer algorithms for each input size.
            long BFTimes[] = new long[InputPoints.length];
            long TCTimes[] = new long[InputPoints.length];

            // This random class to generate random numbers
            Random rand = new Random();

            //This is the first loop which iterates over all input points, n is the random points, points array hold the values
            for (int i = 0; i < InputPoints.length; i++) {
                int n = InputPoints[i];
                double points[] = new double[n];

                //This loop will generate random points
                for (int j = 0; j < n; j++) {
                    points[j] = rand.nextDouble() * 1000;
                }

                //Each input points will execute Brute force and Transform and Conquer algorithms
                //Then measure the start and end time, execute the algorithm, and calculate the elapsed time

                // Brute force algorithm
                long startTime = System.nanoTime();
                bruteForceClosestPair(points);
                long endTime = System.nanoTime();
                BFTimes[i] = endTime - startTime;

                // Transform and Conquer algorithm
                startTime = System.nanoTime();
                TnC_closest_pair_1D(points);
                endTime = System.nanoTime();
                TCTimes[i] = endTime - startTime;
            }

            // Plotting the times
            plotExecutionTimes(InputPoints, BFTimes, TCTimes);
        }

        // Brute force algorithm to find the minimum distance between any two points
        public static double bruteForceClosestPair(double[] P) {
            double minDist = Double.POSITIVE_INFINITY;

            for (int i = 0; i < P.length - 1; i++) {
                for (int j = i + 1; j < P.length; j++) {
                    double dist = Math.abs(P[i] - P[j]);
                    if (dist < minDist) {
                        minDist = dist;
                    }
                }
            }

            return minDist;
        }

        // Transform and Conquer algorithm to find the minimum distance between any two points
        public static double TnC_closest_pair_1D(double[] P) {
            Arrays.sort(P);

            double minDist = Double.POSITIVE_INFINITY;

            for (int i = 0; i < P.length - 1; i++) {
                double dist = Math.abs(P[i] - P[i + 1]);
                if (dist < minDist) {
                    minDist = dist;
                }
            }

            return minDist;
        }

        // Plot execution times for both algorithms
        public static void plotExecutionTimes(int inputPoints[], long bruteForceTimes[], long transformConquerTimes[]) {
            // Print the execution times
            System.out.println("Input Points \tBrute Force Time (ns) \t\t\tTransform and Conquer Time (ns)");
            for (int i = 0; i < inputPoints.length; i++) {
                System.out.println(inputPoints[i] + "\t\t\t\t" + bruteForceTimes[i] + "\t\t\t\t\t\t\t" + transformConquerTimes[i]);
            }
        }
    }


