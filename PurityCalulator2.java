    import java.util.Scanner;

    public class PurityCalulator2 {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("This program will calculate purity measures for a leaf node");
            System.out.println("and display the Gini score and other values calculated.");

            System.out.print("Please enter the number of objects in this leaf node of type I: ");
            int typeICount = scanner.nextInt();

            System.out.print("Please enter the number of objects in this leaf node of type II: ");
            int typeIICount = scanner.nextInt();

            double giniScore = calculateGiniScore(typeICount, typeIICount);
            giniScore = Math.round(giniScore * 1000.0 ) / 1000.0;
            double entropy = calculateEntropy(typeICount, typeIICount);
            entropy = Math.round(entropy * 1000.0 ) / 1000.0;

            System.out.println("The Gini score for this node is " + giniScore);
            System.out.println("The Entropy value for this node is " + entropy);
        }

        private static double calculateGiniScore(int typeICount, int typeIICount) {
            double total = typeICount + typeIICount;
            if (total == 0) {
                return 0; // Avoid division by zero
            }
            double pTypeI = typeICount / total;
            double pTypeII = typeIICount / total;

            return pTypeI * pTypeI + pTypeII * pTypeII;

        }

        private static double calculateEntropy(int typeICount, int typeIICount) {
            double total = typeICount + typeIICount;
            if (total == 0) {
                return 0; // Avoid division by zero
            }
            double entropy = 0;
            if (typeICount > 0) {
                double pTypeI = typeICount / total;
                entropy -= pTypeI * (Math.log(pTypeI) / Math.log(2)); // Log base 2
            }

            if (typeIICount > 0) {
                double pTypeII = typeIICount / total;
                entropy -= pTypeII * (Math.log(pTypeII) / Math.log(2)); // Log base 2
            }

            return entropy;
        }
    }

