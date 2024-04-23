import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Segment {
    private Vec2 start;
    private Vec2 end;

    public Vec2 getStart() {
        return start;
    }

    public Vec2 getEnd() {
        return end;
    }

    public Segment(Vec2 startVec2, Vec2 endVec2) {
        start = startVec2;
        end = endVec2;
    }

    public double length() {
        return sqrt(pow(start.x - end.x,2) + pow(start.y - end.y,2));
    }

    public String ToSvg() {
        return "<line x1=\""+start.x+"\" y1=\""+start.y+"\" x2=\""+end.x+"\" y2=\""+end.y+"\" />";
    }

    public static Segment[] perpendicularSegment(Segment segment, Vec2 vec2) {
        Vec2 delta = new Vec2(segment.getEnd().x-segment.getStart().x, segment.getEnd().y-segment.getStart().y);
        Segment[] segmentOut = new Segment[2];
        segmentOut[0] = new Segment(vec2, new Vec2(vec2.x-delta.y, vec2.y+delta.x));
        segmentOut[1] = new Segment(vec2, new Vec2(vec2.x+delta.y, vec2.y-delta.x));
        return segmentOut;
    }
    public static Segment[] perpendicularSegment(Segment segment, Vec2 vec2, double lenghtOfSegment) {
        Vec2 vec = new Vec2(segment.getEnd().x-segment.getStart().x, segment.getEnd().y-segment.getStart().y);

        double scale = lenghtOfSegment / segment.length();
        Vec2 vecNor = new Vec2(vec.x*scale,vec.y*scale);
        Segment newSegment = new Segment(segment.getStart(),new Vec2(segment.getStart().x+vecNor.x,segment.getStart().y+vecNor.y));
        Vec2 delta = new Vec2(newSegment.getEnd().x-newSegment.getStart().x, newSegment.getEnd().y-newSegment.getStart().y);
        Segment[] segmentOut = new Segment[2];
        segmentOut[0] = new Segment(vec2, new Vec2(vec2.x-delta.y, vec2.y+delta.x));
        segmentOut[1] = new Segment(vec2, new Vec2(vec2.x+delta.y, vec2.y-delta.x));
        return segmentOut;
    }
}
