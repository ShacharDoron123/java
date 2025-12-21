import java.util.Random;

public class Pizza {
    private String name;
    private String size;
    private double basePrice;
    private double[] additions;

    public Pizza(String name, String size, double basePrice, double[] additions) {
        this.name = name;
        this.size = size;
        this.basePrice = basePrice;
        this.additions = additions;
    }

    public double calculateTotalPrice() {
        double total = basePrice;
        for (double addition : additions) {
            total += addition;
        }
        return total;
    }

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public double[] getAdditions() {
        return additions;
    }

    public void printDetails() {
        System.out.println("Pizza name: " + name);
        System.out.println("Size: " + size);
        System.out.println("Base price: " + basePrice);
        System.out.println("Additions: ");
        for (double add : additions) {
            System.out.println("  + " + add);
        }
        System.out.println("Total price: " + calculateTotalPrice());
    }

    public static void main(String[] args) {
        Pizza[] orders = new Pizza[100];
        Random rand = new Random();

        String[] sizes = {"small", "medium", "large", "ex"};
        String[] names = {"Margherita", "Pepperoni", "Mushroom", "Cheese"};

        for (int i = 0; i < orders.length; i++) {
            String name = names[rand.nextInt(names.length)];
            String size = sizes[rand.nextInt(sizes.length)];
            double basePrice = 20 + rand.nextInt(20);
            int addCount = rand.nextInt(4);
            double[] adds = new double[addCount];
            for (int j = 0; j < addCount; j++) {
                adds[j] = 5 + rand.nextInt(6);
            }
            orders[i] = new Pizza(name, size, basePrice, adds);
        }

        double total = 0;
        for (Pizza p : orders) {
            total += p.calculateTotalPrice();
        }

        System.out.println("Total cost of 100 pizzas: " + total);
    }
}


