package com.example.demo.commandpattern;

import com.alibaba.fastjson2.JSONObject;
import sun.nio.ch.IOUtil;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author hwd
 * @version 1.0
 * @since 2022/2/7
 */
public class TestMain {
    public static void main(String[] args) {
        try {
            infoPram();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        CommandExecutor commandExecutor = new CommandExecutor();
//        CommandA commandA=new CommandA();
//        commandExecutor.execute(commandA);
    }

    public static  void infoPram() throws Exception {
        String content = "";
        StringBuilder builder = new StringBuilder();

        File file = new File("D:\\JSON.txt");
        InputStreamReader streamReader = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(streamReader);

        while ((content = bufferedReader.readLine()) != null)
            builder.append(content);

        System.out.println(builder.toString());

        JSONObject jsonObject = JSONObject.parseObject(builder.toString(), JSONObject.class);
        System.out.println("CREATOR====>"+jsonObject);


    }

}
