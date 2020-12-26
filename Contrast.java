public class Contrast extends ShapeDecorator {

    private int contrast;
    private Shape shape;

    Contrast(Shape shape) {
        this.shape = shape;
    }

    void setProperty(int contrast) {
        this.contrast = contrast;
    }

    public String getDetails() {
        return shape.getDetails() + " Contrast: " + contrast;
    }
}