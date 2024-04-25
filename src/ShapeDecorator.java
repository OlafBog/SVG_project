public class ShapeDecorator implements Shape{

    protected Shape decoratedShape;

    public ShapeDecorator(Shape shape) {
        this.decoratedShape = shape;
    }
    @Override
    public String ToSvg(String parameter) {
        return decoratedShape.ToSvg(parameter);
    }
}
