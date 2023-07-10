package Decorator;

public class StringWrapper implements StringComponent {
    String String;

    public StringWrapper(int i)
    {
        String = String.valueOf(i);
    }
    public StringWrapper(String str)
    {
        String = str;
    }

    @Override
    public String Composit() {
        return String;
    }
}
