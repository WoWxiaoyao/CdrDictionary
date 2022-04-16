package wow.cdr.util;


public class PrintUtil
{
    public static void print(Object o)
    {
        if(o!=null)
        {
            System.out.print(color(o +"\n&o"));
        }
    }
    public static void printWord(Object o,Object c)
    {
        if(o!=null)
        {
            String msg = o.toString();
            if(msg.contains("{")&&(msg.contains("}")))
            {
                String word = msg.substring(msg.indexOf("{"),msg.lastIndexOf("}")+1);
                if(c!=null)
                {
                    //恢复原来的颜色
                    print(msg.replace(word,"&1&d"+word+"&o"+c));
                } else {
                    print(msg.replace(word,"&1&d"+word));
                }
            } else {
                print(o);
            }
        }
    }

    public static void printInfo(Object o)
    {
        if(o!=null)
        {
            print("[INFO] "+o);
        }
    }

    public static void printError(Object o)
    {
        if(o!=null)
        {
            print("&1[ERROR] "+o);
        }
    }

    public static void printError(Exception e,boolean full)
    {
        if(e!=null)
        {
            printError("程序运行中发生了一些错误:"+e.getMessage());
            if(full) e.printStackTrace();
        }
    }

    private static String color(String s)
    {
        if(s!=null)
        {
            /*
             * 字体属性   初始化 加粗 下划线 文字闪烁？ 镜像 隐藏
             * */
            s=s.replace("&o",colorFormat(0));
            s=s.replace("&l",colorFormat(1));
            s=s.replace("&d",colorFormat(4));
            s=s.replace("&b",colorFormat(5));
            s=s.replace("&m",colorFormat(7));
            s=s.replace("&h",colorFormat(8));
            /*
            * 字体颜色   黑 红 绿 黄 蓝 品红 青 白
            * */
            s=s.replace("&0",colorFormat(30));
            s=s.replace("&1",colorFormat(31));
            s=s.replace("&2",colorFormat(32));
            s=s.replace("&3",colorFormat(33));
            s=s.replace("&4",colorFormat(34));
            s=s.replace("&5",colorFormat(35));
            s=s.replace("&6",colorFormat(36));
            s=s.replace("&7",colorFormat(37));
            /*
             * 背景颜色   黑 红 绿 黄 蓝 品红 青 白
             * */
            s=s.replace("&b0",colorFormat(40));
            s=s.replace("&b1",colorFormat(41));
            s=s.replace("&b2",colorFormat(42));
            s=s.replace("&b3",colorFormat(43));
            s=s.replace("&b4",colorFormat(44));
            s=s.replace("&b5",colorFormat(45));
            s=s.replace("&b6",colorFormat(46));
            s=s.replace("&b7",colorFormat(47));
        }
        return s;
    }

    private static String colorFormat(int i)
    {
        return "\u001b["+i+"m";
    }
}
