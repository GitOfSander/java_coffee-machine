public class CoffeeMachine {
    private static Supply supply;

    private Functions functions;

    private State state = State.MAIN;

    private String input = "";

    CoffeeMachine() {
        supply = new Supply();
        functions = new Functions(supply);
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public boolean isWorking() {
        return state != State.EXIT;
    }

    public void printLabel() {
        switch (state) {
            case MAIN -> System.out.println("Write action (buy, fill, take, remaining, exit):");
            case COFFEE_SELECTION -> System.out.println("What do you want to buy?\n" +
                                                        "1 - espresso\n" +
                                                        "2 - latte\n" +
                                                        "3 - cappuccino\n" +
                                                        "back - to the main menu");
            case FILL_WATER -> System.out.println("Write how many ml of water you want to add:");
            case FILL_MILK -> System.out.println("Write how many ml of milk you want to add:");
            case FILL_BEANS -> System.out.println("Write how many grams of coffee beans you want to add:");
            case FILL_CUPS -> System.out.println("Write how many disposable cups you want to add:");
        }
    }

    public void handler(String input) {
        this.input = input;

        switch (state) {
            case MAIN:
                selectAction();

                break;
            case COFFEE_SELECTION:
                selectCoffeeOption(input);

                break;
            case FILL_WATER:
                functions.fill(getState(), input);
                setState(State.FILL_MILK);

                break;
            case FILL_MILK:
                functions.fill(getState(), input);
                setState(State.FILL_BEANS);

                break;
            case FILL_BEANS:
                functions.fill(getState(), input);
                setState(State.FILL_CUPS);

                break;
            case FILL_CUPS:
                functions.fill(getState(), input);
                setState(State.MAIN);

                break;
        }
    }

    private void selectAction() {
        try {
            switch (Option.valueOf(input.toUpperCase())) {
                case BUY:
                    setState(State.COFFEE_SELECTION);

                    break;
                case FILL:
                    setState(State.FILL_WATER);

                    break;
                case TAKE:
                    functions.take();
                    setState(State.MAIN);

                    break;
                case REMAINING:
                    supply.printSupply();
                    setState(State.MAIN);

                    break;
                case EXIT:
                    setState(State.EXIT);

                    break;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("\nOption does not exist!\n");
        }
    }

    private void selectCoffeeOption(String input) {
        if (input.equals("back")) {
            setState(State.MAIN);

            return;
        }

        try {
            CoffeeType ct = CoffeeType.valueOf(Integer.parseInt(input));
            functions.serve(ct);

            setState(State.MAIN);
        } catch (IllegalArgumentException e) {
            System.out.println("\nOption does not exist!\n");
        }
    }
}