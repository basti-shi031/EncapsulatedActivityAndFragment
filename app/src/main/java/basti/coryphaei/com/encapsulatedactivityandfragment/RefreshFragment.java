package basti.coryphaei.com.encapsulatedactivityandfragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;

/**
 * 封装了swipeRefreshLayout
 * Created by Bowen on 2015/10/5.
 */
public class RefreshFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {

    protected SwipeRefreshLayout mSwipeRefreshLayout;

    protected boolean isRefreshing(){
        return mSwipeRefreshLayout.isRefreshing();
    }

    protected void setRefreshing(boolean refreshing){
        mSwipeRefreshLayout.setRefreshing(refreshing);
    }

    protected void initRefreshLayout(View view){

        mSwipeRefreshLayout = (SwipeRefreshLayout)
                view.
                        findViewById
                                (R.id.swipeRefreshLayout);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.red, R.color.green, R.color.blue);

    }

    protected void setSwipeRefreshLayout(boolean enable){
        if (mSwipeRefreshLayout != null){
            mSwipeRefreshLayout.setEnabled(enable);
        }
    }

    protected boolean getSwipeRefreshLayout(){
        if (mSwipeRefreshLayout != null){
            return mSwipeRefreshLayout.isEnabled();
        }
        return false;
    }

    @Override
    public void onRefresh() {

    }
}
