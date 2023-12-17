package af;

interface Clothing {
    String getDescription();
}

class Shirt implements Clothing {
    @Override
    public String getDescription() {
        return "This is a shirt.";
    }
}

class Pants implements Clothing {
    @Override
    public String getDescription() {
        return "These are pants.";
    }
}

interface ClothingFactory {
    Clothing createTop();

    Clothing createBottom();
}

class CasualClothingFactory implements ClothingFactory {
    @Override
    public Clothing createTop() {
        return new Shirt();
    }

    @Override
    public Clothing createBottom() {
        return new Pants();
    }
}

class FormalClothingFactory implements ClothingFactory {
    @Override
    public Clothing createTop() {
        return new Shirt();
    }

    @Override
    public Clothing createBottom() {
        return new Pants();
    }
}

class ClothingShop {
    private ClothingFactory factory;

    public ClothingShop(ClothingFactory factory) {
        this.factory = factory;
    }

    public Clothing orderTop() {
        return factory.createTop();
    }

    public Clothing orderBottom() {
        return factory.createBottom();
    }
}

public class Main {
    public static void main(String[] args) {
        ClothingFactory casualFactory = new CasualClothingFactory();
        ClothingFactory formalFactory = new FormalClothingFactory();

        ClothingShop casualShop = new ClothingShop(casualFactory);
        ClothingShop formalShop = new ClothingShop(formalFactory);

        Clothing casualTop = casualShop.orderTop();
        Clothing casualBottom = casualShop.orderBottom();

        Clothing formalTop = formalShop.orderTop();
        Clothing formalBottom = formalShop.orderBottom();

        System.out.println("Casual Outfit:");
        System.out.println(casualTop.getDescription());
        System.out.println(casualBottom.getDescription());

        System.out.println("\nFormal Outfit:");
        System.out.println(formalTop.getDescription());
        System.out.println(formalBottom.getDescription());
    }
}