public class DropShapeDecorator extends ShapeDecorator{

    private static int index;
    public DropShapeDecorator(Shape shape,int index) {
        super(shape);
        this.index=index;
    }

    public String AddFilter() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<defs>");
        stringBuilder.append(String.format("\\t<filter id=\\\"f%d\\\" x=\\\"-100%%\\\" y=\\\"-100%%\\\" width=\\\"300%%\\\" height=\\\"300%%\\\">\\n\" +\n" +
                "\"\\t\\t<feOffset result=\\\"offOut\\\" in=\\\"SourceAlpha\\\" dx=\\\"5\\\" dy=\\\"5\\\" />\\n\" +\n" +
                "\"\\t\\t<feGaussianBlur result=\\\"blurOut\\\" in=\\\"offOut\\\" stdDeviation=\\\"5\\\" />\\n\" +\n" +
                "\"\\t\\t<feBlend in=\\\"SourceGraphic\\\" in2=\\\"blurOut\\\" mode=\\\"normal\\\" />\\n\" +\n" +
                "\"\\t</filter>\"",index));
        stringBuilder.append("<defs/>");
        return stringBuilder.toString();
    }

    public String ToSvg(String parameter) {
        return super.ToSvg(String.format("filter=\"url(#f%d)\" ",index)+parameter);
    }
}
