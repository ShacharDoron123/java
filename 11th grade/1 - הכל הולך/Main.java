public class Main {
    public static void main(String[] args) {
        String [] arr = {"lettuce", "carrot", "cucumber"};

        Dish d1 = new Dish(123, "salad", arr);

        arr[0] = "tomato";
        arr[1] = "pepper";

        Dish d2 = new Dish(456, "veggie mix", arr);

        Dish[] dishes = new Dish[2];
        dishes[0] = d1;
        dishes[1] = d2;

        Menu m = new Menu("Hakol Holech", dishes);

        m.print("carrot");
    }
}
