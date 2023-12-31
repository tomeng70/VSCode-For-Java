interface Bicycle {
    public int getGear();
    public double getSpeed();

    public void shiftUp();
    public void shiftDown();

    public void pedal();
    public void brake();
}

class FixedGearBicycle implements Bicycle { 
    int gear = 1;
    double speed = 0.0;
    
    public int getGear() {
        return gear;
    }

    public double getSpeed() {
        return speed;
    }

    public void shiftUp() {
        // do nothing - it's a single speed bicycle.
    }

    public void shiftDown() {
        // do nothing - it's a single speed bicycle.
    }

    public void pedal() {
        speed = speed + 1;
    }

    public void brake() {
        if (speed > 1.0) {
            speed = speed - 1;
        }
    }
}

public class InterfaceDemo {
    public static void main(String[] args) {
        // create an object using the Bicycle class.
        FixedGearBicycle bike = new FixedGearBicycle();

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
