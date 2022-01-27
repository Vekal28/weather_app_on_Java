package com.nikita.weather_app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Requests {
    //private static String urlAddress;
    public static String get_wether(String urlAddress){
        StringBuffer content = new StringBuffer();
        try {
            URL url =  new URL(urlAddress);
            URLConnection urlConn = url.openConnection();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
            String line;
            while((line = bufferedReader.readLine()) != null) {
                content.append(line + "\n");
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.out.println("Такой город не найден !");
        }
        return content.toString();
    }

}
