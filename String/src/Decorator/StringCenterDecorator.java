package Decorator;

import String.StringUtil;

public class StringCenterDecorator extends StringDecorator {

    int Dim;

    public StringCenterDecorator(StringComponent _string, int dim) {
        super(_string);
        Dim = dim;
    }

    @Override
    public String Composit() {
         return StringUtil.center(String.Composit(), Dim);
    }
}
