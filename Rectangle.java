import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Rectangle implements Shape {

    private double width;
    private double length;

    void setProperty(double width, double length) {
        this.width = width;
        this.length = length;
    }

    double getArea() {
        return Double.parseDouble(new DecimalFormat("#.00", new DecimalFormatSymbols(Locale.US)).format(width * length));
    }

    public String getDetails() {
        return "Rectangle... " + " Width: " + width + " Length: " + length + " Area: " + getArea() + " ";
    }
}