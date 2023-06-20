import java.util.Scanner;
import java.util.Random;

public class App {
    static public final int DISPLAY_PERIOD = 250;

    // set up a Scanner to get user input.
    Scanner input = new Scanner(System.in);

    enum CUTTING_MODE {
        SPIRAL,
        LINE_BY_LINE
    }

    enum TURN {
        LEFT,
        RIGHT
    }
    
    public class Mower {
        public int x;
        public int y;
        public int dir; // 0 up, 1 right, 2, down, 3 left.
        CUTTING_MODE cutMode;
        TURN lastTurn = TURN.LEFT;  // track what the last turn if doing line by line mowing.

        Random random;
        char yard[][];

        public Mower(char yard[][], CUTTING_MODE cutMode) {
            // arbitrary starting point and direction.
            // these will change if Mower is randomized.
            x = 1;
            y = 1;
            dir = 0;

            // reference to the yard .
            this.yard = yard;

            // set the cutMode.
            this.cutMode = cutMode;
            
            // create a random object that we 
            // can use to randomize the location of the mower.
            random = new Random();
        }

        public Mower(char yard[][]) {
            this(yard, CUTTING_MODE.SPIRAL);
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

    public void setCuttingMode() {
        System.out.print("Enter 1 for spiral cut, 2 for line-by-line cut: ");
        if(input.nextInt()== 2) {
            mower.cutMode = CUTTING_MODE.LINE_BY_LINE;
        } else {
            mower.cutMode = CUTTING_MODE.SPIRAL;
        }
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
        // get the dimensions of the yard.
        System.out.print("Enter the width of the yard: ");
        width = input.nextInt();

        System.out.print("Enter the height of the yard: ");
        height = input.nextInt();
    }

    public void cutGrass() {
        yard[mower.x][mower.y] = ' ';
    }

    public boolean updateMowerSpiral() {
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

    // if the user wants to cut row by row or column by column
    // then the update method has to check for uncut grass
    // and turn and move to the next row.
    public boolean updateMowerLine() {
        if (mower.checkInFront() == '+') {
            return true;
        } else {
            if (mower.lastTurn == TURN.LEFT) {
                // turn right and then check grass.
                mower.turnRight();
                if (mower.checkInFront() == '+') {
                    // move forward.
                    mower.moveForward();

                    // cut grass.
                    cutGrass();

                    // turn right one more time.
                    mower.turnRight();

                    // update last turn.
                    mower.lastTurn = TURN.RIGHT;

                    // check one more time.
                    if (mower.checkInFront() == '+') {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
                
            } else {
                // turn left and then check grass.
                mower.turnLeft();
                if (mower.checkInFront() == '+') {
                    // move forward.
                    mower.moveForward();

                    // cut grass.
                    cutGrass();

                    // turn left one more time.
                    mower.turnLeft();

                    // update last turn.
                    mower.lastTurn = TURN.LEFT;

                    // check one more time.
                    if (mower.checkInFront() == '+') {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
    }

    public boolean updateMower() {
        if (mower.cutMode == CUTTING_MODE.SPIRAL) {
            return updateMowerSpiral();
        } else if (mower.cutMode == CUTTING_MODE.LINE_BY_LINE) {
            return updateMowerLine();
        }
        
        return false;
    }

    public void initializeLastTurn() {
        // determine if last turn would have been LEFT or RIGHT.
        // look to the left.
        mower.turnLeft();
        if (mower.checkInFront() == '+') {
            // wall is to the right of the mower.  
            // set the last turn as left, so it will turn right
            // at the end of the current line.
            mower.lastTurn = TURN.RIGHT;
        } else {
            // wall should be on the left of the mower
            // since it was placed in a corner.
            // set the last turn as left, so it will turn left
            // at the end of the current line.
            mower.lastTurn = TURN.LEFT;
        }

        // turn back to mowing direction.
        mower.turnRight();;

    }

    // for the line by line mode, turn till it faces grass.
    // for spiral mode, we don't need to do anything.
    public void orientMower() {
        if (mower.cutMode == CUTTING_MODE.LINE_BY_LINE) {
            if (mower.checkInFront() != '+') {
                // if user wants to cut row by row or col by col,
                // turn until the mower is facing grass.
                while(mower.checkInFront() != '+') {
                    mower.turnRight();
                }
            }
            initializeLastTurn();
        }
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    public void setMowerPosition() {
        System.out.print("enter initial x val: ");
        mower.x = input.nextInt();

        System.out.print("enter initial y val: ");
        mower.y = input.nextInt();

        System.out.print("enter initial dir (0 to 3): ");
        mower.dir = input.nextInt();

        cutGrass();
    }

    public static void main(String[] args) throws Exception, InterruptedException {
        // create an object using the App class.
        App myApp = new App();

        // clear screen.
        myApp.clearScreen();

        // initialize the yard (get dimensions from user).
        myApp.initYard();
        
        // populate yard.
        myApp.populateYard();

        // randomize lawn mower.
        myApp.randomizeMower();
        
        // ask user what mode to use to cut the grass.
        myApp.setCuttingMode();

        // orient the mower, if needed, to point towards grass.
        myApp.orientMower();

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
