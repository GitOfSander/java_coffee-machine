import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeMachine coffeeMachine = new CoffeeMachine();

        while(coffeeMachine.isWorking()) {
            coffeeMachine.printLabel();
            coffeeMachine.handler(scanner.next());

            System.out.println();
        }

        scanner.close();
    }
}