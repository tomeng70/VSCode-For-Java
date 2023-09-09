import java.util.Scanner;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        // set up a Scanner to get user input.
        Scanner input = new Scanner(System.in);

    
        System.out.printf("PI = %012.5f%n", Math.PI);

        int a = 2;
        int b = 3762;
        int d = 468;
        System.out.printf("a = %05d%n", a);
        System.out.printf("b = %05d%n", b);
        System.out.printf("d = %05d%n", d);

        double total = 123.45;
        System.out.println("your total is " + total);

        System.out.println("This is a quotation mark \"");
        System.out.print("This is a newline \n");
        System.out.println("This is a backslash \\");

        char c = 'p';
        System.out.println(c);
        System.out.println((int) c);

        String name = "Harry Morgan";
        System.out.println("length =" + name.length());

        

        String message;
        message = String.join("-", "Java", "is", "cool");
        // the following statement prints "Java-is-cool".
        System.out.println(message);
        // the following statemetn prints "length = 12".
        System.out.println("length = " + message.length()); 

        /*
        // use dialog boxes to get and display info.
        String firstName = JOptionPane.showInputDialog("Enter your first name:");
        JOptionPane.showMessageDialog(null, "Your first name is " + firstName);
        
        String reply = JOptionPane.showInputDialog("Enter your age: ");
        int age = Integer.parseInt(reply);
        JOptionPane.showMessageDialog(null, "Your age is " + age);
        */
        
        int val = 78;
        System.out.printf("val = %07d%n", val);

        System.out.printf("Pi = %010.5f%n", Math.PI);

        String s = "Atomic Energy";
        int i = s.length() - 2;
        System.out.println(s.substring(1, 4) + s.substring(6, 9) + s.substring(i, i+1));

        int n = 957;
        int secondToLast = n % 100 / 10;
        System.out.println("secondToLast = " + secondToLast);

 

        System.out.print("Enter how much money do you have in dollars: ");
        double dollars = input.nextDouble();

        if (dollars >= 100) 
            System.out.println("Wow, you are rich!");
            System.out.println("How did you save so much money?");
            
        System.out.println("Goodbye!");

        System.out.print("Enter a digit: ");
        int digit = input.nextInt();
        String digitName;
        switch (digit) {
            case 1:
                digitName = "one";
                break;
            case 2:
                digitName = "two";
                break;
            case 3:
                digitName = "three";
                break;
            case 4:
                digitName = "four";
                break;
            case 5:
                digitName = "five";
                break;
            case 6:
                digitName = "six";
                break;
            case 7:
                digitName = "seven";
                break;
            case 8:
                digitName = "eight";
                break;
            case 9:
                digitName = "nine";
                break;
            default:
                digitName = "";
                break;
        }
        System.out.println("digitName = " + digitName);
    }
}
