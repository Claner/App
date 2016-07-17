package clanner.app.V.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import butterknife.ButterKnife;
import clanner.app.V.R;

/**
 * Created by Clanner on 2016/7/16.
 */
public abstract class BaseFragment extends Fragment {
    private ActionBar actionBar;

    protected abstract void initView(View view, Bundle savedInstanceState);

    //获取fragment布局文件ID
    protected abstract int setLayoutId();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(setLayoutId(), container, false);
        ButterKnife.bind(this, view);
        initView(view, savedInstanceState);
        return view;
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
     * <p/>
     * 若title要居中显示，则传入""
     *
     * @param toolbar
     * @param title
     */
    protected void initActionBar(Toolbar toolbar,String title){
        toolbar.setTitle(title);
    }

    protected void initActionBar(Toolbar toolbar,int title){
        toolbar.setTitle(title);
    }

    protected void initActionBar(Toolbar toolbar, String title, final boolean isFinish) {
        toolbar.setNavigationIcon(R.mipmap.ic_back_white);
        toolbar.setTitle(title);
        toolbar.setNavigationIcon(R.mipmap.ic_back_white);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isFinish) {
                    getActivity().finish();
                } else {
                    getActivity().onBackPressed();
                }
            }
        });
    }

    protected void initActionBar(Toolbar toolbar, int title, final boolean isFinish) {
        toolbar.setNavigationIcon(R.mipmap.ic_back_white);
        toolbar.setTitle(title);
        toolbar.setNavigationIcon(R.mipmap.ic_back_white);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isFinish) {
                    getActivity().finish();
                } else {
                    getActivity().onBackPressed();
                }
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
