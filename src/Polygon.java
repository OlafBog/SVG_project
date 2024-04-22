public class Polygon {
    private Point[] points;

    public Polygon(Point[] pointsArray) {
        points=pointsArray;
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

        svg.append("\" />");
        return svg.toString();
    }
}
