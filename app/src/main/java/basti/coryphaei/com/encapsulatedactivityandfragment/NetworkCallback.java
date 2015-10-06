package basti.coryphaei.com.encapsulatedactivityandfragment;

import org.json.JSONObject;

/**
 * 网络请求工具类的回调接口
 * Created by Bowen on 2015/9/29.
 */
public interface NetworkCallback {

    void parseJson(JSONObject response);
}
