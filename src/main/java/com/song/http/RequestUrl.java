package com.song.http;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @ClassName RequestUrl
 * @Description Valar Morghulis.Valar Dohaeris
 * @Author songyp
 * @Date 2020-02-04 21:02
 */
@Slf4j
public class RequestUrl {


    public static void main(String[] args) {
        String url = "http://tyysyjycom.sx9.lcweb01.cn/index.php?p=news_show&id=298&lanmu=20&c_id=20";
        String []urlArray = {
                "http://tyysyjy.com/index.php?p=news_show&id=296&lanmu=20",
                "http://tyysyjy.com/index.php?p=news_show&id=295&lanmu=20",
                "http://tyysyjy.com/index.php?p=news_show&id=294&lanmu=20",
                "http://tyysyjy.com/index.php?p=news_show&id=293&lanmu=20",
                "http://tyysyjy.com/index.php?p=news_show&id=292&lanmu=20",
                "http://tyysyjy.com/index.php?p=news_show&id=289&lanmu=20",
                "http://tyysyjy.com/index.php?p=news_show&id=287&lanmu=20"
        };
        for(String urls:urlArray){
            int count = 0;
            while (count < 400) {
                sendRequest(urls);
                count++;
            }
        }
    }

    public static void sendRequest(String urlStr) {
        try {
            String str;
            log.info("当前访问页面为{}",urlStr);
            URL u = new URL(urlStr);
            InputStream is = u.openStream();
            InputStreamReader isr = new InputStreamReader(is, "UTF-8");
//            BufferedReader br = new BufferedReader(isr);
//            if (br.ready()) {
//                while ((str = br.readLine()) != null) {
//                    System.out.println(str);
//                }
//            }
//            br.close();
            isr.close();
            is.close();
        } catch (MalformedURLException e) {
            // url地址错误
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
