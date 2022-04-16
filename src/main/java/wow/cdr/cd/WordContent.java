package wow.cdr.cd;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class WordContent
{
    private final String wc_word;
    private final String wc_mean;
    private final List<String> wc_usage = new ArrayList<>();
    private final List<String> wc_sentence = new ArrayList<>();

    public WordContent(String word,JSONObject jsonObject)
    {
        this.wc_word = word;
        //设置该词义
        this.wc_mean = jsonObject.getString("mean");
        //设置词组
        //json存在一个词组解释，与该部分是否有偏差尚未得知，若存在较大问题日后处理
        JSONArray jsonArray = JSONArray.parseArray(jsonObject.getString("usage"));
        JSONObject json = new JSONObject();
        for(int i=0;i<=jsonArray.size()-1;i++)
        {
            wc_usage.add(jsonArray.getString(i));
        }

        jsonArray = JSONArray.parseArray(jsonObject.getString("example"));
        for(int i=0;i<=jsonArray.size()-1;i++)
        {
            json = JSONObject.parseObject(jsonArray.getString(i));
            wc_sentence.add(json.getString("sen_content")+" "+json.getString("sen_mean_cn"));
        }
    }

    public String getWord()
    {
        return this.wc_word;
    }

    public String getMean()
    {
        return this.wc_mean;
    }

    public List<String> getUsage()
    {
        return this.wc_usage;
    }

    public List<String> getSentence()
    {
        return this.wc_sentence;
    }

    public List<String> getMeanUsage()
    {
        List<String> list = new ArrayList<>();
        for(String line:getUsage())
        {
            list.add(getWord()+"&&"+getMean()+"&&"+line);
        }
        return list;
    }

    public List<String> getMeanSentence()
    {
        List<String> list = new ArrayList<>();
        for(String line:getSentence())
        {
            list.add(getWord()+"&&"+getMean()+"&&"+line);
        }
        return list;
    }
}
