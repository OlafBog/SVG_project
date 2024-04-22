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
        return "<line x1=\""+start.x+"\" y1=\""+start.y+"\" x2=\""+end.x+"\" y2=\""+end.y+"\" >";
    }
}
