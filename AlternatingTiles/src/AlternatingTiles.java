import java.util.Scanner;

public class AlternatingTiles {
    static final int TILE_WIDTH = 5; // inches
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        // ask user for wall width.
        System.out.print("Enter the width of the wall (inches): ");
        int wallWidth = input.nextInt();

        // since a row must start and end with a black tile,
        // the total number of tiles must be odd.
        // each row starts with a black tile.
        // then it's followed by pairs of tiles (white then black).
        // let's calculate how many pairs of tiles there are.
        int numberOfPairs = (wallWidth - TILE_WIDTH) / (2 * TILE_WIDTH);
        
        // number of tiles equals 1 + num of pairs * 2.
        int numberOfTiles = 1 + numberOfPairs * 2;

        // calculate the gap.
        double gap = wallWidth - numberOfTiles * TILE_WIDTH;
        gap = gap / 2.0;

        // print the info.
        System.out.printf("Wall width = %d inches.%n", wallWidth);
        System.out.printf("Width of tile row = %d inches.%n", numberOfTiles * TILE_WIDTH);
        System.out.printf("Gap on each side = %.02f inches.%n", gap);
        System.out.printf("Number of black tiles = %d%n", numberOfPairs + 1);
        System.out.printf("Number of white tiles = %d%n", numberOfPairs);
    }
}
