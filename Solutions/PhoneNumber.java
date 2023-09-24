import java.util.Scanner;

public class PhoneNumber {
    static public void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // get the phone number from the user.
        String origNumber;
        System.out.print("Enter a 10 digit phone number (no spaces): ");
        origNumber = input.next();

        String formattedNumber;
        formattedNumber = "(" + origNumber.substring(0, 3) + ") " + origNumber.substring(3, 6) + "-" + origNumber.substring(6);
        System.out.println("The formatted number is " + formattedNumber);

        input.close();
        
    }
}