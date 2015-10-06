package basti.coryphaei.com.encapsulatedactivityandfragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;


public class MainActivity extends ActionBarActivity {

    private FrameLayout mFrameLayout;
    private FragmentManager fm;
    private MyFragment myFragment;
    private FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fm = getFragmentManager();
        ft = fm.beginTransaction();
        mFrameLayout = (FrameLayout) findViewById(R.id.framelayout);

        if (myFragment == null){
            Log.i("1","1");
            myFragment = new MyFragment();
            ft.add(R.id.framelayout,myFragment);
        }

        ft.show(myFragment);
        ft.commit();
    }
}
