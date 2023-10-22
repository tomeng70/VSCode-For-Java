public class ExampleMultTable {
    public static void main(String[] args) {
        int row;
        int col;
        int product;

        // go row by row.
        for (row = 1; row <= 3; row++) {
            // print product for each column in a row.
            for (col = 1; col <= 3; col++) {
                // calculate product.
                product = row * col;

                // print product.
                System.out.printf("%5d", product);
            }

            // after you are done printing all of the columns
            // in a row, print a newline.
            System.out.println();    
        }
    }
}