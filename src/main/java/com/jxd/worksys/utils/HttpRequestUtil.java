package com.jxd.worksys.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

/**
 * <p>Description: [http请求工具类]</p>
 * @version 1.0
 */
@Slf4j
public class HttpRequestUtil {

    /**
     * <p>Discription:[发doPost请求]</p>
     * @param destUrl
     * @param postData
     * @return
     * @throws Exception
     * @author:[zh-fan]
     * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    public static String send(String destUrl, String postData,String type) throws Exception {
        long date1 = System.currentTimeMillis();
        HttpURLConnection urlconn = null;
        BufferedReader rd = null;
        OutputStream out = null;
        try{
            String recString = "";
            URL url = null;
            url = new URL(destUrl);
            urlconn = (HttpURLConnection) url.openConnection();
            urlconn.setRequestProperty("content-type",type);
            urlconn.setRequestMethod("POST");
            urlconn.setDoInput(true);
            urlconn.setDoOutput(true);
            urlconn.setConnectTimeout(3000);
            urlconn.setReadTimeout(10000);
            out = urlconn.getOutputStream();
            out.write(postData.getBytes("UTF-8"));

            rd = new BufferedReader(new InputStreamReader(urlconn.getInputStream(), "UTF-8"));
            StringBuffer sb = new StringBuffer();
            int ch;
            while ((ch = rd.read()) > -1) {
                sb.append((char) ch);
            }
            recString = sb.toString();
            return recString;
        }catch (Exception e){
            log.error("发送请求失败catch：" + destUrl ,e);
            throw new Exception(destUrl + "：" + e.getMessage());
        }finally {
            if(out!=null){
                out.flush();
                out.close();
            }
            if(rd!=null){
                rd.close();
            }
            if(urlconn!=null) {
                urlconn.disconnect();
            }
            log.error("HttpRequestUtil-send-url【"+destUrl+"】 耗时:"+(System.currentTimeMillis()-date1));
        }
    }
    public static String sendGet(String destUrl) throws Exception {
        long date1 = System.currentTimeMillis();
        HttpURLConnection urlconn = null;
        BufferedReader rd = null;
        try{
            String recString = "";
            URL url = null;
            url = new URL(destUrl);
            urlconn = (HttpURLConnection) url.openConnection();
            urlconn.setRequestProperty("content-type","application/json; charset=UTF-8");
            //            conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            urlconn.setRequestProperty("connection", "keep-alive");
            urlconn.setRequestProperty("User-Agent", "Mozilla/4.76");
            urlconn.setRequestMethod("GET");
            urlconn.setDoInput(true);
            urlconn.setDoOutput(true);
            rd = new BufferedReader(new InputStreamReader(urlconn.getInputStream(), "UTF-8"));
            StringBuffer sb = new StringBuffer();
            int ch;
            while ((ch = rd.read()) > -1) {
                sb.append((char) ch);
            }
            recString = sb.toString();
            return recString;
        }catch (Exception e){
            log.error("发送请求失败catch：" + destUrl ,e);
            throw new Exception(destUrl + "：" + e.getMessage());
        }finally {
            if(rd!=null){
                rd.close();
            }
            if(urlconn!=null) {
                urlconn.disconnect();
            }
        }
    }
    public static String sendUrl(String destUrl,String type) throws Exception {
        long date1 = System.currentTimeMillis();
        HttpURLConnection urlconn = null;
        BufferedReader rd = null;
        try{
            String recString = "";
            URL url = null;

            url = new URL(destUrl);
            urlconn = (HttpURLConnection) url.openConnection();
            urlconn.setRequestProperty("content-type",type);
            urlconn.setRequestMethod("POST");
            urlconn.setDoInput(true);
            urlconn.setDoOutput(true);
            urlconn.setConnectTimeout(3000);
            urlconn.setReadTimeout(5000);
            rd = new BufferedReader(new InputStreamReader(urlconn.getInputStream(), "UTF-8"));
            StringBuffer sb = new StringBuffer();
            int ch;
            while ((ch = rd.read()) > -1) {
                sb.append((char) ch);
            }
            recString = sb.toString();

            return recString;
        }catch (Exception e){
            log.error("发送请求失败catch：" + destUrl ,e);
            throw new Exception(destUrl + "：" + e.getMessage());
        }finally {
            if(rd!=null){
                rd.close();
            }
            if(urlconn!=null) {
                urlconn.disconnect();
            }
            log.error("HttpRequestUtil-sendUrl-url【"+destUrl+"】 耗时:"+(System.currentTimeMillis()-date1));

        }
    }
    public static String sendUrlWait10(String destUrl,String type) throws Exception {
        long date1 = System.currentTimeMillis();
        HttpURLConnection urlconn = null;
        BufferedReader rd = null;
        try{
            String recString = "";
            URL url = null;

            url = new URL(destUrl);
            urlconn = (HttpURLConnection) url.openConnection();
            urlconn.setRequestProperty("content-type",type);
            urlconn.setRequestMethod("POST");
            urlconn.setDoInput(true);
            urlconn.setDoOutput(true);
            urlconn.setConnectTimeout(3000);
            urlconn.setReadTimeout(10000);
            rd = new BufferedReader(new InputStreamReader(urlconn.getInputStream(), "UTF-8"));
            StringBuffer sb = new StringBuffer();
            int ch;
            while ((ch = rd.read()) > -1) {
                sb.append((char) ch);
            }
            recString = sb.toString();

            return recString;
        }catch (Exception e){
            log.error("发送请求失败catch：" + destUrl ,e);
            throw new Exception(destUrl + "：" + e.getMessage());
        }finally {
            if(rd!=null){
                rd.close();
            }
            if(urlconn!=null) {
                urlconn.disconnect();
            }
            log.error("HttpRequestUtil-sendUrlWait10-url【"+destUrl+"】 耗时:"+(System.currentTimeMillis()-date1));

        }
    }
    /*
     *设置30spost请求post超时时间，
     */
    public static String sendUrlLongWait(String destUrl,String type) throws Exception {
        long date1 = System.currentTimeMillis();
        HttpURLConnection urlconn = null;
        BufferedReader rd = null;
        try{
            String recString = "";
            URL url = null;

            url = new URL(destUrl);
            urlconn = (HttpURLConnection) url.openConnection();
            urlconn.setRequestProperty("content-type",type);
            urlconn.setRequestMethod("POST");
            urlconn.setDoInput(true);
            urlconn.setDoOutput(true);
            urlconn.setConnectTimeout(3000);
            urlconn.setReadTimeout(30000);
            rd = new BufferedReader(new InputStreamReader(urlconn.getInputStream(), "UTF-8"));
            StringBuffer sb = new StringBuffer();
            int ch;
            while ((ch = rd.read()) > -1) {
                sb.append((char) ch);
            }
            recString = sb.toString();
            return recString;
        }catch (Exception e){
            log.error("发送请求失败catch：" + destUrl ,e);
            throw new Exception(destUrl + "：" + e.getMessage());
        }finally {
            if(rd!=null){
                rd.close();
            }
            if(urlconn!=null) {
                urlconn.disconnect();
            }
            log.error("HttpRequestUtil-sendUrlLongWait-url【"+destUrl+"】 耗时:"+(System.currentTimeMillis()-date1));

        }
    }

    public static String sendUrlFY(String destUrl,String type) throws Exception {
        long date1 = System.currentTimeMillis();
        HttpURLConnection urlconn = null;
        BufferedReader rd = null;
        try{
            String recString = "";
            URL url = null;

            url = new URL(destUrl);
            urlconn = (HttpURLConnection) url.openConnection();
            urlconn.setRequestProperty("content-type",type);
            urlconn.setRequestMethod("POST");
            urlconn.setDoInput(true);
            urlconn.setDoOutput(true);
            urlconn.setConnectTimeout(3000);
            urlconn.setReadTimeout(120000);
            rd = new BufferedReader(new InputStreamReader(urlconn.getInputStream(), "UTF-8"));
            StringBuffer sb = new StringBuffer();
            int ch;
            while ((ch = rd.read()) > -1) {
                sb.append((char) ch);
            }
            recString = sb.toString();
            return recString;
        }catch (Exception e){
            log.error("发送请求失败catch：" + destUrl ,e);
            throw new Exception(destUrl + "：" + e.getMessage());
        }finally {
            if(rd!=null){
                rd.close();
            }
            if(urlconn!=null) {
                urlconn.disconnect();
            }
            log.error("HttpRequestUtil-sendUrlFY-url【"+destUrl+"】 耗时:"+(System.currentTimeMillis()-date1));

        }
    }
}

