public class Main {
    public static void main(String[] args) {
        Segment sA = new Segment(new Point(0,0), new Point(100,50));
        Segment[] sB = Segment.perpendicularSegment(sA,sA.getEnd());
        System.out.println(sA.ToSvg());
        System.out.println(sB[0].ToSvg());
        System.out.println(sB[1].ToSvg());
        System.out.println();

        Polygon pA = new Polygon(new Point[] {new Point(0, 0), new Point(50, 50), new Point(50, 30)});
        System.out.println(pA.ToSvg());

        Polygon pB = new Polygon(pA);
        System.out.println(pB.ToSvg());

        Polygon pC = new Polygon(new Point[] {new Point(100, 100), new Point(160, 100), new Point(100, 160)},new Style("grey","blue",5.0));
        System.out.println(pC.ToSvg());

        Polygon pD = sqare(new Segment(new Point(100,0),new Point(140,60)),new Style("none","red",5.0));

        SvgScene scene = new SvgScene();
        scene.addToScene(pA);
        scene.addToScene(pC);
        scene.addToScene(pD);
        scene.save("tu");
    }

    public static Polygon sqare(Segment segment, Style style) {
        Point s = new Point((segment.getStart().x+segment.getEnd().x)/2,(segment.getStart().y+segment.getEnd().y)/2);
        Segment v = new Segment(segment.getStart(),s);
        Segment[] x = Segment.perpendicularSegment(v,s);
        return new Polygon(new Point[] {segment.getStart(), x[0].getEnd(), segment.getEnd(), x[1].getEnd()},style);
    }
}