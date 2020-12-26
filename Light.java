public class Light extends ShapeDecorator {

    private int light;
    private Shape shape;

    Light(Shape shape) {
        this.shape = shape;
    }

    void setProperty(int light) {
        this.light = light;
    }

    public String getDetails() {
        return shape.getDetails() + " Light: " + light;
    }
}