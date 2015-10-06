package basti.coryphaei.com.encapsulatedactivityandfragment;

import com.loopj.android.http.AsyncHttpClient;


/**
 * 重新封装的AsynHttpClient
 * Created by Bowen on 2015/9/29.
 */
public class MyAsynHttpClient {

    public static AsyncHttpClient createClient(){
        AsyncHttpClient client = new AsyncHttpClient();
        return client;
    }

}
