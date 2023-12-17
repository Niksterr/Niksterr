package singletone;

public class Main {
    private static Main instance;

    private Main() {
    }

    public static Main getInstance() {
        if (instance == null) {
            instance = new Main();
        }
        return instance;
    }


    public void displayProducts() {
        System.out.println("Displaying clothing products...");
    }
}
class Test{
    public static void main(String[] args) {
        Main store1 = Main.getInstance();
        Main store2 = Main.getInstance();

        System.out.println("Are store1 and store2 the same instance? " + (store1 == store2));

        store1.displayProducts();
    }
}