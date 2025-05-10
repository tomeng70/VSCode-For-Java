// import the Scanner clas.
import java.util.Scanner;

public class Lesson04PartC {
    public static void main(String[] args) throws Exception {
        // create a scanner object so we can get input from user.
        Scanner input = new Scanner(System.in);

        // get the length, width, and height of a box.
        System.out.print("Enter the length, width, and height (cm) of the box: ");
        double length = input.nextDouble();
        double width = input.nextDouble();
        double height = input.nextDouble();

        // calculate the surface area.
        double surfaceArea = 2.0 * length * width;
        surfaceArea = surfaceArea + 2.0 * width * height;
        surfaceArea = surfaceArea + 2.0 * length * height;

        // calculate the volume.
        double volume = length * width * height;

        // display the values.
        System.out.printf("length (cm)     = %10.2f%n", length);
        System.out.printf("width  (cm)     = %10.2f%n", width);
        System.out.printf("height (cm)     = %10.2f%n", height);
        System.out.printf("s area (sq cm)  = %10.2f%n", surfaceArea);
        System.out.printf("volume (cu cm)  = %10.2f%n", volume);
    }
}
