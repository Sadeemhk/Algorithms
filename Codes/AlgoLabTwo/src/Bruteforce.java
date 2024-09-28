class Bruteforce {
    static int BruteForceStringMatching(String T, String P)
     {
        int n = T.length();
        int m = P.length();

        for (int i = 0; i <= n - m; i++) {
            int j = 0;
            while (j < m && P.charAt(j) == T.charAt(i + j)){
                j = j + 1;
                if (j == m) {
                    return i;
                }
            }
        }
        return -1; //not found
     }
        public static void main (String[]args){
            String Tvalues = "CCCS 314 – Design and Analysis of Algorithms";
            String Pvalues = "Lab two exercise three";

            int result = BruteForceStringMatching(Tvalues, Pvalues);

            if (result != -1) {
                System.out.println("Pattern found at index: " + result);
            } else {
                System.out.println("Pattern not found in the text.");
            }
        }
  }


