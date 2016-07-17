package clanner.app.V.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import clanner.app.V.R;
import clanner.app.V.base.BaseActivity;
import clanner.app.V.fragment.HighlightFragment;
import clanner.app.V.fragment.MeFragment;
import clanner.app.V.fragment.PublishFragment;
import clanner.app.V.view.BottomView;

public class MainActivity extends BaseActivity implements ViewPager.OnPageChangeListener {

    @BindView(R.id.bottom_highlight)
    BottomView Highlight;
    @BindView(R.id.bottom_publish)
    BottomView Publish;
    @BindView(R.id.bottom_me)
    BottomView Me;
    @BindView(R.id.viewpager)
    ViewPager viewpager;

    private List<BottomView> bottomViewList = new ArrayList<BottomView>();
    private List<Fragment> tabs = new ArrayList<Fragment>();
    private FragmentPagerAdapter adapter;

    @Override
    protected int setContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        getSwipeBackLayout().setEnableGesture(false);
        initBottom();
        initFragment();
        setViewPager();
    }

    private void initBottom() {
        bottomViewList.add(Highlight);
        bottomViewList.add(Publish);
        bottomViewList.add(Me);
        bottomViewList.get(0).setIconAlpha(1.0f);
    }

    /**
     * 初始化Fragment
     */
    private void initFragment() {
        tabs.add(HighlightFragment.newInstance());
        tabs.add(PublishFragment.newInstance());
        tabs.add(MeFragment.newInstance());

        adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return tabs.get(position);
            }

            @Override
            public int getCount() {
                return tabs.size();
            }
        };
    }

    private void setViewPager() {
        viewpager.setOffscreenPageLimit(2);
        viewpager.setAdapter(adapter);
        viewpager.addOnPageChangeListener(this);
    }

    @OnClick({R.id.bottom_highlight, R.id.bottom_publish, R.id.bottom_me})
    public void onClick(View view) {
        resetOtherTabs();

        switch (view.getId()) {
            case R.id.bottom_highlight:
                bottomViewList.get(0).setIconAlpha(1.0f);
                viewpager.setCurrentItem(0, false);
                break;
            case R.id.bottom_publish:
                bottomViewList.get(1).setIconAlpha(1.0f);
                viewpager.setCurrentItem(1, false);
                break;
            case R.id.bottom_me:
                bottomViewList.get(2).setIconAlpha(1.0f);
                viewpager.setCurrentItem(2, false);
                break;
        }
    }

    /**
     * 重置其他的TabIndicator的颜色
     */
    private void resetOtherTabs() {
        for (int i = 0; i < bottomViewList.size(); i++) {
            bottomViewList.get(i).setIconAlpha(0);
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if (positionOffset > 0) {
            BottomView left = bottomViewList.get(position);
            BottomView right = bottomViewList.get(position + 1);
            left.setIconAlpha(1 - positionOffset);
            right.setIconAlpha(positionOffset);
        }
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
