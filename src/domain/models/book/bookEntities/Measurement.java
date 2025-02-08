package domain.models.book.bookEntities;

public class Measurement {
    private final double height;
    private final double width;
    private final double weight;

    public Measurement(double height, double width, double weight) {
        this.height = height;
        this.width = width;
        this.weight = weight;
    }

    public double getArea(){
        return height * weight;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public double getWeight() {
        return weight;
    }

}
