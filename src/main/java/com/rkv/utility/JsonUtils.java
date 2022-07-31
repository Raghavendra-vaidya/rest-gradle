package com.rkv.utility;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JsonUtils {

    public static JsonObject getJsonFileAsJsonObject(String filePath){
        JsonObject fileObj = null;
        Path path = Paths.get(filePath);
        try {
            Reader reader = Files.newBufferedReader(path);
            JsonElement jelement =JsonParser.parseReader(reader);
            fileObj = jelement.getAsJsonObject();
        }
        catch (Exception e){e.printStackTrace();}
        return fileObj;
    }

    public static String getJsonFileAsString(String filePath){
        String file = null;
        Path path = Paths.get(filePath);
        try {
            Reader reader = Files.newBufferedReader(path);
            JsonElement jelement =JsonParser.parseReader(reader);
            JsonObject fileObj = jelement.getAsJsonObject();
            file = fileObj.toString();
        }
        catch (Exception e){e.printStackTrace();}
        return file;
    }

    public static boolean compareJsonStrings(String expected, String actual){
        JsonElement expectedJsonElement = JsonParser.parseString(expected);
        JsonElement actualJsonElement = JsonParser.parseString(actual);

        if (expectedJsonElement.equals(actualJsonElement))
        {
            return  true;
        }
        else return false;
    }

}
