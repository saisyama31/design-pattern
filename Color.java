public class Color extends ShapeDecorator {

    private String color;
    private Shape shape;

    Color(Shape shape) {
        this.shape = shape;
    }

    void setProperty(String color) {
        this.color = color;
    }

    public String getDetails() {
        return shape.getDetails() + " Color: " + color;
    }
}