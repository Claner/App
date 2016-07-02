package clanner.app.V.activity;

import android.os.Bundle;

import clanner.app.V.R;
import clanner.app.V.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected int setContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        getSwipeBackLayout().setEnableGesture(false);
    }
}
