public class Polygon implements Shape {
    private Vec2[] vec2s;

    public Polygon(Vec2[] pointsArray) {
        //super(new Style("none","black",1.0));
        vec2s =pointsArray;
    }

    public Polygon(Vec2[] pointsArray, Style style) {
        //super(style);
        vec2s =pointsArray;
    }

    public Polygon(Polygon poly) {
        //super(new Style("none","black",1.0));
        this.vec2s = new Vec2[poly.vec2s.length];
        for (int i = 0; i < poly.vec2s.length; i++)
            this.vec2s[i] = new Vec2(poly.vec2s[i].x, poly.vec2s[i].y);
    }

    public String ToSvg(String parameter) {
        StringBuilder stringPoints = new StringBuilder();

        for (Vec2 vec2 : vec2s) {
            stringPoints.append(vec2.x);
            stringPoints.append(",");
            stringPoints.append(vec2.y);
            stringPoints.append(" ");
        }

        return String.format("<polygon points=\"%s\" %s />",stringPoints.toString(),parameter);
    }
}
