package module;


class Coffee {
    private String type;
    private String size;
    private boolean milk;
    private boolean sugar;

    public Coffee(String type, String size, boolean milk, boolean sugar) {
        this.type = type;
        this.size = size;
        this.milk = milk;
        this.sugar = sugar;
    }


    public String getType() {
        return type;
    }

    public String getSize() {
        return size;
    }

    public boolean hasMilk() {
        return milk;
    }

    public boolean hasSugar() {
        return sugar;
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "type='" + type + '\'' +
                ", size='" + size + '\'' +
                ", milk=" + milk +
                ", sugar=" + sugar +
                '}';
    }
}


interface CoffeeBuilder {
    void setType(String type);

    void setSize(String size);

    void addMilk();

    void addSugar();

    Coffee build();
}

class CoffeeBarista implements CoffeeBuilder {
    private Coffee coffee;

    public CoffeeBarista() {
        this.coffee = new Coffee("Espresso", "Small", false, false);
    }

    @Override
    public void setType(String type) {
        coffee = new Coffee(type, coffee.getSize(), coffee.hasMilk(), coffee.hasSugar());
    }

    @Override
    public void setSize(String size) {
        coffee = new Coffee(coffee.getType(), size, coffee.hasMilk(), coffee.hasSugar());
    }

    @Override
    public void addMilk() {
        coffee = new Coffee(coffee.getType(), coffee.getSize(), true, coffee.hasSugar());
    }

    @Override
    public void addSugar() {
        coffee = new Coffee(coffee.getType(), coffee.getSize(), coffee.hasMilk(), true);
    }

    @Override
    public Coffee build() {
        return coffee;
    }
}

class CoffeeDirector {
    public Coffee makeCoffee(CoffeeBuilder builder) {
        builder.setType("Latte");
        builder.setSize("Large");
        builder.addMilk();
        builder.addSugar();
        return builder.build();
    }
}


public class Main {
    public static void main(String[] args) {
        CoffeeBuilder builder = new CoffeeBarista();
        CoffeeDirector director = new CoffeeDirector();

        Coffee customCoffee = director.makeCoffee(builder);
        System.out.println("Custom Coffee: " + customCoffee);
    }
}
