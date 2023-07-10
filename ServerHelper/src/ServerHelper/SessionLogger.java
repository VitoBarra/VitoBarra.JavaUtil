package ServerHelper;

import ColoredOutput.Color;
import ColoredOutput.ColoredWriter;
import IO.ConsoleInput;
import String.StringUtil;

import java.io.*;

public class SessionLogger implements Closeable {

    protected ColoredWriter Writer;
    protected BufferedReader Reader;

    int DefaultSpace = 62;
    char DefaultChar = ' ';

    public SessionLogger(InputStream in, OutputStream out) {
        Writer = new ColoredWriter(out, true);
        Reader = new BufferedReader(new InputStreamReader(in));
    }

    public SessionLogger(InputStream in, OutputStream out, int defspace, char defchar) {
        this(in, out);
        DefaultSpace = defspace;
        DefaultChar = defchar;
    }


    public String Prompt(String s) {
        return ConsoleInput.Prompt(Reader, Writer, s);
    }

    public String ReadLine() throws IOException {
        return Reader.readLine();
    }

    public void Sendln(String s, Color c) {
        Writer.println(s, c);
    }

    public void Sendln(String s) {
        Writer.println(s);
    }
    public void Sendln()
    {
        Writer.println("");
    }

    public void Send(String s, Color c) {
        Writer.print(s, c);
    }

    public void Send(String s) {
        Writer.print(s);
        Writer.flush();
    }

    @Override
    public void close() throws IOException {
        Reader.close();
        Writer.close();
    }

    protected String CenteredString(String s, int space, char ch) {
        return StringUtil.center(s, space, ch);
    }

    public void SendCenteredln(String s, int space, char ch) {
        Sendln(CenteredString(s, space, ch));
    }

    public void SendCenteredln(String s, int space, char ch, Color c) {
        Sendln(CenteredString(s, space, ch), c);
    }

    public void SendCentered(String s, int space, char ch) {
        Send(CenteredString(s, space, ch));
    }

    public void SendCentered(String s, int space, char ch, Color c) {
        Send(CenteredString(s, space, ch), c);
    }

    public void SendCenteredln(String s) {
        Sendln(CenteredString(s));
    }

    public void SendCenteredln(String s, Color c) {
        Sendln(CenteredString(s), c);
    }

    public void SendCentered(String s) {
        Send(CenteredString(s));
    }

    public void SendCentered(String s, Color c) {
        Send(CenteredString(s), c);
    }

    private String CenteredString(String s) {
        return CenteredString(s, DefaultSpace, DefaultChar);
    }

    public void ClearScreen()
    {
        Writer.Clear();
    }

}
