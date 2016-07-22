package clanner.app.V.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import clanner.app.V.R;
import clanner.app.V.base.BaseFragment;

/**
 * Created by Clanner on 2016/7/15.
 */
public class HighlightFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.swipeContainer)
    SwipeRefreshLayout swipeContainer;

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
        setRecyclerView();
    }

    private void setActionBar() {
        initActionBar(toolbar, "");
        toolbarTitle.setText(R.string.bottom_highlight_value);
    }

    private void setRecyclerView() {
        swipeContainer.setColorSchemeColors(android.R.color.holo_blue_light,
                android.R.color.holo_red_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_green_light);
        swipeContainer.setOnRefreshListener(this);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void onRefresh() {
        Log.e("Hello","正在刷新");
    }
}
