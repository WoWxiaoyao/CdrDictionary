package wow.cdr.util;

import wow.cdr.Main;

import java.io.*;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class FileUtil
{
    //v1.1 test
    public static boolean initialize()
    {
        try
        {
            String db_folder = "database";
            File file = new File(getPath()+db_folder);
            if (!file.exists())
            {
                if(!file.mkdir()) PrintUtil.printError("&1生成数据目录文件夹失败");
                PrintUtil.printError("&1数据文件不存在,请将数据文件放入数据目录后再次运行!");
                return false;
            }
            String[] fileNames = file.list();
            if(fileNames==null)
            {
                PrintUtil.printError("&1数据目录异常!");
                return false;
            }
            if(fileNames.length==0)
            {
                PrintUtil.printError("&1数据文件不存在,请将数据文件放入数据目录后再次运行!");
                return false;
            }
            for(String filename:fileNames)
            {
                if(filename.endsWith(".json"))
                {
                    File f = new File(getPath()+db_folder+"/"+filename);
                    FileReader fileReader = new FileReader(f);
                    Reader reader = new InputStreamReader(new FileInputStream(f), StandardCharsets.UTF_8);

                    StringBuilder sb = new StringBuilder();
                    int ch;
                    while ((ch = reader.read()) != -1) {
                        sb.append((char)ch);
                    }
                    fileReader.close();
                    reader.close();
                    JsonUtil.transJson(filename,sb.toString());
                }
            }
            
        } catch (Exception e)
        {
            PrintUtil.printError(e,true);
        }
        return true;
    }

    public static String getPath()
    {
        String path = getJarPath();
        return path.substring(0,path.lastIndexOf("/")+1);
    }

    public static String getJarPath()
    {
        String path = "";
        try{
            String url = URLDecoder.decode(Main.class.getProtectionDomain().getCodeSource().getLocation().getPath(), "UTF-8");
            path = url.substring(1,url.length());
        }catch (Exception e){
            PrintUtil.printError(e,true);
        }
        return path;
    }
}
