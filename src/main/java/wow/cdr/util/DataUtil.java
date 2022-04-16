package wow.cdr.util;


import wow.cdr.cd.Word;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataUtil
{
    public static HashMap<String, Word> words = new HashMap<>();

    //全部单词的词组与句子存储
    //用于扫描对比
    public static List<String> data_usage = new ArrayList<>();
    public static List<String> data_sentence = new ArrayList<>();

    public static HashMap<String,List<String>> data_json = new HashMap<>();

    public static void initialize()
    {
        try
        {
            long l = System.currentTimeMillis();

            for(Word word:words.values())
            {
                data_usage.addAll(word.getWordMeanUsage());
                data_sentence.addAll(word.getWordMeanSentence());
            }
            PrintUtil.print("[INFO] 共加载 "+(data_usage.size()+data_sentence.size())+" 条数据("+(System.currentTimeMillis()-l)+"ms).");
        } catch (Exception e)
        {
            PrintUtil.printError(e,true);
        }
    }

}
