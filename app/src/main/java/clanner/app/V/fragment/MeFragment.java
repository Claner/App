package clanner.app.V.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.astuetz.PagerSlidingTabStrip;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import clanner.app.V.Adapter.MeAdapter;
import clanner.app.V.R;
import clanner.app.V.base.BaseFragment;

/**
 * Created by Clanner on 2016/7/15.
 */
public class MeFragment extends BaseFragment {
    @BindView(R.id.me_viewpager)
    ViewPager meViewpager;
    @BindView(R.id.tabs)
    PagerSlidingTabStrip tabs;
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private List<Fragment> fragments = new ArrayList<Fragment>();
    private FragmentPagerAdapter adapter;
    private String[] titles;

    public static MeFragment newInstance() {
        return new MeFragment();
    }

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_me;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        setActionBar();
        initFragment();
        initViewPager();
    }

    private void setActionBar() {
        initActionBar(toolbar,"");
        toolbarTitle.setText(R.string.bottom_me_value);
    }

    private void initFragment() {
        fragments.add(MyInviteFragment.newInstance());
        fragments.add(InviteMeFragment.newInstance());
        titles = getResources().getStringArray(R.array.me_titles);
        adapter = new MeAdapter(getActivity().getSupportFragmentManager(), fragments, titles);
    }

    private void initViewPager() {
        meViewpager.setAdapter(adapter);
        tabs.setViewPager(meViewpager);
    }
}
