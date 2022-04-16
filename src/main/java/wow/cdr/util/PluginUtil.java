package wow.cdr.util;

import wow.cdr.Main;

public class PluginUtil
{
    public static void start()
    {
        PrintUtil.print(" ");
        PrintUtil.print("[INFO] 欢迎使用干翻词达人系统 v"+ Main.version);
        PrintUtil.print("[INFO] 初始化中... ...");
        if(!FileUtil.initialize()) return;
        DataUtil.initialize();
        RunUtil.go();
        PrintUtil.print("[INFO] 程序结束，欢迎下次光临~");
        PrintUtil.print(" ");
    }

    public static long useMemory()
    {
        return totalMemory() - freeMemory();
    }

    public static long totalMemory()
    {
        return Runtime.getRuntime().totalMemory()/1024/1024;
    }
    public static long freeMemory()
    {
        return Runtime.getRuntime().freeMemory()/1024/1024;
    }

    public static long maxMemory()
    {
        return Runtime.getRuntime().maxMemory()/1024/1024;
    }
}
