import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Segment {
    private Point start;
    private Point end;

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    public Segment(Point startPoint,Point endPoint) {
        start = startPoint;
        end = endPoint;
    }

    public double length() {
        return sqrt(pow(start.x - end.x,2) + pow(start.y - end.y,2));
    }

    public String ToSvg() {
        return "<line x1=\""+start.x+"\" y1=\""+start.y+"\" x2=\""+end.x+"\" y2=\""+end.y+"\" />";
    }

    public static Segment[] perpendicularSegment(Segment segment, Point point) {
        Point delta = new Point(segment.getEnd().x-segment.getStart().x, segment.getEnd().y-segment.getStart().y);
        Segment[] segmentOut = new Segment[2];
        segmentOut[0] = new Segment(point, new Point(point.x-delta.y, point.y+delta.x));
        segmentOut[1] = new Segment(point, new Point(point.x+delta.y, point.y-delta.x));
        return segmentOut;
    }
    public static Segment[] perpendicularSegment(Segment segment, Point point,double lenghtOfSegment) {
        Point vec = new Point(segment.getEnd().x-segment.getStart().x, segment.getEnd().y-segment.getStart().y);

        double scale = lenghtOfSegment / segment.length();
        Point vecNor = new Point(vec.x*scale,vec.y*scale);
        Segment newSegment = new Segment(segment.getStart(),new Point(segment.getStart().x+vecNor.x,segment.getStart().y+vecNor.y));
        Point delta = new Point(newSegment.getEnd().x-newSegment.getStart().x, newSegment.getEnd().y-newSegment.getStart().y);
        Segment[] segmentOut = new Segment[2];
        segmentOut[0] = new Segment(point, new Point(point.x-delta.y, point.y+delta.x));
        segmentOut[1] = new Segment(point, new Point(point.x+delta.y, point.y-delta.x));
        return segmentOut;
    }
}
