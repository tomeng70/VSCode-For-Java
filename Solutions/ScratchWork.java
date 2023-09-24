import java.util.Scanner;

public class ScratchWork {
    static public void main(String args[]) {
        String answer = String.valueOf(Math.PI / 2.0);
        System.out.println("answer = " + answer);

        String msg = String.format("PI = %.5f", Math.PI);
        System.out.println(msg.length());

        /*
        // prompt user for age.
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your age: ");
        int age = input.nextInt();
        if (age = 13) {
            System.out.println("Lucky 13!");
        }
        */
        double a = 1.2; 
        double b= 3.0;
        double c = a * b; 
        if(c == 3.6){
            System.out.println("c is 3.6");
        } else {
            System.out.println("c is not 3.6");
        } 
        

        
    }
}
