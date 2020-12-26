import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ShapeFactory shapeFactory = new ShapeFactory();
        Scanner scan = new Scanner(System.in);
        String input = "";
        Shape shape = null;
        String shapeName = null;
        boolean cont = true;
        double area = 0;
        while (cont) {
            System.out.println("Please select a shape\n" + "[c: Circle | r: Rectangle | s: Square]");
            String choice = scan.next();
            shape = shapeFactory.create(choice);
            if (shape instanceof Circle) {
                System.out.println("Enter radius: ");
                double radius = scan.nextDouble();
                ((Circle) shape).setProperty(radius);
                area = ((Circle) shape).getArea();
                shapeName = "Circle";
                cont = false;
            } else if (shape instanceof Rectangle) {
                System.out.println("Enter width height (separated with one space): ");
                double width = scan.nextDouble();
                double length = scan.nextDouble();
                ((Rectangle) shape).setProperty(width, length);
                area = ((Rectangle) shape).getArea();
                shapeName = "Rectangle";
                cont = false;
            } else if (shape instanceof Square) {
                System.out.println("Enter length: ");
                double length = scan.nextDouble();
                ((Square) shape).setProperty(length);
                area = ((Square) shape).getArea();
                shapeName = "Square";
                cont = false;
            } else {
                System.out.println("Invalid input. Try again:");
            }
        }

        while (!input.equals("q")) {
            System.out.println("Please select for");
            System.out.println("[i : Shape Info | l : Add light (int) | clr : Add color(String) | cnt : Add contrast (int) | q : quit");
            input = scan.next();
            if (input.equalsIgnoreCase("i")) {
                System.out.println(shape.getDetails());
            } else if (input.equalsIgnoreCase("l")) {
                System.out.println("Enter light:");
                int value = scan.nextInt();
                shape = new Light(shape);
                ((Light) shape).setProperty(value);
            } else if (input.equalsIgnoreCase("clr")) {
                System.out.println("Enter color:");
                String value = scan.next();
                shape = new Color(shape);
                ((Color) shape).setProperty(value);
            } else if (input.equalsIgnoreCase("cnt")) {
                System.out.println("Enter contrast:");
                int value = scan.nextInt();
                shape = new Contrast(shape);
                ((Contrast) shape).setProperty(value);
            }
        }

        input = "";
        while (!input.equals("q")) {
            System.out.println("Please select the material of shape: ");
            System.out.println("[i : Shape Info | cu : Copper | fe : Iron | au : Gold | q : quit");
            input = scan.next();

            DecimalFormat df = new DecimalFormat("#.00", new DecimalFormatSymbols(Locale.US));
            if (input.equalsIgnoreCase("cu"))
                System.out.println("Mass for Copper " + shapeName + " = " + df.format(area * Materials.COPPER));
            else if (input.equalsIgnoreCase("fe"))
                System.out.println("Mass for Iron " + shapeName + " = " + df.format(area * Materials.IRON));
            else if (input.equalsIgnoreCase("au"))
                System.out.println("Mass for Gold " + shapeName + " = " + df.format(area * Materials.GOLD));
            else if (input.equalsIgnoreCase("i"))
                System.out.println(shape.getDetails());
            else if (input.equalsIgnoreCase("q")) {
                System.out.println("Goodbye!");
                System.exit(1);
            } else {
                System.out.println("Invalid input. Try again:");
                input = "continue";
            }
        }
    }
}