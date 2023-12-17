package builder;

class Outfit {
    private String top;
    private String bottom;
    private String footwear;
    private String accessories;

    private Outfit(OutfitBuilder builder) {
        this.top = builder.top;
        this.bottom = builder.bottom;
        this.footwear = builder.footwear;
        this.accessories = builder.accessories;
    }

    @Override
    public String toString() {
        return "Outfit{" +
                "top='" + top + '\'' +
                ", bottom='" + bottom + '\'' +
                ", footwear='" + footwear + '\'' +
                ", accessories='" + accessories + '\'' +
                '}';
    }

    public static class OutfitBuilder {
        private String top;
        private String bottom;
        private String footwear;
        private String accessories;

        public OutfitBuilder(String top, String bottom) {
            this.top = top;
            this.bottom = bottom;
        }

        public OutfitBuilder setFootwear(String footwear) {
            this.footwear = footwear;
            return this;
        }

        public OutfitBuilder setAccessories(String accessories) {
            this.accessories = accessories;
            return this;
        }

        public Outfit build() {
            return new Outfit(this);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Outfit outfit1 = new Outfit.OutfitBuilder("T-shirt", "Jeans")
                .setFootwear("Sneakers")
                .setAccessories("Watch")
                .build();

        Outfit outfit2 = new Outfit.OutfitBuilder("Blouse", "Skirt")
                .setFootwear("Heels")
                .build();
        System.out.println(outfit1.toString());
        System.out.println(outfit2.toString());
    }
}