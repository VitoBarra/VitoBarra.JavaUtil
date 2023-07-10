package ServerHelper;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BufferSessionLogger extends SessionLogger {

    private char[] buffer;

    public BufferSessionLogger(InputStream in, OutputStream out, int nkb) {
        super(in, out);
        buffer = new char[1024 * nkb];
    }

    public String BufferedRead() throws IOException {
        var filledBuffer = bufferedRead(buffer);
        return filledBuffer == null ? null : new String(filledBuffer);
    }


    private char[] bufferedRead(char[] Buffer) throws IOException {
        int c = Reader.read(Buffer);
        if (c == -1) return null;
        var RightSizeBuffer = new char[c];
        System.arraycopy(Buffer, 0, RightSizeBuffer, 0, c);
        return RightSizeBuffer;
    }


}
