import java.util.Scanner;

public class App {
    static final int MAX_WIDTH = 100;
    static final int MAX_HEIGHT = 100;
    public int width;
    public int height;
    char yard[][];

    // constructor.
    public App() {
        // create an array to hold the characters for the yard.
        yard = new char[MAX_WIDTH + 2][MAX_HEIGHT + 2];
    }

    public void populateYard() {
        // populate the yard array.
        for (int j = 0; j < (height + 2); j++) {
            for (int i = 0; i < (width + 2); i++) {
                // draw borders at the edges of the lawn.
                //System.out.println(String.format("%3d, %3d", i, j));
                if (j == 0 || j == height + 1) {
                    // we're on the top or bottom border.
                    yard[i][j] = 'R';
                } else if (i == 0 || i == width + 1) {
                    // we're on the left or right border.
                    yard[i][j] = 'R';
                } else {
                    yard[i][j] = '+';
                }
            }
        }
    }

    public void printYard() {
        for (int j = 0; j < (height + 2); j++) {
            for (int i = 0; i < (width + 2); i++) {
                System.out.print(yard[i][j]);
            }
            System.out.println();
        }
    }

    public void initYard() {
        // set up a Scanner to get user input.
        Scanner input = new Scanner(System.in);

        // get the dimensions of the yard.
        System.out.print("Enter the width of the yard: ");
        width = input.nextInt();

        System.out.print("Enter the height of the yard: ");
        height = input.nextInt();
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    public static void main(String[] args) throws Exception, InterruptedException {
        // create an object using the App class.
        App myApp = new App();

        // initialize the yard (get dimensions from user).
        myApp.initYard();
        
        // populate yard.
        myApp.populateYard();

        while (true) {
            myApp.clearScreen();
            Thread.sleep(250);
            
            // print yard.
            myApp.printYard();

            Thread.sleep(2000);
    

        }

        

    }
}
