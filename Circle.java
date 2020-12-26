import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Circle implements Shape {

    private double radius;

    void setProperty(double radius) {
        this.radius = radius;
    }

    double getArea() {
        return Double.parseDouble(new DecimalFormat("#.00", new DecimalFormatSymbols(Locale.US)).format(radius * radius * Math.PI));
    }

    public String getDetails() {
        return "Circle... " + " Radius: " + radius + " Area: " + getArea() + " ";
    }
}