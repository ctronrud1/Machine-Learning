import java.util.Scanner;

public class PurityScore {

    // Charlie and Dalton Purity Calc Submission
    public static double calculateGini(int typeI, int typeII) {
        double totalObjects = typeI + typeII;
        double pTypeI = typeI / totalObjects;
        double pTypeII = typeII / totalObjects;
        return Math.pow(pTypeI, 2) + Math.pow(pTypeII, 2); //need to for type double
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("This program will calculate purity measures for a leaf node and display the Gini score and other values calculated");
        System.out.print("Please enter the number of objects in this leaf node of type I: ");
        int typeI = scanner.nextInt(); //type1 intake
        System.out.print("Please enter the number of objects in this leaf node of type II: ");
        int typeII = scanner.nextInt(); //type2intake

        double giniScore = calculateGini(typeI, typeII); //call calculateGini
        giniScore = Math.round(giniScore * 1000.0 ) / 1000.0; // round to nearest thousandth

        System.out.println("The Gini score for this node is " + giniScore);
    }
}
