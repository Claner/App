package clanner.app.ui.base;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.widget.Toast;

import butterknife.ButterKnife;
import clanner.app.ui.R;
import me.yokeyword.swipebackfragment.SwipeBackActivity;

/**
 * Created by Clanner on 2016/6/23.
 */
public abstract class BaseFragmentActivity extends SwipeBackActivity {
    protected abstract BaseFragment getFirstFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        ButterKnife.bind(this);
        //避免重复添加Fragment
        if (getSupportFragmentManager().getFragments() == null) {
            BaseFragment firstFragment = getFirstFragment();
            if (firstFragment != null) {
                addFragment(firstFragment);
            }
        }
    }

    /**
     * 添加Fragment
     *
     * @param fragment
     */
    public void addFragment(BaseFragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, fragment, fragment.getClass().getSimpleName())
                    .addToBackStack(fragment.getClass().getSimpleName())
                    .commitAllowingStateLoss();
        }
    }

    /**
     * 移除Fragment
     */
    public void removeFragment() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            getSupportFragmentManager().popBackStack();
        } else {
            finish();
        }
    }

    /**
     * 初始化 ToolBar
     */
    protected void initActionBar(Toolbar toolbar, String title, boolean isCanBack) {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(title);
        actionBar.setDisplayHomeAsUpEnabled(isCanBack);
    }

    protected void initActionBar(Toolbar toolbar, int title, boolean isCanBack) {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(title);
        actionBar.setDisplayHomeAsUpEnabled(isCanBack);
    }

    protected void initActionBar(Toolbar toolbar, String title, int logo, boolean isCanBack) {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(title);
        actionBar.setLogo(logo);
        actionBar.setDisplayHomeAsUpEnabled(isCanBack);
    }

    protected void initActionBar(Toolbar toolbar, int title, int logo, boolean isCanBack) {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(title);
        actionBar.setLogo(logo);
        actionBar.setDisplayHomeAsUpEnabled(isCanBack);
    }

    //返回键返回事件
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (KeyEvent.KEYCODE_BACK == keyCode) {
            if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
                finish();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    protected void toast(String content) {
        try {
            Snackbar.make(findViewById(R.id.layout_container), content, Snackbar.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(this, content, Toast.LENGTH_LONG).show();
        }
    }
}
