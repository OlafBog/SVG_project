public class SolidFillShapeDecorator extends ShapeDecorator{
    String color;
    public SolidFillShapeDecorator(Shape shape,String color) {
        super(shape);
        this.color=color;
    }
    public String ToSvg(String parameter) {
        return super.ToSvg(String.format("fill=\"%s\" %s ",color,parameter));
    }
}
