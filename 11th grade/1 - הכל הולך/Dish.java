import java.util.Arrays;

public class Dish {
    private int code;
    private String name;
    private String[] list;

    public Dish(int code, String name, String[] list) {
        this.code = code;
        this.name = name;
        this.list = new String[list.length];
        for (int i = 0; i < list.length; i++) {
            this.list[i] = list[i];
        }
    }

    public Dish(Dish other) {
        this.code = other.code;
        this.name = other.name;
        this.list = new String[other.list.length];
        for (int i = 0; i < other.list.length; i++) {
            this.list[i] = other.list[i];
        }
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String[] getList() {
        String[] copy = new String[list.length];
        for (int i = 0; i < list.length; i++) {
            copy[i] = list[i];
        }
        return copy;
    }


    public void setCode(int code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setList(String[] list) {
        this.list = new String[list.length];
        for (int i = 0; i < list.length; i++) {
            this.list[i] = list[i];
        }
    }

    public String toString() {
        return "Dish{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", list=" + Arrays.toString(list) +
                '}';
    }
}