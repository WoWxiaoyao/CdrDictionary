package wow.cdr.util;

import wow.cdr.Main;
import wow.cdr.cd.Word;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RunUtil
{
    public static void go()
    {
        Scanner scanner = new Scanner(System.in);
        String input;
        PrintUtil.print(" ");
        PrintUtil.printInfo("s为标准模式 - 适用与单词原型查询");
        PrintUtil.printInfo("m为混合模式 - 适用与高级查询(输入变形,中文,英句明显特征内容等)");
        PrintUtil.printInfo("nX-nX为定向语言,其中n为读取数量");
        PrintUtil.printInfo("&1友情提示: 输入部分带有词性,请在词性后空格(不建议,可能会导致查询失败)");
        PrintUtil.printInfo("          &13在输入标注关键词时需要添加{},建议添加增加准确率");
        PrintUtil.printInfo("          &1存在省略号与3个.可能混合使用的问题");
        PrintUtil.print(" ");
        while (true)
        {
            PrintUtil.print(" ");
            PrintUtil.print("[MENU]  1.查询词义(s-1英-1中)  2.查询单词(m-n中-1英)  3.查询语境词性词义与句子填空");
            PrintUtil.print("[MENU]  4.查询词组(m-X⇌X)  5.查询词组(s-1英-n英)    ");
            PrintUtil.print("[MENU]  0.完整词典(s-1英-1中) 99.查看内存  100.退出程序");
            //PrintUtil.print("[MENU]  90000.设置查重率("+ Main.Similarity +"%) 99999.查看内存  99250.退出程序");
            input = scanner.nextLine();
            if(input.equalsIgnoreCase("100")) break;

            String[] commands = input.split(" ");
            if (commands.length > 0)
            {
                if(PatternUtil.isInteger(commands[0]))
                {
                    switch (commands[0])
                    {
                        case "0": mode_0(commands[1]);break;
                        case "1": mode_1(commands[1]);break;
                        case "2": mode_2(input.replace("2 ",""));break;
                        case "3": mode_3(input.replace("3 ",""));break;
                        case "4": mode_4(input.replace("4 ",""));break;
                        case "5": mode_5(commands[1]);break;
                        //case "90000": mode_90000(commands[1]);break;
                        case "99": getMemory();break;
                    }
                } else {
                    //不输入序号则直接进行完整词典查询
                    mode_0(input);
                }
            } else {
                PrintUtil.printError("至少也得输入点什么吧.");
            }
        }
    }

   /* private static void mode_90000(String s)
    {
        if(PatternUtil.isDouble(s))
        {
            Main.Similarity = Double.parseDouble(s);

            PrintUtil.printInfo("设置成功,当前查重率设置为 "+Main.Similarity+"%");
        } else {
            PrintUtil.printError("你输入的不是double类型数字");
        }
    }*/

    //用于处理 1 word 模块
    private static void mode_5(String s)
    {
        s = s.toLowerCase();
        if(DataUtil.words.containsKey(s))
        {
            Word word = DataUtil.words.get(s);
            PrintUtil.print("&3[T] &2查询成功，系统处理中...");
            PrintUtil.print("&3========================================");
            PrintUtil.print("单词: &2"+word.getWord());
            PrintUtil.print(" 短语: ");
            for(String line:word.getWordUsage())
            {
                PrintUtil.printWord("  - &2&l"+line,"&2&l");
            }
            PrintUtil.print("&3========================================");
        } else {
            PrintUtil.print("&3[T] &1词库中没有该单词.");
        }
    }


    //用于处理 n word 模块
    private static void mode_4(String s)
    {
        boolean ok = false;
        //word mean info
        List<String> list = new ArrayList<>();
        int i = 0;

        for(String line:DataUtil.data_usage)
        {
            if(line.contains(s))
            {
                ok = true;
                i++;
                PrintUtil.print("&3[T] &2查询成功，系统处理中... &o("+i+")");
                list.add(line);
            }
        }

        if(ok)
        {
            PrintUtil.print("&3========================================");
            for(String line:list)
            {
                String[] ss = line.split("&&");
                if(ss.length==3)
                {
                    PrintUtil.print(" - 单词: &2"+ss[0]);
                    PrintUtil.print("    词义:&1 "+ss[1]);
                    PrintUtil.printWord("    词组:&7 "+ss[2],"&7");
                }
            }
            PrintUtil.print("&3========================================");
        } else {
            PrintUtil.print("&3[T] &1数据库无法查询到该信息.");
        }
    }

    //用于处理 n word 模块
    private static void mode_3(String s)
    {
        boolean ok = false;
        //word mean info
        List<String> list = new ArrayList<>();
        int i = 0;

        for(String line:DataUtil.data_sentence)
        {
            if(line.contains(s))
            {
                ok = true;
                i++;
                PrintUtil.print("&3[T] &2查询成功，系统处理中... &o("+i+")");
                list.add(line);
            }
        }

        if(ok)
        {
            PrintUtil.print("&3========================================");
            for(String line:list)
            {
                String[] ss = line.split("&&");
                if(ss.length==3)
                {
                    PrintUtil.print(" - 单词: &2"+ss[0]);
                    PrintUtil.print("    词义:&1 "+ss[1]);
                    PrintUtil.printWord("    句子:&7 "+ss[2],"&7");
                }
            }
            PrintUtil.print("&3========================================");
        } else {
            PrintUtil.print("&3[T] &1数据库无法查询到该信息.");
        }
    }

    //用于处理 n word 模块
    private static void mode_2(String s)
    {
        boolean ok = false;
        List<String> list = new ArrayList<>();
        int i = 0;
        for(Word word:DataUtil.words.values())
        {
            for(String line:word.getWordMeans())
            {
                if(line.contains(s))
                {
                    ok = true;
                    i++;
                    PrintUtil.print("&3[T] &2查询成功，系统处理中... &o("+i+")");
                    list.add(word.getWord()+"&&"+line);
                }
            }
        }

        if(ok)
        {
            PrintUtil.print("&3========================================");
            for(String line:list)
            {
                String[] ss = line.split("&&");
                if(ss.length==2)
                {
                    PrintUtil.print(" - 单词: &1&d"+ss[0]+"&o   &3"+ss[1]);
                }
            }
            PrintUtil.print("&3========================================");
        } else {
            PrintUtil.print("&3[T] &1数据库无法查询到该信息.");
        }
    }

    //用于处理 1 word 模块
    private static void mode_1(String s)
    {
        s = s.toLowerCase();
        if(DataUtil.words.containsKey(s))
        {
            Word word = DataUtil.words.get(s);
            PrintUtil.print("&3[T] &2查询成功，系统处理中...");
            PrintUtil.print("&3========================================");
            PrintUtil.print("单词: &2"+word.getWord());
            PrintUtil.print("词义: ");
            for(String line:word.getWordMeans())
            {
                PrintUtil.print(" - &2&l"+line);
            }
            PrintUtil.print("&3========================================");
        } else {
            PrintUtil.print("&3[T] &1词库中没有该单词.");
        }
    }
    //用于处理 1 word 模块
    private static void mode_0(String s)
    {
        s = s.toLowerCase();
        if(DataUtil.words.containsKey(s))
        {
            Word word = DataUtil.words.get(s);
            PrintUtil.print("&3[T] &2查询成功，系统处理中...");
            PrintUtil.print("&3========================================");
            PrintUtil.print("单词: &2"+word.getWord());
            PrintUtil.print(" 词义: ");
            for(String line:word.getWordMeans())
            {
                PrintUtil.print("  - &2&l"+line);
            }
            PrintUtil.print(" 短语: ");
            for(String line:word.getWordUsage())
            {
                PrintUtil.printWord("  - &2&l"+line,"&2&l");
            }
            PrintUtil.print(" 句子: ");
            for(String line:word.getWordSentence())
            {
                PrintUtil.printWord("  - &2&l"+line,"&2&l");
            }
            PrintUtil.print("&3========================================");
        } else {
            PrintUtil.print("&3[T] &1词库中没有该单词.");
        }
    }

    private static void getMemory()
    {
        PrintUtil.print("&1Ram: &o"+PluginUtil.freeMemory()+"/"+PluginUtil.totalMemory()+"/"+PluginUtil.maxMemory());
    }
}
