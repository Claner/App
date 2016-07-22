package clanner.app.V.fragment;

import android.os.Bundle;
import android.view.View;

import clanner.app.V.R;
import clanner.app.V.base.BaseFragment;

/**
 * Created by Clanner on 2016/7/16.
 * 回复列表
 */
public class ReplyListFragment extends BaseFragment{

    public static ReplyListFragment newInstance(){
        return new ReplyListFragment();
    }

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_reply_list;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }
}
