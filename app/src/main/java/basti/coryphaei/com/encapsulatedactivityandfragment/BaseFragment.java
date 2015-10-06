package basti.coryphaei.com.encapsulatedactivityandfragment;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;

import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

/**
 * 封装了网络请求
 * Created by Bowen on 2015/10/5.
 */
public class BaseFragment extends Fragment implements NetworkCallback{

    protected NetworkUtils networkUtils;
    protected ProgressDialog mProgressDialog;
    protected ToastUtils mToastUtils;
    protected LayoutInflater mInflater;
    protected RequestParams params;
    @Override
    public void parseJson(JSONObject response) {

    }

    //显示进度条
    protected void showProgressDialog(boolean show){
        showProgressDialog(show,"");
    }

    protected void showProgressDialog(boolean show, String message) {
        if (mProgressDialog == null)
            mProgressDialog = new ProgressDialog(getActivity());

        if (show){
            mProgressDialog.setMessage(message);
            mProgressDialog.show();
        }else
            mProgressDialog.hide();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        //初始化
        initUtils();

        mInflater = LayoutInflater.from(getActivity());
        super.onCreate(savedInstanceState);
    }

    private void initUtils() {
        if (networkUtils == null){
            networkUtils = new NetworkUtils(this);
        }

        if (mToastUtils == null){
            mToastUtils = new ToastUtils(getActivity());
        }

        if (params == null){
            params = new RequestParams();
        }
    }

    //get方法
    protected void getNetwork(String url){
        networkUtils.loadData(url, null, NetworkUtils.RequestMethod.GET);
    }

    //post方法
    protected void postNetwork(String url,RequestParams params){
        networkUtils.loadData(url,params,NetworkUtils.RequestMethod.POST);
    }

    protected void showBottomToast(String message){
        mToastUtils.showBottomToast(message);
    }

    @Override
    public void onDestroy() {
        Log.i("123","123");
        mProgressDialog.dismiss();
        super.onDestroy();
    }
}
