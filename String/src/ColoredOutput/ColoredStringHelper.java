package ColoredOutput;


public class ColoredStringHelper {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLACK = "\u001B[30m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_GRAY = "\u001B[37m";
    private static final String ANSI_DARK_GRAY = "\u001B[90m";
    private static final String ANSI_LIGHT_RED = "\u001B[91m";
    private static final String ANSI_LIGHT_GREEN = "\u001B[92m";
    private static final String ANSI_LIGHT_YELLOW = "\u001B[93m";
    private static final String ANSI_LIGHT_BLUE = "\u001B[94m";
    private static final String ANSI_LIGHT_PURPLE = "\u001B[95m";
    private static final String ANSI_LIGHT_CYAN = "\u001B[96m";
    private static final String ANSI_WHITE = "\u001B[97m";

    private static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    private static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    private static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    private static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    private static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    private static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    private static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    private static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";


    public static String ColorSelector(Color c) {
        return switch (c) {
            case Reset -> ANSI_RESET;
            case White -> ANSI_WHITE;
            case Gray -> ANSI_GRAY;
            case Black -> ANSI_BLACK;
            case Red -> ANSI_RED;
            case Green -> ANSI_GREEN;
            case Yellow -> ANSI_YELLOW;
            case Blue -> ANSI_BLUE;
            case Purple -> ANSI_PURPLE;
            case Cyan -> ANSI_CYAN;
            case DarkGray -> ANSI_DARK_GRAY;
            case LightRed -> ANSI_LIGHT_RED;
            case LightGreen -> ANSI_LIGHT_GREEN;
            case LightYellow -> ANSI_LIGHT_YELLOW;
            case LightBlue -> ANSI_LIGHT_BLUE;
            case LightPurple -> ANSI_LIGHT_PURPLE;
            case LightCyan -> ANSI_LIGHT_CYAN;
            case BlackBackground -> ANSI_BLACK_BACKGROUND;
            case RedBackground -> ANSI_RED_BACKGROUND;
            case GreenBackground -> ANSI_GREEN_BACKGROUND;
            case YellowBackground -> ANSI_YELLOW_BACKGROUND;
            case BlueBackground -> ANSI_BLUE_BACKGROUND;
            case PurpleBackground -> ANSI_PURPLE_BACKGROUND;
            case CyanBackground -> ANSI_CYAN_BACKGROUND;
            case WhiteBackground -> ANSI_WHITE_BACKGROUND;
        };
    }

    public static String TextInColor(String str, Color c) {
        return ColorSelector(c) + str + ColorSelector(Color.Reset);
    }

    public static String TextInColor(int value, Color c) {
        return TextInColor(Integer.toString(value), c);
    }


}

