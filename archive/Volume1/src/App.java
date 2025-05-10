/*
 * Thomas Eng
 * SW Design with Java.
 * HW #03, Part 1
 */

// This program calculates the volume of soda for some cans and bottles.
public class App {
    public static void main(String[] args) throws Exception {
        // declare & init variable called cansPerPack
        int cansPerPack = 6;

        // declare a constant value for the volume of soda per can (liters).
        final double CAN_VOLUME = 0.355;

        // what is the total volume, in liters, for a pack of soda?
        double totalVolume = CAN_VOLUME * cansPerPack;
        System.out.println("The volume of soda in a pack is " + totalVolume + " liters.");

        // declare a constant value for the volume of soda per bottle (liters).
        final double BOTTLE_VOLUME = 2.0;

        // how much soda in a pack and a bottle?
        totalVolume = totalVolume + BOTTLE_VOLUME;
        System.out.println("A bottle and a pack of soda has a total volume of " + totalVolume + " liters");
    }
}
