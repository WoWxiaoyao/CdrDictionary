package wow.cdr.cd;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Word
{
    private final String word_name;
    private final List<WordContent> word_content = new ArrayList<>();

    public Word(String word, JSONArray jsonArray)
    {
        this.word_name = word;

        for(int i=0;i<=jsonArray.size()-1;i++)
        {
            JSONObject jsonObject = JSONObject.parseObject(JSONObject.parseObject(jsonArray.getString(i)).getString("content"));
            word_content.add(new WordContent(word,jsonObject));
        }
    }

    public String getWord()
    {
        return this.word_name;
    }

    public List<WordContent> getWordContent()
    {
        return this.word_content;
    }

    public List<String> getWordMeans()
    {
        List<String> list = new ArrayList<>();
        for(WordContent wordContent:getWordContent())
        {
            list.add(wordContent.getMean());
        }
        return check(list);
    }

    public List<String> getWordUsage()
    {
        List<String> list = new ArrayList<>();
        for(WordContent wordContent:getWordContent())
        {
            list.addAll(wordContent.getUsage());
        }
        return check(list);
    }

    public List<String> getWordSentence()
    {
        List<String> list = new ArrayList<>();
        for(WordContent wordContent:getWordContent())
        {
            list.addAll(wordContent.getSentence());
        }
        return check(list);
    }

    public List<String> getWordMeanUsage()
    {
        List<String> list = new ArrayList<>();
        for(WordContent wordContent:getWordContent())
        {
            list.addAll(wordContent.getMeanUsage());
        }
        return check(list);
    }

    public List<String> getWordMeanSentence()
    {
        List<String> list = new ArrayList<>();
        for(WordContent wordContent:getWordContent())
        {
            list.addAll(wordContent.getMeanSentence());
        }
        return check(list);
    }

    private List<String> check(List<String> list)
    {
        List<String> cl = new ArrayList<>();
        for(String line:list)
        {
            if(!cl.contains(line)) cl.add(line);
        }
        return cl;
    }
}
