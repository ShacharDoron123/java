public class Bag {
    private int pencils;
    private int markers;

    public Bag(int pencils, int markers) {
        this.markers = markers;
        this.pencils = pencils;
    }

    public int getMarkers() {
        return markers;
    }

    public int getPencils() {
        return pencils;
    }

    public void setMarkers(int markers) {
        this.markers = markers;
    }

    public void setPencils(int pencils) {
        this.pencils = pencils;
    }

    public void addPencils(int pencils) {
        this.pencils++;
    }

    public void addMarkers(int markers) {
        this.markers++;
    }

    public void removeMarkers(int markers) {
        this.markers--;
    }

    public void removePencils(int pencils) {
        this.pencils--;
    }

    @Override
    public String toString() {
        return "Bag{" +
                "pencils=" + pencils +
                ", markers=" + markers +
                '}';
    }
}
