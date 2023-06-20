import java.util.Scanner;
import java.util.Random;



public class App {
    static public final int DISPLAY_PERIOD = 250;
    
    public class Mower {
        public int x;
        public int y;
        public int dir; // 0 up, 1 right, 2, down, 3 left.

        Random random;
        char yard[][];

        public Mower(char yard[][]) {
            // arbitrary starting point and direction.
            // these will change if Mower is randomized.
            x = 1;
            y = 1;
            dir = 0;
            this.yard = yard;
            
            random = new Random();
        }

        public void randomize(int width, int height) {
            // height and width do not include the boundary that surrounds yard.

            // randomize position.
            int pos = random.nextInt(4);
            if (pos == 0) {
                // pace in upper lefthand corner.
                x = 1;
                y = 1;
            } else if (pos == 1) {
                // place in upper righthand corner.
                x = width;
                y = 1;
            } else if (pos == 2) {
                // place in lower righthand corner.
                x = width;
                y = height;
            } else {
                // place in lower lefthand corner.
                x = 1;
                y = height;
            }

            // randomize direction.
            this.dir = random.nextInt(4);
        }

        public char checkInFront() {
            // look in front of mower.
            switch (this.dir) {
                case 0:
                    // pointing up.
                    return yard[x][y - 1];
                case 1:
                    // pointing to the right.
                    return yard[x + 1][y];
                case 2:
                    // pointing down.
                    return yard[x][y + 1];
                case 3:
                default:
                    // pointing to the left.
                    return yard[x - 1][y];
            }
        }

        public void moveForward() {
            switch (this.dir) {
                case 0:
                    // pointing up.
                    y--;
                    break;
                case 1:
                    // pointing to the right.
                    x++;
                    break;
                case 2:
                    // pointing down.
                    y++;
                    break;
                case 3:
                default:
                    // pointing to the left.
                    x--;
                    break;
            }
        }

        public void turnRight() {
            dir++;
            if (dir > 3) {
                dir = 0;
            }
        }

        public void turnLeft() {
            dir--;
            if (dir < 0) {
                dir = 3;
            }
        }
    }

    static final int MAX_WIDTH = 100;
    static final int MAX_HEIGHT = 100;
    public int width;
    public int height;
    public char yard[][];
    public Mower mower;

    // constructor.
    public App() {
        // create an array to hold the characters for the yard.
        yard = new char[MAX_WIDTH + 2][MAX_HEIGHT + 2];
        mower = new Mower(yard);
    }

    public void populateYard() {
        // populate the yard array.
        for (int j = 0; j < (height + 2); j++) {
            for (int i = 0; i < (width + 2); i++) {
                // draw borders at the edges of the lawn.
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

    public void randomizeMower() {
        mower.randomize(this.width, this.height);
        cutGrass();
    }

    public void printYard() {
        for (int j = 0; j < (height + 2); j++) {
            for (int i = 0; i < (width + 2); i++) {
                if (mower.x == i && mower.y == j) {
                    if (mower.dir == 0) {
                        System.out.print("^");
                    } else if (mower.dir == 1) {
                        System.out.print(">");
                    } else if (mower.dir == 2) {
                        System.out.print("v");
                    } else {
                        System.out.print("<");
                    }
                } else {
                    System.out.print(yard[i][j]);
                }
                
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

    public void cutGrass() {
        yard[mower.x][mower.y] = ' ';
    }

    public boolean updateMower() {
        if (mower.checkInFront() == '+') {
            return true;
        } else {
            // turn to the right
            mower.turnRight();
            if (mower.checkInFront() == '+') {
                // more grass.
                return true;
            } else {
                // check to the left of original direction.
                mower.turnLeft();
                mower.turnLeft();
                if (mower.checkInFront() == '+') {
                    return true;
                } else {
                    // turn left one more time.
                    mower.turnLeft();
                    if (mower.checkInFront() == '+') {
                        return true;
                    } 
                }
            }
        }

        return false;
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

        // randomize lawn mower.
        myApp.randomizeMower();

        boolean keepLooping = true;
        while (keepLooping) {
            // clear screen.
            myApp.clearScreen();
           
            // print yard.
            myApp.printYard();

            // pause a moment.
            Thread.sleep(DISPLAY_PERIOD);

            // try and updat position of mower.
            keepLooping = myApp.updateMower();
            if (keepLooping) {
                myApp.mower.moveForward();
                myApp.cutGrass();
            }
        }

    }
}
