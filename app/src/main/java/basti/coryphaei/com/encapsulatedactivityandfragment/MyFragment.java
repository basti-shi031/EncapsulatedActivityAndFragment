package basti.coryphaei.com.encapsulatedactivityandfragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONObject;

/**
 * 示例Fragment
 * Created by Bowen on 2015/10/5.
 */
public class MyFragment extends RefreshFragment{

    public MyFragment(){
    }
    private int i = 1;
    private TextView tv;
    private String url = "https://coding.net/api/project/39583/topic";
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            i++;
            mToastUtils.showBottomToast(i + "");
            setRefreshing(false);
            super.handleMessage(msg);
        }
    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        LayoutInflater myInflater = (LayoutInflater)getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = myInflater.inflate(R.layout.main, container, false);
        initRefreshLayout(view);
        initView(view);
        showProgressDialog(true, "正在加载");
        postNetwork(url,params);
        return view;
    }

    private void initView(View view) {
        tv = (TextView) view.findViewById(R.id.tv);
    }


    @Override
    public void onRefresh() {

        handler.sendEmptyMessageDelayed(1,3000);

    }

    @Override
    public void parseJson(JSONObject response) {
        tv.setText(response.toString());
        //进度条
        showProgressDialog(false);
        //Toast
        showBottomToast("加载成功！");
    }
}
