package prototype;

import java.util.ArrayList;
import java.util.List;

interface ClothingItem {
    void display();
}


class Shirt implements ClothingItem {
    private String size;
    private String color;

    public Shirt(String size, String color) {
        this.size = size;
        this.color = color;
    }

    @Override
    public void display() {
        System.out.println("Shirt - Size: " + size + ", Color: " + color);
    }
}

class Pants implements ClothingItem {
    private String size;
    private String style;

    public Pants(String size, String style) {
        this.size = size;
        this.style = style;
    }

    @Override
    public void display() {
        System.out.println("Pants - Size: " + size + ", Style: " + style);
    }
}

interface ClothingFactory {
    ClothingItem createClothingItem();
}

class ShirtFactory implements ClothingFactory {
    @Override
    public ClothingItem createClothingItem() {
        // In a real application, you might get user input or other logic to create the item
        return new Shirt("M", "Blue");
    }
}

class PantsFactory implements ClothingFactory {
    @Override
    public ClothingItem createClothingItem() {
        return new Pants("L", "Casual");
    }
}

class ClothingShop {
    public static void main(String[] args) {
        List<ClothingItem> clothingItems = new ArrayList<>();

        ClothingFactory shirtFactory = new ShirtFactory();
        ClothingItem shirt = shirtFactory.createClothingItem();
        clothingItems.add(shirt);

        ClothingFactory pantsFactory = new PantsFactory();
        ClothingItem pants = pantsFactory.createClothingItem();
        clothingItems.add(pants);

        for (ClothingItem item : clothingItems) {
            item.display();
        }
    }
}