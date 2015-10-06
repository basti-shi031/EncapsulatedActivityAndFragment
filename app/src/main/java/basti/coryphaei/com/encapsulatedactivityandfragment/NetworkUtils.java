package basti.coryphaei.com.encapsulatedactivityandfragment;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * 网络请求工具类
 * Created by Bowen on 2015/9/29.
 */
public class NetworkUtils {
    private NetworkCallback mCallback;

    public NetworkUtils(NetworkCallback callback){
        mCallback = callback;
    }

    /*
        加载数据
     */
    public void loadData(String url,RequestParams params,RequestMethod method){

        AsyncHttpClient client = MyAsynHttpClient.createClient();

        JsonHttpResponseHandler jsonHttpResponseHandler = new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                mCallback.parseJson(response);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);
            }
        };

        switch (method){
            case GET:
                client.get(url,jsonHttpResponseHandler);
                break;
            case POST:
                client.post(url,params,jsonHttpResponseHandler);
                break;
        }

    }


    public enum RequestMethod{
        GET,POST
    }
}
