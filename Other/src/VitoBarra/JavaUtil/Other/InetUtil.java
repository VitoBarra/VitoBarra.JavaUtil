package VitoBarra.JavaUtil.Other;

public class InetUtil
{
    public static byte[] QuadToByte(String str)
    {
        var quad = str.split("\\.");
        if (quad.length != 4)
            throw new IllegalArgumentException("ip should be a x.x.x.x");

        byte[] bytes = new byte[4];

        for (int i = 0; i < 4; i++)
        {
            int a = Integer.parseInt(quad[i]);
            if (a > 255)
                throw new IllegalArgumentException("not a legal ip address");
            else
                bytes[i] = (byte)a;
        }
        return bytes;
    }
}
