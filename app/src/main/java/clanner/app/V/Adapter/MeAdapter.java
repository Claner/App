package clanner.app.V.Adapter;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;

import java.util.List;

/**
 * Created by Clanner on 2016/7/16.
 */
public class MeAdapter extends FragmentPagerAdapter {
    FragmentManager fragmentManager;
    List<Fragment> fragments;
    String[] titles;
    SpannableStringBuilder ssb;

    public MeAdapter(FragmentManager fragmentManager, List<Fragment> fragments, String[] titles) {
        super(fragmentManager);
        this.fragmentManager = fragmentManager;
        this.fragments = fragments;
        this.titles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        ssb = new SpannableStringBuilder("" + titles[position]);
        ForegroundColorSpan fcs = new ForegroundColorSpan(Color.WHITE);//字体颜色设置为绿色
        ssb.setSpan(fcs, 1, ssb.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);//设置字体颜色
        ssb.setSpan(new RelativeSizeSpan(1.2f), 1, ssb.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return ssb;
    }
}
