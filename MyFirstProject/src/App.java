// import the Scanner class so we can use it to scan input from user.
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // declare and create and object of Scanner class.
        // use the standard input stream to get data from user.
        Scanner input = new Scanner(System.in);

        // prompt user for their name.
        //System.out.print("Enter your name: ");
        //String name = input.nextLine();
        
        // say hello.
        //System.out.println("Hello " + name);

        String name = "Harry";
        System.out.println("Your name is " + name);
        System.out.println("Let's SHOUT your name: " + name.toUpperCase());

        int length = name.length();
        System.out.println("The length of name is " + length);
        System.out.println("The first letter in name is " + name.charAt(0));
        System.out.println("The last letter in name is " + name.charAt(length - 1));


    }
}
