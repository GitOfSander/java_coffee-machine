import java.util.stream.IntStream;

public class Functions {
    private static Supply supply;

    Functions(Supply supply) {
        this.supply = supply;
    }

    public void fill(State state, String input) {
        int amount = input == null ? 0 : Integer.parseInt(input);

        switch (state) {
            case FILL_WATER -> supply.setMlOfWater(amount);
            case FILL_MILK -> supply.setMlOfMilk(amount);
            case FILL_BEANS -> supply.setGramsOfCoffeeBeans(amount);
            case FILL_CUPS -> supply.setDisposableCups(amount);
        }
    }

    public void take() {
        int cash = supply.getCash();
        supply.setCash(-cash);

        System.out.println("\nI gave you $" + cash);
    }

    public void serve(CoffeeType ct) {
        if (enoughSupply(ct)) {
            System.out.println("\nI have enough resources, making you a coffee!");
            supply.adjustSupply(ct.getSellingPrice(), -ct.getMlOfWater(), -ct.getMlOfMilk(), -ct.getGramsOfCoffeeBeans(), -1);
        } else {
            System.out.println("\nSorry, not enough supply");
        }
    }

    public static boolean enoughSupply(CoffeeType ct) {
        int max = calculateMaxCoffee(ct);

        if (max >= 1) {
            return true;
        } else {
            return false;
        }
    }

    public static int calculateMaxCoffee(CoffeeType ct) {
        try {
            int max = 0;

            if (ct.getMlOfMilk() == 0) {
                max = IntStream.of(supply.getMlOfWater() / ct.getMlOfWater(),
                                supply.getGramsOfCoffeeBeans() / ct.getGramsOfCoffeeBeans(),
                                supply.getDisposableCups())
                                .min().getAsInt();
            } else {
                max = IntStream.of(supply.getMlOfWater() / ct.getMlOfWater(),
                                supply.getMlOfMilk() / ct.getMlOfMilk(),
                                supply.getGramsOfCoffeeBeans() / ct.getGramsOfCoffeeBeans(),
                                supply.getDisposableCups())
                                .min().getAsInt();
            }

            return max;

        } catch (ArithmeticException e) {
            System.out.println(e);

            return 0;
        }
    }
}
