package VitoBarra.JavaUtil.ColoredOutput;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class ColoredWriter extends PrintWriter
{
    public ColoredWriter(OutputStream out)
    {
        this(out, true);
    }
    public ColoredWriter(OutputStream out,boolean AutoFlush)
    {
        super(out, AutoFlush, StandardCharsets.UTF_8);
    }

    public void print(String s, Color c){super.print(ColoredStringHelper.TextInColor(s, c));}
    public void println(String s, Color c)
    {
        super.println(ColoredStringHelper.TextInColor(s, c));
    }

    public void SwitchColor(Color c)
    {
        super.print(ColoredStringHelper.ColorSelector(c));
    }

    public void Clear()
    {
        super.println("\033[H\033[2J");
        super.flush();
    }

}
