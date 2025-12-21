public class Chocolate {
    private String manufacturer;
    private int cubes;
    private int calories;
    private double price;

    public Chocolate(int cubes, int calories, double price, String manufacturer) {
        this.calories = calories;
        this.cubes = cubes;
        this.manufacturer = manufacturer;
        this.price = price;
    }

    public Chocolate(Chocolate other) {
        this.calories = other.calories;
        this.price = other.price;
        this.manufacturer = other.manufacturer;
        this.cubes = other.cubes;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getCubes() {
        return cubes;
    }

    public int getCalories() {
        return calories;
    }

    public double getPrice() {
        return price;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setCubes(int cubes) {
        this.cubes = cubes;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void newPrice(double price) {
        this.price = (price * 110) / 10;
    }

    public boolean isSameManufacturer(Chocolate other) {
        return this.manufacturer.equals(other.manufacturer);
    }

    @Override
    public String toString() {
        return "Chocolate{" +
                "manufacturer='" + manufacturer + '\'' +
                ", cubes=" + cubes +
                ", calories=" + calories +
                ", price=" + price +
                '}';
    }
}
