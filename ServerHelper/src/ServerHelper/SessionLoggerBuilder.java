package ServerHelper;

import java.io.InputStream;
import java.io.OutputStream;

public class SessionLoggerBuilder {
    private OutputStream out;
    private InputStream in;
    private int defspace;
    private char defchar;

    public SessionLoggerBuilder setOut(OutputStream out) {
        this.out = out;
        return this;
    }

    public SessionLoggerBuilder setIn(InputStream in) {
        this.in = in;
        return this;
    }

    public SessionLoggerBuilder setDefspace(int defspace) {
        this.defspace = defspace;
        return this;
    }

    public SessionLoggerBuilder setDefchar(char defchar) {
        this.defchar = defchar;
        return this;
    }

    public SessionLogger createSessionLogger() {
        return new SessionLogger(in, out);
    }
}