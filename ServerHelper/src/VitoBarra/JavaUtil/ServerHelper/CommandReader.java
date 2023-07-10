package VitoBarra.JavaUtil.ServerHelper;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public abstract class CommandReader
{
    protected NonBlockingLineReader Reader;
    protected PrintStream writer;
    public CommandReader(InputStream in, OutputStream out)
    {
        Reader = new NonBlockingLineReader(in);
        writer = new PrintStream(out);
        var CommandThread = new Thread(this::CommandMenu);
        CommandThread.setDaemon(true);
        CommandThread.start();
    }

    public abstract String getMenuString();
    public abstract boolean CommandHandler(String CommandString);

    public void CommandMenu()
    {
        writer.print(getMenuString());

        while(true) {
            String StringRead = Reader.TryRead();
            if(CommandHandler(StringRead))
                break;
        }
    }

}
