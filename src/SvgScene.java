import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SvgScene {
    private static SvgScene svgScene = null;
    private ArrayList<Shape> shapeList = new ArrayList<>();

    public SvgScene() {
    }

    public static SvgScene getInstance() {
        if (svgScene == null) {
            svgScene = new SvgScene();
        }
        return svgScene;
    }

    public void addToScene(Shape shape) {
        shapeList.add(shape);
    }

    public void save(String path) {
        StringBuilder svg = new StringBuilder();
        svg.append("<!DOCTYPE html>\n");
        svg.append("<html>\n");
        svg.append("<head>\n");
        svg.append("<title>Canvas</title>\n");
        svg.append("</head>\n");
        svg.append("<body>\n");
        svg.append("<svg width=\"1000\" height=\"1000\">\n");

        for (Shape shape : shapeList) {
            svg.append(shape.ToSvg(""));
            svg.append("\n");
        }

        svg.append("</svg>\n");
        svg.append("</body>\n");
        svg.append("</html>");

        try {
            File file = new File(path+"canvas.html");
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(svg.toString());
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
