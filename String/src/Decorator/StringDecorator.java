package Decorator;

public class StringDecorator implements StringComponent {
    StringComponent String;

    public StringDecorator(StringComponent _string) {
        String = _string;
    }

    @Override
    public String Composit() {
        return String.Composit();
    }
}
