public class Ellipse extends Shape {
    private Point center;
    private double rx, ry;

    public Ellipse(Point center,double rx,double ry) {
        super(new Style("none","black",1.0));
        this.center=center;
        this.rx =rx;
        this.ry =ry;
    }
    public Ellipse(Point center,double r) {
        super(new Style("none","black",1.0));
        this.center=center;
        rx =r;
        ry =r;
    }
    public Ellipse(Point center,double rx,double ry, Style style) {
        super(style);
        this.center=center;
        this.rx =rx;
        this.ry =ry;
    }
    public Ellipse(Point center,double r,Style style) {
        super(style);
        this.center=center;
        rx =r;
        ry =r;
    }
    public String ToSvg() {
        //<ellipse cx="120" cy="80" rx="100" ry="50" style="fill:yellow;stroke:green;stroke-width:3" />
        return "<ellipse cx=\""+center.x+"\" cy=\""+center.y+"\" "+ "rx=\""+rx+"\" ry=\""+ry+"\" "+style.ToSvg()+" />";
    }
}
