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

    public String ToSvg() {
        StringBuilder svg = new StringBuilder("<polygon points=\"" + vec2s[0].x + "," + vec2s[0].y);

        for(int i = 1; i< vec2s.length; i++)
        {
            svg.append(" ");
            svg.append(vec2s[i].x);
            svg.append(",");
            svg.append(vec2s[i].y);
        }

        svg.append("\" ");

        //svg.append(style.ToSvg());

        svg.append(" />");
        return svg.toString();
    }
}
