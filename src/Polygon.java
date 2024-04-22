public class Polygon {
    private Point[] points;
    Style style;

    public Polygon(Point[] pointsArray) {
        points=pointsArray;
        this.style= new Style("none","black",1.0);
    }

    public Polygon(Point[] pointsArray, Style style) {
        points=pointsArray;
        this.style=style;
    }

    public Polygon(Polygon poly) {
        this.points = new Point[poly.points.length];
        for (int i = 0; i < poly.points.length; i++)
            this.points[i] = new Point(poly.points[i].x, poly.points[i].y);
        this.style= new Style("none","black",1.0);
    }

    public String ToSvg() {
        //<polygon points="100,10 150,190 50,190" style="fill:lime;stroke:purple;stroke-width:3" />
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
