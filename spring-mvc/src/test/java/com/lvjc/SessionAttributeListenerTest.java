package com.lvjc;

import okhttp3.*;
import okio.BufferedSink;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by lvjc on 2017/8/4.
 */
public class SessionAttributeListenerTest {

    @Test
    public void testAttributeReplaced(){
        String url = "http://localhost:8080/session/attribute/add";
        Request request = new Request.Builder()
                .url(url)
                .build();
        OkHttpClient client = new OkHttpClient();
        try {
            client.newCall(request).execute();
            client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
