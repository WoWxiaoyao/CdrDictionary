package wow.cdr.util;

import com.sun.istack.internal.NotNull;

import java.util.regex.Pattern;

public class PatternUtil
{
    public static boolean isSatisfy(@NotNull String s, @NotNull String regex)
    {
        return Pattern.compile(regex).matcher(s).matches();
    }

    public static boolean isDouble(@NotNull String s)
    {
        if(isInteger(s))
        {
            return true;
        } else return isSatisfy(s, "[0-9]+[.]?[0-9]*[dD]?");
    }

    public static boolean isInteger(@NotNull String s)
    {
        if((s==null)||(s.equals(""))) return false;
        return isSatisfy(s,"[0-9]*");
    }
}
