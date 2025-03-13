package Week8;

public class Short80_Cube extends Short80_ThreeDimensionalShape{
    private double side;

    public Short80_Cube(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return 6 * side * side;
    }

    @Override
    public double getVolume() {
        return Math.pow(side, 3);
    }
    
}
