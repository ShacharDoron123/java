public class Menu {

    private String name;
    private Dish[] arr;

    public Menu(String name, Dish[] arr) {
        this.name = name;
        this.arr = new Dish[arr.length];
        for (int i=0; i < this.arr.length; i++) {
            this.arr[i] = new Dish(arr[i]);
        }
    }

    public void print(String str) {
        boolean e;
        for (int i=0; i < this.arr.length; i++) {
            e = false;
            for (int j = 0; j < this.arr[i].getList().length; j++) {
                if (this.arr[i].getList()[j].equals(str)) {
                    e = true;
                }
            }
            if (!e)
                System.out.println(this.arr[i].getCode());
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dish[] getArr() {
        return arr;
    }

    public void setArr(Dish[] arr) {
        this.arr = new Dish[arr.length];
        for (int i=0; i < this.arr.length; i++) {
            this.arr[i] = new Dish(arr[i]);
        }
    }
}
