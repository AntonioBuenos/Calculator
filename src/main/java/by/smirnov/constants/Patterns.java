package by.smirnov.constants;

public class Patterns {
    private Patterns() {
    }

    public static final String OPERATION = "(?<=[^{,+=*/-])[-+*/=]";
    public static final String SCALAR = "-?[0-9]+\\.?[0-9]*";
    public static final String VECTOR = "\\{" + SCALAR + "(," + SCALAR + ")*}";
    public static final String MATRIX = "\\{" + VECTOR + "(," + VECTOR + ")*}";
    public static final String IN_BRACES = "\\([{a-zA-Z0-9,.}]+[-+*/]+[{a-zA-Z0-9,.}]+\\)";
    public static final String BRACES = "[)(]";
    public static final String CURLY = "[}{]";
    public static final String DOUBLE_CURLY = "(\\{\\{|}})";
    public static final String MATRIX_INTER = "},\\{";
    public static final String SPACES = "\\s+";
    public static final String SUB = "-";
    public static final String ADD = "+";
    public static final String MUL = "*";
    public static final String DIV = "/";
    public static final String EQ = "=";
    public static final String DATE_PATTERN = "dd.MM.yyyy, HH:mm:ss";
    public static final String TIME_PATTERN = "            HH:mm:ss - ";
}

