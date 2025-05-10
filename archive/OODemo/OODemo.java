class Bicycle {
    final int MAX_GEAR = 3;
    int gear = 1;
    double speed = 0.0;

    public int getGear() {
        return gear;
    }

    public double getSpeed() {
        return speed;
    }

    public void shiftUp() {
        // increase the gear if possible.
        if (gear < MAX_GEAR) {
            gear = gear + 1;
        }
    }

    public void shiftDown() {
        // decrease the gear if possible.
        if (gear > 1) {
            gear = gear - 1;
        }
    }

    public void pedal() {
        speed = speed + gear * 1;
    }

    public void brake() {
        if (speed > 1.0) {
            speed = speed - 1;
        }   
    }
}

public class OODemo {
    public static void main(String[] args) {
        // create an object using the Bicycle class.
        Bicycle bike = new Bicycle();

        // what's the initial state?
        System.out.printf("gear = %d, speed = %.2f%n", bike.getGear(), bike.getSpeed());

        // pedal a little.
        for(int i = 0; i < 3; i++) {
            System.out.println("Pedaling and shifting");
            bike.pedal();
            System.out.printf("gear = %d, speed = %.2f%n", bike.getGear(), bike.getSpeed());
            bike.shiftUp();
        }
    }
}
