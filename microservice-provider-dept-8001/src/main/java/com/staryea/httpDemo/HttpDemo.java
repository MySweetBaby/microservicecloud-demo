package com.staryea.httpDemo;


import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by tangdy on 2018/12/27.
 */
public class HttpDemo {

    public void sendGetRequest(String path,String param) throws Exception {
        URL url =new URL(path);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setRequestProperty("accept","*/*");
        connection.setRequestProperty("charset","UTF-8");
        connection.setRequestProperty("Content-Type","application/json");
        OutputStream outputStream = connection.getOutputStream();
        outputStream.write(param.getBytes());
        outputStream.flush();
        outputStream.close();
        InputStream inputStream = connection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String result="";
        String str="";
        while ((str=reader.readLine())!=null){
            result+=str;
        }
        System.out.println("result is "+result);
        inputStream.close();
        connection.disconnect();

    }

    public void getResult(String url) throws Exception {
        byte[] xmlData = new byte[1024];
        URL url1 = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) url1.openConnection();
        connection.setRequestMethod("GET");
        connection.setDoInput(true);
        connection.setDoOutput(true);
        connection.setRequestProperty("accept", "*/*");
        connection.setRequestProperty("content-Type", "application/json");
        connection.setRequestProperty("charset", "utf-8");
//        connection.setRequestProperty("Content-length",
//                String.valueOf(xmlData.length));    }
        DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream());
        outputStream.write(xmlData);
        System.out.println("xmlData is "+new String(xmlData));
        outputStream.flush();
        outputStream.close();
        InputStream inputStream = connection.getInputStream();
        byte [] bytes = new byte[inputStream.available()];
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String str ="";
        String result ="";
        while ((str=br.readLine())!=null){
            System.out.println(new String(str.getBytes(),"GBK"));
            System.out.println(str);
            result+=str;
        }
        System.out.println(inputStream.read(bytes));
        System.out.println("==============="+new String(bytes));
        System.out.println("-----------"+result);
        inputStream.close();
        connection.disconnect();



    }

    public static void main(String args[]) throws Exception {
        HttpDemo httpDemo = new HttpDemo();
        httpDemo.getResult("https://tcc.taobao.com/cc/json/mobile_tel_segment.htm?tel=18203611773");
    }
}