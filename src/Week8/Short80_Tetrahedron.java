package Week8;

public class Short80_Tetrahedron extends Short80_ThreeDimensionalShape{
    private double edge;

    public Short80_Tetrahedron(double edge) {
        this.edge = edge;
    }

    @Override
    public double getArea() {
        return Math.sqrt(3) * edge * edge;
    }

    @Override
    public double getVolume() {
        return (1.0/12) * Math.sqrt(2) * Math.pow(edge, 3);
    }
    
}
