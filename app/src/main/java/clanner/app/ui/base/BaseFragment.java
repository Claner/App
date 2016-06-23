package clanner.app.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import butterknife.ButterKnife;
import clanner.app.ui.R;
import me.yokeyword.swipebackfragment.SwipeBackFragment;

/**
 * Created by Clanner on 2016/6/23.
 * Fragment的基类 支持右滑退出
 * 若不支持则在initView中调用getSwipeBackLayout().setEnableGesture(false);
 */
public abstract class BaseFragment extends SwipeBackFragment{
    private ActionBar actionBar;

    protected abstract void initView(View view, Bundle savedInstanceState);

    //获取fragment布局文件ID
    protected abstract int setLayoutId();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(setLayoutId(), container, false);
        ButterKnife.bind(this, view);
        initView(view, savedInstanceState);
        return attachToSwipeBack(view);
    }

    /**
     * 添加Fragment
     *
     * @param fragment
     * @param activity
     */
    protected void addFragment(BaseFragment fragment, BaseFragmentActivity activity) {
        activity.addFragment(fragment);
    }

    /**
     * 移除Fragment
     */
    protected void removeFragment(BaseFragmentActivity activity) {
        activity.removeFragment();
    }

    /**
     * 初始化ActionBar
     *
     * @param toolbar
     * @param title
     */
    protected void initActionBar(Toolbar toolbar, String title) {
        toolbar.setNavigationIcon(R.mipmap.ic_back_white);
        toolbar.setTitle(title);
        toolbar.setNavigationIcon(R.mipmap.ic_back_white);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });
    }

    protected void initActionBar( Toolbar toolbar, int title) {
        toolbar.setNavigationIcon(R.mipmap.ic_back_white);
        toolbar.setTitle(title);
        toolbar.setNavigationIcon(R.mipmap.ic_back_white);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });
    }

    protected void toast(String content) {
        if (getActivity() != null) {
            try {
                Snackbar.make(getActivity().findViewById(R.id.layout_container), content, Snackbar.LENGTH_LONG).show();
            } catch (Exception e) {
                Toast.makeText(getActivity(), content, Toast.LENGTH_LONG).show();
            }
        }
    }
}
