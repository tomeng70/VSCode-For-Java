// This example program places "tiles" along the edges of the room.
// It also places a few tiles in the center of the room.

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // set up a Scanner to get user input.
        Scanner input = new Scanner(System.in);

        // get dimensions of the room.
        System.out.print("Enter the width of the room: ");
        int width = input.nextInt();
        System.out.print("Enter the height of the room: ");
        int height = input.nextInt();

        // calculate the special rows.
        int y1, y2;
        if (height % 2 == 1) {
            // it's odd.
            y1 = height / 2;

            // set y2 to an out of range value.
            y2 = -1;
        } else {
            // it's even.
            y1 = height / 2 - 1;
            y2 = y1 + 1;
        }

        // calculate the special columns.
        int x1, x2, x3;
        if (width % 2 == 1) {
            // it's odd.
            x2 = width / 2;
            x1 = x2 - 1;
            x3 = x2 + 1;
        } else {
            // it's even.
            x1 = width / 2 - 1;
            x2 = x1 + 1;
            x3 = -1;
        }

        // go row by row.
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                // if we're on an edge print "*"
                // otherwise print " "
                if (y == 0 || y == (height - 1)) {
                    System.out.print("*");
                } else if (x == 0 || x == (width - 1)) {
                    System.out.print("*");
                } else if ((y == y1 || y == y2) && (x == x1 || x == x2 || x == x3)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
    }
}
