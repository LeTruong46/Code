package Week8;

public class Short80_ShapeTest {
     public static void main(String[] args) {
        Short80_Shape[] shapes = {
            new Short80_Circle(5),
            new Short80_Square(4),
            new Short80_Triangle(3, 6),
            new Short80_Sphere(3),
            new Short80_Cube(2),
            new Short80_Tetrahedron(4)
        };

        for (Short80_Shape shape : shapes) {
            System.out.println(shape.getClass().getSimpleName() + ":");
            System.out.println(" - Area: " + String.format("%.2f", shape.getArea()));
            if (shape instanceof Short80_ThreeDimensionalShape) {
                System.out.println(" - Volume: " + String.format("%.2f", ((Short80_ThreeDimensionalShape) shape).getVolume()));
            }
            System.out.println();
        }
    }
}
