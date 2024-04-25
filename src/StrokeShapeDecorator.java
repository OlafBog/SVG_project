public class StrokeShapeDecorator extends ShapeDecorator{
    private String color;
    private double width;

    public StrokeShapeDecorator(Shape shape,String color, double width) {
        super(shape);
        this.color = color;
        this.width = width;
    }

    @Override
    public String ToSvg(String parameter) {
        return super.ToSvg(String.format("stroke=\"%s\" stroke-width=\"%f\" %s ",color,width,parameter));
    }
}
