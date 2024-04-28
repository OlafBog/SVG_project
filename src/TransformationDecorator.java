import java.util.Locale;

public class TransformationDecorator extends ShapeDecorator {
    private boolean translate; private Vec2 translateVector;
    private boolean rotate; private double rotateAngle; private Vec2 rotateCenter;
    private boolean scale; private Vec2 scaleVector;
    public Builder builder;

    public class Builder {
        private boolean translate = false; private Vec2 translateVector;
        private boolean rotate = false; private double rotateAngle; private Vec2 rotateCenter;
        private boolean scale = false; private Vec2 scaleVector;
        Shape shape;
        public Builder TransformTranslate(Vec2 translateVector) {
            this.translate=true;
            this.translateVector=translateVector;
            Builder B =new Builder(shape);
            B.translate=true;
            B.translateVector=translateVector;
            return B;
        }
        public Builder TransformRotate(double rotateAngle, Vec2 rotateCenter) {
            this.rotate=true;
            this.rotateAngle=rotateAngle;
            this.rotateCenter=rotateCenter;
            Builder B =new Builder(shape);
            B.rotate=true;
            B.rotateAngle=rotateAngle;
            B.rotateCenter=rotateCenter;
            return B;
        }
        public Builder TransformScale(Vec2 scaleVector) {
            this.scale=true;
            this.scaleVector=scaleVector;
            Builder B =new Builder(shape);
            B.scale=true;
            B.scaleVector=scaleVector;
            return B;
        }
        public TransformationDecorator build() {
            TransformationDecorator out = new TransformationDecorator(shape);
            out.translate=this.translate;
            out.rotate=this.rotate;
            out.scale=this.scale;
            out.translateVector=this.translateVector;
            out.rotateAngle=this.rotateAngle;
            out.rotateCenter=this.rotateCenter;
            out.scaleVector=this.scaleVector;
            return out;
        }
        public Builder(Shape shape) {
            this.shape=shape;
        }
    }

    public TransformationDecorator(Shape shape) {
        super(shape);
        this.builder=new Builder(shape);
    }
    @Override
    public String ToSvg(String parameter) {
        StringBuilder transform = new StringBuilder();
        Locale.setDefault(Locale.ENGLISH);//aby liczby poniżej wyświetlały się z kropką, a nie z przecinkiem pomiędzy
        if(translate) transform.append(String.format("translate(%f, %f) ", translateVector.x, translateVector.y));
        if(rotate) transform.append(String.format("rotate(%f %f %f) ", rotateAngle, rotateCenter.x, rotateCenter.y));
        if(scale) transform.append(String.format("scale(%f, %f) ", scaleVector.x, scaleVector.y));
        return super.ToSvg(String.format("transform=\"%s\" %s", transform.toString(), parameter));
    }
}