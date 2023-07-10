package ServerHelper;

import java.io.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class NonBlockingLineReader implements Closeable
{
    private static final String EOC = "\n";
    private BlockingQueue<String> lines;
    private boolean closed = false;


    public NonBlockingLineReader(InputStream in)
    {
        this(in,0);
    }
    public NonBlockingLineReader(InputStream in, int n)
    {
        this(new InputStreamReader(in),n);
    }
    private NonBlockingLineReader(Reader reader, int n)
    {
        var ReaderThread = new Thread(() -> LineReaderWorker(reader));
        ReaderThread.setDaemon(true);
        ReaderThread.start();

        if (n == 0)
            lines = new LinkedBlockingQueue<>();
        else
            lines = new ArrayBlockingQueue<>(n);
    }

    private void LineReaderWorker(Reader reader)
    {
        var br = new BufferedReader(reader);
        try
        {
            while (!Thread.interrupted())
            {
                String line = br.readLine();
                if (line == null || closed)
                    break;
                lines.add(line);
            }
        } catch (IOException ignored)
        {
        } finally
        {
            close();
        }
    }


    public String poll()
    {
        if (closed) return null;
        String line = lines.poll();
        if (line != null && line.equals(EOC)) lines.add(EOC);
        return line;
    }

    public String TryRead()
    {
        if (closed) return null;
        String line;

        try
        {
            line = lines.take();
        } catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }

        if (line.equals(EOC)) lines.add(EOC);

        return line;
    }

    public void Flush()
    {
        if (closed) return;
        lines.clear();
    }

    @Override
    public void close()
    {
        if (closed) return;
        closed = true;
        lines.add(EOC);
    }
}
