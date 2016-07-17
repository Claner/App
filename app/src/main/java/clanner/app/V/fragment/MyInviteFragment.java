package clanner.app.V.fragment;

import android.os.Bundle;
import android.view.View;

import clanner.app.V.R;
import clanner.app.V.base.BaseFragment;

/**
 * Created by Clanner on 2016/7/16.
 */
public class MyInviteFragment extends BaseFragment{
    public static MyInviteFragment newInstance(){
        return  new MyInviteFragment();
    }

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_myinvite;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }
}
