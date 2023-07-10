package VitoBarra.JavaUtil.Decorator;

import VitoBarra.JavaUtil.ColoredOutput.Color;
import VitoBarra.JavaUtil.ColoredOutput.ColoredStringHelper;

public class StringColorDecoretor extends StringDecorator {


    VitoBarra.JavaUtil.ColoredOutput.Color Color;

    public StringColorDecoretor(StringComponent _string, Color _color) {
        super(_string);
        Color = _color;
    }

    @Override
    public String Composit() {
        return ColoredStringHelper.TextInColor(String.Composit(), Color);
    }
}
