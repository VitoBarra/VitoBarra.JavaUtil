package Time;

public class TimeUtil
{
    public static String TimeConverter(long milliseconds)
    {
        long E, M, D, H, Min, Sec = 0;

        long tem = milliseconds / (long) 1_000_000_000;
        Sec = tem % 60;
        tem = tem / 60;

        Min = tem % 60;
        tem = tem/60;

        H = tem ;
        return H+"h:"+Min+"min:"+Sec+"s";
    }
}
