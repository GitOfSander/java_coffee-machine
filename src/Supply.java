public class Supply {
    private int cash = 550;

    private int mlOfWater = 400;

    private int mlOfMilk = 540;

    private int gramsOfCoffeeBeans = 120;

    private int disposableCups = 9;

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash += cash;
    }

    public int getMlOfWater() {
        return mlOfWater;
    }

    public void setMlOfWater(int mlOfWater) {
        this.mlOfWater += mlOfWater;
    }

    public int getMlOfMilk() {
        return mlOfMilk;
    }

    public void setMlOfMilk(int mlOfMilk) {
        this.mlOfMilk += mlOfMilk;
    }

    public int getGramsOfCoffeeBeans() {
        return gramsOfCoffeeBeans;
    }

    public void setGramsOfCoffeeBeans(int gramsOfCoffeeBeans) {
        this.gramsOfCoffeeBeans += gramsOfCoffeeBeans;
    }

    public int getDisposableCups() {
        return disposableCups;
    }

    public void setDisposableCups(int disposableCups) {
        this.disposableCups += disposableCups;
    }

    public void printSupply() {
        System.out.printf("\nThe coffee machine has:\n" +
                        "%s ml of water\n" +
                        "%s ml of milk\n" +
                        "%s g of coffee beans\n" +
                        "%s disposable cups\n" +
                        "$%s of money\n",
                        getMlOfWater(), getMlOfMilk(),
                        getGramsOfCoffeeBeans(), getDisposableCups(),
                        getCash());
    }

    public void adjustSupply(int sellingPrice, int mlOfWater, int mlOfMilk, int gramsOfCoffeeBeans, int disposableCups) {
        setCash(sellingPrice);
        setMlOfWater(mlOfWater);
        setMlOfMilk(mlOfMilk);
        setGramsOfCoffeeBeans(gramsOfCoffeeBeans);
        setDisposableCups(disposableCups);
    }
}
