package shapes;

public abstract class Shape {
    private Double perimeter;
    private  Double area;

    public Double getPerimeter() {
        return perimeter;
    }

    public Double getArea() {
        return area;
    }

    protected abstract Double calculatePerimeter();
    protected abstract Double calculateArea();
}