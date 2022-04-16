package wow.cdr.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import wow.cdr.cd.Word;

import java.util.ArrayList;
import java.util.List;

public class JsonUtil
{

  /*
  * v1.0.1test code
  * 尝试将多个database进行统一储存管理，利用相似度进行判断，实操后发现效果并不如原版
    public static void transJson(String file,String s)
    {
        if (s != null)
        {
            try
            {
                long l = System.currentTimeMillis();
                int i = 0;

                JSONObject jsonObject = JSONObject.parseObject(s);
                for(String word:jsonObject.keySet())
                {
                    List<String> list = new ArrayList<>();
                    if(DataUtil.data_json.containsKey(word))
                    {
                        list = DataUtil.data_json.get(word);
                        list.add(jsonObject.getString(word));
                    } else {
                        list.add(jsonObject.getString(word));
                    }
                    DataUtil.data_json.put(word,list);
                    i++;
                }

                PrintUtil.print("[INFO] 加载 "+file+"文件 "+i+"个单词信息 ("+(System.currentTimeMillis()-l)+"ms).");
            }
            catch (Exception e)
            {
                PrintUtil.printError(e, true);
            }
        }
    }*/

    public static void transJson(String file,String s)
    {
        if (s != null) {
            try
            {
                long l = System.currentTimeMillis();

                JSONObject jsonObject = JSONObject.parseObject(s);
                int i = 0;
                for(String word:jsonObject.keySet())
                {
                    JSONArray jsonArray = JSONArray.parseArray(jsonObject.getString(word));
                    DataUtil.words.put(word,new Word(word,jsonArray));
                    i++;
                }

                PrintUtil.print("[INFO] 加载 "+file+"文件 "+i+"个单词信息 ("+(System.currentTimeMillis()-l)+"ms).");
            }
            catch (Exception e)
            {
                PrintUtil.printError(e, true);
            }
        }
    }
}
