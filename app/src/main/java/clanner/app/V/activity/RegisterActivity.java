package clanner.app.V.activity;

import clanner.app.V.base.BaseFragment;
import clanner.app.V.base.BaseFragmentActivity;
import clanner.app.V.fragment.RegisterSwipeBackFragment;

/**
 * Created by Clanner on 2016/7/1.
 */
public class RegisterActivity extends BaseFragmentActivity {

    @Override
    protected BaseFragment getFirstFragment() {
        return RegisterSwipeBackFragment.newInstance();
    }
}
