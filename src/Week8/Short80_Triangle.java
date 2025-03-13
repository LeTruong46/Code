package Week8;

public class Short80_Triangle extends Short80_TwoDimensionalShape{
    private double sideA , sideB;

    public Short80_Triangle(double sideA, double sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }

    @Override
    public double getArea() {
        return 0.5 * sideA * sideB;
    }
    
}
