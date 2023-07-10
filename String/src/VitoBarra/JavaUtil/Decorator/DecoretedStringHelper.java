package VitoBarra.JavaUtil.Decorator;

import VitoBarra.JavaUtil.ColoredOutput.Color;

public class DecoretedStringHelper {
    public static String ColoredAndCentered(int i, Color c, int space) {
        return ColoredAndCentered(String.valueOf(i), c, space);
    }

    public static String ColoredAndCentered(String str, Color color, int space) {
        StringComponent s1 = new StringWrapper(str);
        s1 = new StringCenterDecorator(s1, space);
        s1 = new StringColorDecoretor(s1, color);
        return s1.Composit();
    }
}
