public class SolidFilledPolygon extends Polygon {
    private String color;

    public SolidFilledPolygon(String color, Vec2[] vec2s) {
        super(vec2s);
        this.color=color;
    }

    public String ToSvg(String parameter) {
        return super.ToSvg(String.format("fill=\"%s\" %s ",color,parameter));
    }
}
