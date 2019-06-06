package com.example.project;

import com.google.gson.Gson;
import org.apache.tomcat.util.http.fileupload.FileUtils;

import javax.xml.crypto.Data;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.stream.Stream;

public class Utils {

    public static String SerializeObject(Object user){
      Gson json=new Gson();
      String obj=json.toJson(user);
      return obj;
    }

    public static Users DeserilizeObject(String filepath){
        Gson json=new Gson();
        String jsonObject=readLine(filepath);
        Users user=json.fromJson(jsonObject,Users.class);
        return user;
    }

    public static String readLine(String filePath)
    {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines( Paths.get(filePath), StandardCharsets.UTF_8))
        {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return contentBuilder.toString();
    }

    public static void writeFile(String filePath,String obj) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        writer.write(obj);
        writer.close();
    }

}
