import java.util.HashMap;
import java.util.Map;

public enum CoffeeType {
    ESPRESSO(1, "Espresso", 4, 250, 0, 16),
    LATTE(2, "Latte", 7, 350, 75, 20),
    CAPPUCCINO(3, "Cappuccino", 6, 200, 100, 12);

    private final int coffeeId;

    private final String coffeeName;

    private final int sellingPrice;

    private final int mlOfWater;

    private final int mlOfMilk;

    private final int gramsOfCoffeeBeans;

    private static Map map = new HashMap<>();

    CoffeeType(int coffeeId, String coffeeName, int sellingPrice, int mlOfWater, int mlOfMilk, int gramsOfCoffeeBeans) {
        this.coffeeId = coffeeId;
        this.coffeeName = coffeeName;
        this.sellingPrice = sellingPrice;
        this.mlOfWater = mlOfWater;
        this.mlOfMilk = mlOfMilk;
        this.gramsOfCoffeeBeans = gramsOfCoffeeBeans;
    }

    static {
        for (CoffeeType coffeeType : CoffeeType.values()) {
            map.put(coffeeType.coffeeId, coffeeType);
        }
    }

    public static CoffeeType valueOf(int coffeeId) {
        return (CoffeeType) map.get(coffeeId);
    }

    public int getCoffeeId() {
        return coffeeId;
    }

    public String getCoffeeName() {
        return coffeeName;
    }

    public int getSellingPrice() {
        return sellingPrice;
    }

    public int getMlOfWater() {
        return mlOfWater;
    }

    public int getMlOfMilk() {
        return mlOfMilk;
    }

    public int getGramsOfCoffeeBeans() {
        return gramsOfCoffeeBeans;
    }
}
