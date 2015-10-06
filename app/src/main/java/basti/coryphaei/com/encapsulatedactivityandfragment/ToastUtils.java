package basti.coryphaei.com.encapsulatedactivityandfragment;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

/**
 * Toast工具类
 * Created by Bowen on 2015/9/30.
 */
public class ToastUtils {

    private Toast mToast;
    private Context mContext;

    public ToastUtils(Context context){
        mContext = context;
        mToast = Toast.makeText(mContext,"",Toast.LENGTH_SHORT);
    }

    //显示底部Toast
    public void showBottomToast(String message,int duration){
        mToast.setText(message);
        mToast.setDuration(duration);
        mToast.setGravity(Gravity.BOTTOM,0,mContext.getResources().getDimensionPixelOffset(R.dimen.Toast_offset_y));
        mToast.show();
    }
    public void showBottomToast(String message){
        showBottomToast(message, Toast.LENGTH_SHORT);
    }

    //显示中部Toast
    public void showMiddleToast(String message,int duration){
        mToast.setText(message);
        mToast.setDuration(duration);
        mToast.setGravity(Gravity.CENTER,0,0);
        mToast.show();
    }
    public void showMiddleToast(String message){
        showMiddleToast(message, Toast.LENGTH_SHORT);
    }

}
