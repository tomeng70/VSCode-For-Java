import java.util.Scanner;

public class Roman {
    public static String generateRoman(int val) {
        // assumes the val is not greater than 3999.
        // generate a string that represents the number in Roman form.
        String roman;

        // how many thousands (not to exceed 3000)?
        int thousands = val / 1000;
        val = val % 1000;

        // generate the thousands string.
        if (thousands == 3) {
            roman = "MMM";
        } else if (thousands ==2) {
            roman = "MM";
        } else if (thousands ==1) {
            roman = "M";
        } else {
            roman = "";
        }

        // generate the hundreds string.
        int hundreds = val / 100;
        val = val % 100;
        if (hundreds == 9) {
            roman = roman.concat("CM");
        } else if (hundreds == 8) {
            roman = roman.concat("DCCC");
        } else if (hundreds == 7) {
            roman = roman.concat("DCC");
        } else if (hundreds == 6) {
            roman = roman.concat("DC");
        } else if (hundreds == 5) {
            roman = roman.concat("D");
        } else if (hundreds == 4) {
            roman = roman.concat("CD");
        } else if (hundreds == 3) {
            roman = roman.concat("CCC");
        } else if (hundreds == 2) {
            roman = roman.concat("CC");
        } else if (hundreds == 1) {
            roman = roman.concat("C");
        }

        // generate tens string.
        int tens = val / 10;
        val = val % 10;
        if (tens == 9) {
            roman = roman.concat("XC");
        } else if (tens == 8) {
            roman = roman.concat("LXXX");
        } else if (tens == 7) {
            roman = roman.concat("LXX");
        } else if (tens == 6) {
            roman = roman.concat("LX");
        } else if (tens == 5) {
            roman = roman.concat("L");
        } else if (tens == 4) {
            roman = roman.concat("XL");
        } else if (tens == 3) {
            roman = roman.concat("XXX");
        } else if (tens == 2) {
            roman = roman.concat("XX");
        } else if (tens == 1) {
            roman = roman.concat("X");
        }

        // generate the ones string.
        if (val == 9) {
            roman = roman.concat("IX");
        } if (val == 8) {
            roman = roman.concat("VIII");
        } if (val == 7) {
            roman = roman.concat("VII");
        } if (val == 6) {
            roman = roman.concat("VI");
        } if (val == 5) {
            roman = roman.concat("V");
        }  if (val == 4) {
            roman = roman.concat("IV");
        }  if (val == 3) {
            roman = roman.concat("III");
        }  if (val == 2) {
            roman = roman.concat("II");
        } if (val == 1) {
            roman = roman.concat("I");
        }

        // return the Roman format numeral as a string.
        return roman;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int orig;
        final int MAX_VAL = 3999;

        // prompt user for input.
        System.out.printf("Enter an integer from 1 to %d: ", MAX_VAL);
        if(input.hasNextInt()) {
            orig = input.nextInt();
        } else {
            System.out.println("Error: You must enter a valid integer.");
            orig = 0;
        }

        if (orig >  MAX_VAL) {
            System.out.printf("Error: value must be less than or equal to %d.%n", MAX_VAL);
            orig = 0;
        } else if (orig < 1) {
            System.out.printf("Error: value must be greater than 0%n");
            orig = 0;
        }

        String roman;
        if (orig > 0) {
            roman = generateRoman(orig);
            System.out.println(orig + " is equal to " + roman);
        }



    }
}
