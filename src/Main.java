public class Main {
    public static void main(String[] args) {
        Segment A = new Segment(new Point(0,0), new Point(100,50));
        Segment[] B = perpendicularSegment(A,A.getEnd());
        System.out.println(A.ToSvg());
        System.out.println(B[0].ToSvg());
        System.out.println(B[1].ToSvg());
    }

    public static Segment[] perpendicularSegment(Segment segment, Point point) {
        double deltaX = segment.getEnd().x-segment.getStart().x;
        double deltaY = segment.getEnd().y-segment.getStart().y;
        Point vectorNorm = new Point(-deltaY,deltaX);
        Segment[] segmentout = new Segment[2];
        segmentout[0] = new Segment(point, new Point(point.x-deltaY, point.y+deltaX));
        segmentout[1] = new Segment(point, new Point(point.x+deltaY, point.y-deltaX));
        return segmentout;
    }
}