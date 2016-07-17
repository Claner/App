package clanner.app.V.fragment;

import android.os.Bundle;
import android.view.View;

import clanner.app.V.R;
import clanner.app.V.base.BaseFragment;

/**
 * Created by Clanner on 2016/7/16.
 */
public class InviteMeFragment extends BaseFragment {
    public static InviteMeFragment newInstance() {
        return new InviteMeFragment();
    }

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_inviteme;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }
}
