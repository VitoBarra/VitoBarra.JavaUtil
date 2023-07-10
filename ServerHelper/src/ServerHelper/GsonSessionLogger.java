package ServerHelper;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class GsonSessionLogger extends SessionLogger
{
    private Gson JW = new Gson();
    public GsonSessionLogger(InputStream in, OutputStream out) {
        super(in, out);
    }

    protected <T> T ReceiveJson(TypeToken<T> Type) throws IOException {

        var JsonRequest = JW.fromJson(ReadLine(), Type.getType());
        if (JsonRequest == null)
            throw new IOException();
        return (T)JsonRequest;
    }

    protected  <T> void SendJson(T e) {
        Sendln(JW.toJson(e));
    }
}
