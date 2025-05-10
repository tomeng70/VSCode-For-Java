/*
 * Thomas Eng
 * SW Design with Java.
 * 
 * An architect is designing a room that will have a row of alternating black and white tiles 
 * on the walls.  The architect would also like for the first and last tiles in each row be black.
 * Each tile is 5” wide.
 * 
 * Write a program that calculates how big the gap on each end of a row should be given 
 * a specified total width of the wall.  The program should also specify how many black 
 * tiles and how many white tiles will be needed for the row.
 */

// import Scanner class so we can get keyboard input from user.
import java.util.Scanner;

public class PartB {
    public static void main(String[] args) {
        // create Scanner object.
        Scanner in = new Scanner(System.in);

        // assume the tile width is fixed at 5"
        final double TILE_WIDTH = 5.0;

        // prompt user for the room width.
        System.out.print("Enter the room width (inches): ");
        double room_width = in.nextDouble();

        // calculate number of tiles. cast result to an integer.
        int num_tiles = (int) (room_width / TILE_WIDTH);

        // is the number even? we can't have even number since we start and end with
        // black tile.
        if (num_tiles % 2 == 0) {
            // decrease by 1 to make the number an odd value.
            num_tiles = num_tiles - 1;
        }

        // how many white tiles?
        int num_white = num_tiles / 2;

        // calculate how many black tiles.
        int num_black = num_white + 1;

        // calculate gap.
        double gap = room_width - num_tiles * TILE_WIDTH;
        gap = gap / 2.0;

        // display info.
        System.out.printf("Room width (in) =  %8.2f%n", room_width);
        System.out.printf("Number of tiles = %6d%n", num_tiles);
        System.out.printf("White tiles     = %6d%n", num_white);
        System.out.printf("Black tiles     = %6d%n", num_black);
        System.out.printf("Gap (in)        =  %8.2f%n", gap);
    }
}
