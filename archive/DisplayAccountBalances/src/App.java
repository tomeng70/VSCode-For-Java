import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // create an object of Scanner class.
        // we will use this object to scan in input from the user.
        Scanner input = new Scanner(System.in);
        
        // get first name and balance.
        System.out.print("Enter the first account ID: ");
        int id1 = input.nextInt();
        System.out.printf("Enter the account balance for ID = %06d ($): ", id1);
        double bal1 = input.nextDouble();

        // get first name and balance.
        System.out.print("Enter the second account ID: ");
        int id2 = input.nextInt();
        System.out.printf("Enter the account balance for ID = %06d ($): ", id2);
        double bal2 = input.nextDouble();

        // get first name and balance.
        System.out.print("Enter the third account ID: ");
        int id3 = input.nextInt();
        System.out.printf("Enter the account balance for ID = %06d ($): ", id3);
        double bal3 = input.nextDouble();

        // print formatted output.
        System.out.println();
        System.out.printf("Account #%06d has a balance of $%12.2f%n", id1, bal1);
        System.out.printf("Account #%06d has a balance of $%12.2f%n", id2, bal2);
        System.out.printf("Account #%06d has a balance of $%12.2f%n", id3, bal3);
    }
}
