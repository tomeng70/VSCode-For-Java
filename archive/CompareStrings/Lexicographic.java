import java.util.Scanner;
public class Lexicographic {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a string value: ");
		String s1 = input.next();
		System.out.print("Enter another string value: ");
		String s2 = input.next();   

		if (s1.compareTo(s2) == 0) {
			System.out.println("The two strings are the same");
		} else if (s1.compareTo(s2) < 0) {
			System.out.println("\"" + s1 +"\" appears in the dictionary before \"" + s2 + "\"");
		} else {
			System.out.println("\"" + s2 +"\" appears in the dictionary before \"" + s1 + "\"");
		}
	}
}