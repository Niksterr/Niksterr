package fm;

interface Clothing {
    void display();
}

class TShirt implements Clothing {
    @Override
    public void display() {
        System.out.println("This is a T-shirt.");
    }
}

class Pants implements Clothing {
    @Override
    public void display() {
        System.out.println("These are pants.");
    }
}

class TShirtFactory implements ClothingFactory {
    @Override
    public Clothing createClothing() {
        return new TShirt();
    }
}

class PantsFactory implements ClothingFactory {
    @Override
    public Clothing createClothing() {
        return new Pants();
    }
}

interface ClothingFactory {
    Clothing createClothing();
}

public class Main {
    public static void main(String[] args) {
        ClothingFactory tShirtFactory = new TShirtFactory();
        ClothingFactory pantsFactory = new PantsFactory();

        Clothing tShirt = tShirtFactory.createClothing();
        tShirt.display();

        Clothing pants = pantsFactory.createClothing();
        pants.display();
    }
}