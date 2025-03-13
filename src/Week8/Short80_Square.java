package Week8;

public class Short80_Square extends Short80_TwoDimensionalShape{
    private double side;

    public Short80_Square(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return side * side;
    }

    
}
