package basti.coryphaei.com.encapsulatedactivityandfragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

/**
 * 封装了网络请求
 * Created by Bowen on 2015/9/29.
 */
public class BaseActivity extends ActionBarActivity implements NetworkCallback{

    protected NetworkUtils networkUtils;
    protected RequestParams params;
    private ProgressDialog progressDialog;
    private ToastUtils mToastUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initVariable();
    }

    private void initVariable() {
        networkUtils = new NetworkUtils(this);
        params = new RequestParams();
        progressDialog = new ProgressDialog(this);
        mToastUtils = new ToastUtils(this);
    }

    //显示进度条消息
    protected void showProgressMessage(boolean isShow,String message){
        if (isShow){
            progressDialog.setMessage(message);
            progressDialog.show();
        }else {
            progressDialog.hide();
        }
    }

    protected void showProgressMessage(boolean isShow){
        showProgressMessage(isShow,"");
    }

    protected void showBottomToast(String message){
        mToastUtils.showBottomToast(message);
    }

    protected void showMiddleToast(String message){
        mToastUtils.showMiddleToast(message);
    }

    //get方法
    protected void getNetwork(String url){
        networkUtils.loadData(url,null,NetworkUtils.RequestMethod.GET);
    }

    //post方法
    protected void postNetwork(String url,RequestParams params){
        networkUtils.loadData(url,params,NetworkUtils.RequestMethod.POST);
    }

    @Override
    public void parseJson(JSONObject respanse) {
    }
}
