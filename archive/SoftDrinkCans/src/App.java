public class App {
    public static void main(String[] args) throws Exception {
        double x = 3.14;
        int y = (int) x;
        
        x = y;
        System.out.println("y = " + y);
        System.out.println("x = " + x);
    }
}
