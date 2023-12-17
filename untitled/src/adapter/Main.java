package adapter;

interface ClothingItem {
    String getName();
    double getPrice();
}

class LegacyClothingItem {
    private String itemName;
    private double itemCost;

    public LegacyClothingItem(String itemName, double itemCost) {
        this.itemName = itemName;
        this.itemCost = itemCost;
    }

    public String getItemName() {
        return itemName;
    }

    public double getItemCost() {
        return itemCost;
    }
}

class LegacyClothingItemAdapter implements ClothingItem {
    private LegacyClothingItem legacyItem;

    public LegacyClothingItemAdapter(LegacyClothingItem legacyItem) {
        this.legacyItem = legacyItem;
    }

    @Override
    public String getName() {
        return legacyItem.getItemName();
    }

    @Override
    public double getPrice() {
        return legacyItem.getItemCost();
    }
}


public class Main {
    public static void main(String[] args) {
        LegacyClothingItem legacyItem = new LegacyClothingItem("Shirt", 29.99);

        ClothingItem adaptedItem = new LegacyClothingItemAdapter(legacyItem);

        System.out.println("Name: " + adaptedItem.getName());
        System.out.println("Price: $" + adaptedItem.getPrice());
    }
}