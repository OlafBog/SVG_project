public class GradientFillShapeDecorator extends ShapeDecorator{

    private static int index;
    private Stop stop;
    public class Stop {
        public double offset;
        public String color;
    }
    public GradientFillShapeDecorator(Shape shape) {
        super(shape);
    }

    public String addGradient() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<defs>");
        stringBuilder.append(String.format("\"\\t<linearGradient id=\\\"g%d\\\" >\\n\"", index));
        stringBuilder.append(String.format("\\t\\t<stop offset=\\\"%f\\\" style=\\\"stop-color:%s\\\" />\\n\"", stop.offset, stop.color));
        stringBuilder.append("\t</linearGradient>");
        stringBuilder.append("<defs/>");
        return stringBuilder.toString();
    }
}
