package Week8;

public class Short80_Sphere extends Short80_ThreeDimensionalShape{
    private double radius;
    
    public Short80_Sphere(double radius){
        this.radius = radius;
    }
    
    @Override
    public double getArea() {
        return 4 * Math.PI * radius * radius;
    }

    @Override
    public double getVolume() {
        return (4.0/3) * Math.PI * Math.pow(radius, 3);
    }
    
}
