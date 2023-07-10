package VitoBarra.JavaUtil.Data;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class DataUtil
{
    public static <T extends IDataWithID> int FindMaxId(List<T> List)
    {
        if(List == null) return 0;
        var e = List.stream().max(Comparator.comparingInt(IDataWithID::getID)).orElse(null);
        return e == null ? 0 : e.getID();
    }

    public static  <T>  void CountOccurrence(Map<T, Integer> CountDic, T o, int IncrementValue)
    {
        var p = CountDic.putIfAbsent(o, IncrementValue);
        if (p != null)
            CountDic.put(o, p + IncrementValue);
    }
}
