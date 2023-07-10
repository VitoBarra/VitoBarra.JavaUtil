package Decorator;

import ColoredOutput.Color;
import ColoredOutput.ColoredStringHelper;

public class StringColorDecoretor extends StringDecorator {


    Color Color;

    public StringColorDecoretor(StringComponent _string, Color _color) {
        super(_string);
        Color = _color;
    }

    @Override
    public String Composit() {
        return ColoredStringHelper.TextInColor(String.Composit(), Color);
    }
}
