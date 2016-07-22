package clanner.app.V.activity;

import clanner.app.V.base.BaseFragment;
import clanner.app.V.base.BaseFragmentActivity;
import clanner.app.V.fragment.SettingFragment;

/**
 * Created by Clanner on 2016/7/22.
 */
public class SettingActivity extends BaseFragmentActivity{
    @Override
    protected BaseFragment getFirstFragment() {
        return SettingFragment.newInstance();
    }
}
