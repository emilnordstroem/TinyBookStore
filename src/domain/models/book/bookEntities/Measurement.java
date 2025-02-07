package domain.models.book.bookEntities;

public class Measurement {
    private int height;
    private int width;
    private int weight;

    public Measurement(int height, int width, int weight) {
        this.height = height;
        this.width = width;
        this.weight = weight;
    }

    public double getArea(){
        return height * weight;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getWeight() {
        return weight;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
