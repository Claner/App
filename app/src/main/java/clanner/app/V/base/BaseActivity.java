package clanner.app.V.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import butterknife.ButterKnife;
import clanner.app.V.R;
import me.yokeyword.swipebackfragment.SwipeBackActivity;

/**
 * Created by Clanner on 2016/6/23.
 * Activity的基类，支持右滑退出
 * 若不支持则在initView中调用getSwipeBackLayout().setEnableGesture(false);
 */
public abstract class BaseActivity extends SwipeBackActivity{
    protected abstract int setContentViewId();
    protected abstract void initView(Bundle savedInstanceState);
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setContentViewId());
        ButterKnife.bind(this);
        initView(savedInstanceState);
    }

    /**
     * 初始化 ToolBar
     */
    protected void initActionBar(Toolbar toolbar, String title, boolean isCanBack){
        toolbar.setNavigationIcon(R.mipmap.ic_back_white);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setTitle(title);
        actionBar.setDisplayHomeAsUpEnabled(isCanBack);
    }

    protected void initActionBar(Toolbar toolbar,int title,boolean isCanBack){
        toolbar.setNavigationIcon(R.mipmap.ic_back_white);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setTitle(title);
        actionBar.setDisplayHomeAsUpEnabled(isCanBack);
    }

    protected void initActionBar(Toolbar toolbar,String title,int logo,boolean isCanBack){
        toolbar.setNavigationIcon(R.mipmap.ic_back_white);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setTitle(title);
        actionBar.setLogo(logo);
        actionBar.setDisplayHomeAsUpEnabled(isCanBack);
    }

    protected void initActionBar(Toolbar toolbar,int title,int logo,boolean isCanBack){
        toolbar.setNavigationIcon(R.mipmap.ic_back_white);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setTitle(title);
        actionBar.setLogo(logo);
        actionBar.setDisplayHomeAsUpEnabled(isCanBack);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    protected void toast(String content) {
        try {
            Snackbar.make(findViewById(R.id.layout_container), content, Snackbar.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(this, content, Toast.LENGTH_LONG).show();
        }
    }

    protected void ChangeActivity(Class<?> cls){
        Intent intent = new Intent(this,cls);
        startActivity(intent);
    }

    protected void ChangeActivity(Class<?> cls,boolean isFinish){
        Intent intent = new Intent(this,cls);
        startActivity(intent);
        if (isFinish) this.finish();
    }
}
