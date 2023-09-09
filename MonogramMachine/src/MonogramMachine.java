import java.util.Scanner;

public class MonogramMachine {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your first middle and last names: ");
        String first = input.next();
        String middle = input.next();
        String last = input.next();

        String monogram = first.substring(0, 1)
                + middle.substring(0, 1) + last.substring(0, 1);
            
        System.out.println("Your monogram is " + monogram);

    }
}
