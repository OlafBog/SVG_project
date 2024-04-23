public class Polygon extends Shape {
    private Point[] points;

    public Polygon(Point[] pointsArray) {
        super(new Style("none","black",1.0));
        points=pointsArray;
    }

    public Polygon(Point[] pointsArray, Style style) {
        super(style);
        points=pointsArray;
    }

    public Polygon(Polygon poly) {
        super(new Style("none","black",1.0));
        this.points = new Point[poly.points.length];
        for (int i = 0; i < poly.points.length; i++)
            this.points[i] = new Point(poly.points[i].x, poly.points[i].y);
    }

    public String ToSvg() {
        StringBuilder svg = new StringBuilder("<polygon points=\"" + points[0].x + "," + points[0].y);

        for(int i=1;i< points.length;i++)
        {
            svg.append(" ");
            svg.append(points[i].x);
            svg.append(",");
            svg.append(points[i].y);
        }

        svg.append("\" ");

        svg.append(style.ToSvg());

        svg.append(" />");
        return svg.toString();
    }
}
