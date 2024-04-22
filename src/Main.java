public class Main {
    public static void main(String[] args) {
        Segment sA = new Segment(new Point(0,0), new Point(100,50));
        Segment[] sB = sA.perpendicularSegment(sA,sA.getEnd());
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

        SvgScene scene = new SvgScene();
        scene.addToScene(pA);
        scene.addToScene(pC);
        scene.save("Pobrane");
    }
}