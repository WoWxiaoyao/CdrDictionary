package wow.cdr.cd;

/*import wow.cdr.Main;

import java.util.ArrayList;
import java.util.List;

* 用于检测输出list是否存在相似
* build in v1.0.1
* 因多词库兼容暂时不考虑，所以注释全部代码
 */

public class WordCheck
{
 /*   public WordCheck()
    {

    }


    public List<String> getCheckSimilarityList(List<String> list)
    {
        if(!isCheckSimilarity())return list;
        List<String> newList = new ArrayList<>();
        for(String i1:list)
        {
            boolean ok = true;
            for(String i2:list)
            {
                if(isSimilarity(i1,i2))
                {
                    ok = false;
                    break;
                }
            }
            if(ok) newList.add(i1);
        }
        return newList;
    }

    public boolean isCheckSimilarity()
    {
        return (!(Main.Similarity > 100)) && (!(Main.Similarity < 0));
    }

    public boolean isSimilarity(String str, String target)
    {
        return ((isCheckSimilarity())&&(getSimilarity(str, target) >= Main.Similarity));
    }

    //用于查询相似度
    private float getSimilarity(String str, String target)
    {
        int[][] d;
        int n = str.length();
        int m = target.length();
        int i;
        int j;
        char ch1;
        char ch2;
        int temp;
        if (n == 0 || m == 0)
        {
            return 0;
        }
        d = new int[n + 1][m + 1];
        for (i = 0; i <= n; i++)
        {
            d[i][0] = i;
        }

        for (j = 0; j <= m; j++)
        {
            d[0][j] = j;
        }

        for (i = 1; i <= n; i++)
        {
            ch1 = str.charAt(i - 1);
            for (j = 1; j <= m; j++) {
                ch2 = target.charAt(j - 1);
                if (ch1 == ch2 || ch1 == ch2 + 32 || ch1 + 32 == ch2) {
                    temp = 0;
                } else {
                    temp = 1;
                }
                d[i][j] = Math.min(Math.min(d[i - 1][j] + 1, d[i][j - 1] + 1), d[i - 1][j - 1] + temp);
            }
        }

        return (1 - (float) d[n][m] / Math.max(str.length(), target.length())) * 100F;
    }*/
}
