public class Ellipse implements Shape {
    private Vec2 center;
    private double rx, ry;

    public Ellipse(Vec2 center, double rx, double ry) {
        //super(new Style("none","black",1.0));
        this.center=center;
        this.rx =rx;
        this.ry =ry;
    }
    public Ellipse(Vec2 center, double r) {
        //super(new Style("none","black",1.0));
        this.center=center;
        rx =r;
        ry =r;
    }
    public Ellipse(Vec2 center, double rx, double ry, Style style) {
        //super(style);
        this.center=center;
        this.rx =rx;
        this.ry =ry;
    }
    public Ellipse(Vec2 center, double r, Style style) {
        //super(style);
        this.center=center;
        rx =r;
        ry =r;
    }
    public String ToSvg(String parameter) {
        return "<ellipse cx=\""+center.x+"\" cy=\""+center.y+"\" "+ "rx=\""+rx+"\" ry=\""+ry+"\" "+parameter+" />";
    }
}
