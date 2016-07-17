package clanner.app.V.fragment;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import clanner.app.V.R;
import clanner.app.V.base.BaseFragment;

/**
 * Created by Clanner on 2016/7/15.
 */
public class HighlightFragment extends BaseFragment {

    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    public static HighlightFragment newInstance() {
        return new HighlightFragment();
    }

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_highlight;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        setActionBar();
    }

    private void setActionBar() {
        initActionBar(toolbar,"");
        toolbarTitle.setText(R.string.bottom_highlight_value);
    }
}
