package Week8;

public class Short80_Circle extends Short80_TwoDimensionalShape{
    private double radius;

    public Short80_Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
    
    
}
