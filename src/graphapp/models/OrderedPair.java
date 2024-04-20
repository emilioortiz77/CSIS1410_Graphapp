package graphapp.models;

public class OrderedPair {
    private int x;
    private int y;
    private String label;

    public OrderedPair(int x, int y, String label) {
        this.x = x;
        this.y = y;
        this.label = label;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return "OrderedPair{" +
                "x=" + x +
                ", y=" + y +
                ", label='" + label + '\'' +
                '}';
    }
}
