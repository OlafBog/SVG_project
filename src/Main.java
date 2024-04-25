public class Main {
    public static void main(String[] args) {
        Segment sA = new Segment(new Vec2(0,0), new Vec2(100,50));
        Segment[] sB = Segment.perpendicularSegment(sA,sA.getEnd());
        System.out.println(sA.ToSvg());
        System.out.println(sB[0].ToSvg());
        System.out.println(sB[1].ToSvg());
        System.out.println();

        Polygon pA = new Polygon(new Vec2[] {new Vec2(0, 0), new Vec2(50, 50), new Vec2(50, 30)});
        System.out.println(pA.ToSvg(""));

        Polygon pB = new Polygon(pA);
        System.out.println(pB.ToSvg(""));

        Polygon pC = new Polygon(new Vec2[] {new Vec2(100, 100), new Vec2(160, 100), new Vec2(100, 160)},new Style("grey","blue",5.0));
        System.out.println(pC.ToSvg(""));

        Polygon pD = sqare(new Segment(new Vec2(100,0),new Vec2(140,60)),new Style("none","red",5.0));

        Segment sC = new Segment(new Vec2(0,0),new Vec2(100,100));
        Segment[] sD = Segment.perpendicularSegment(sC,new Vec2(110,110),50.0);
        System.out.println(sD[0].ToSvg());
        System.out.println(sD[1].ToSvg());
        System.out.println();

        Ellipse eA = new Ellipse(new Vec2(50,150),50);
        Ellipse eB = new Ellipse(new Vec2(50,250),25,45);

        SolidFilledPolygon sfpA = new SolidFilledPolygon("green",new Vec2[]{new Vec2(220,10),new Vec2(280,40),new Vec2(230,80)});
        System.out.println(sfpA.ToSvg(""));

        SvgScene scene = new SvgScene();
        scene.addToScene(pA);
        scene.addToScene(pC);
        scene.addToScene(pD);
        scene.addToScene(eA);
        scene.addToScene(eB);
        scene.save("tu");
    }

    public static Polygon sqare(Segment segment, Style style) {
        Vec2 s = new Vec2((segment.getStart().x+segment.getEnd().x)/2,(segment.getStart().y+segment.getEnd().y)/2);
        Segment v = new Segment(segment.getStart(),s);
        Segment[] x = Segment.perpendicularSegment(v,s);
        return new Polygon(new Vec2[] {segment.getStart(), x[0].getEnd(), segment.getEnd(), x[1].getEnd()},style);
    }
}