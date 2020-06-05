package com.async.deal.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtil {
    public static String get (String pageURL) {
        StringBuffer respContent = new StringBuffer();
        BufferedReader in = null;
        InputStreamReader isr = null;
        InputStream is = null;
        HttpURLConnection httpURLConnection = null;
        try {
            URL url = new URL(pageURL);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            is = httpURLConnection.getInputStream();
            isr = new InputStreamReader(is);
            in = new BufferedReader(isr);
            String line = null;
            while (((line = in.readLine()) != null)) {
                respContent.append(line) ;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null)
                    is.close();
                if (isr != null)
                    isr.close();
                if (in != null)
                    in.close();
                if (httpURLConnection != null)
                    httpURLConnection.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return String.valueOf(respContent);
    }
}
