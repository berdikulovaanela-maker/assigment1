public class Rectangle {
    private double width;
    private double height;
    private int id;
    private static int idGen = 1;
    public Rectangle() {
        this.width = 1.0;
        this.height = 1.0;
        this.id = idGen++;
    }
    public Rectangle(double width, double height) {
        this();
        setWidth(width);
        setHeight(height);
    }
    public double GetWidth() {
        return width;
    }
    public void setWidth(double width) {
        if(width <= 0) throw new IllegalArgumentException();
        this.width = width;
    }
    public double GetHeight() {
        return height;
    }
    public void setHeight(double height) {
        if(height <= 0) throw new  IllegalArgumentException();
        this.height = height;
    }
    public double area(){
        return this.width * this.height;
    }
    public double perimeter(){
        return (this.width + this.height)*2;
    }
    public String toString(){
        return "Rectangle [width=" + width + ", height=" + height + ", id=" + id + "]";
    }
}
