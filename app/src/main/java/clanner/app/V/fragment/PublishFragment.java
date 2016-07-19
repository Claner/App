package clanner.app.V.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import clanner.app.M.entity.PublishEntity;
import clanner.app.V.R;
import clanner.app.V.activity.PublishActivity;
import clanner.app.V.base.BaseFragment;

/**
 * Created by Clanner on 2016/7/15.
 */
public class PublishFragment extends BaseFragment {

    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    public static PublishFragment newInstance() {
        return new PublishFragment();
    }

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_publish;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        setActionBar();
    }

    private void setActionBar() {
        initActionBar(toolbar, "");
        toolbarTitle.setText(R.string.bottom_publish_value);
    }

    @OnClick({R.id.btn_custom, R.id.btn_party, R.id.btn_board_game, R.id.btn_escape_game, R.id.btn_sport, R.id.btn_film, R.id.btn_eating, R.id.btn_study, R.id.btn_history})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_custom:
                changeActivity(PublishEntity.FRAGMENT_CUSTOM);
                break;
            case R.id.btn_party:
                changeActivity(PublishEntity.FRAGMENT_PATY);
                break;
            case R.id.btn_board_game:
                changeActivity(PublishEntity.FRAGMENT_BOARD_GAME);
                break;
            case R.id.btn_escape_game:
                changeActivity(PublishEntity.FRAGMENT_ESCAPE_GAME);
                break;
            case R.id.btn_sport:
                changeActivity(PublishEntity.FRAGMENT_SPORT);
                break;
            case R.id.btn_film:
                changeActivity(PublishEntity.FRAGMENT_FILM);
                break;
            case R.id.btn_eating:
                changeActivity(PublishEntity.FRAGMENT_EATING);
                break;
            case R.id.btn_study:
                changeActivity(PublishEntity.FRAGMENT_STUDY);
                break;
            case R.id.btn_history:
                changeActivity(PublishEntity.FRAGMENT_HISTORY);
                break;
        }
    }

    private void changeActivity(int fragmentCode){
        Intent intent = new Intent(getActivity(), PublishActivity.class);
        intent.putExtra("fragmentCode", fragmentCode);
        getActivity().startActivity(intent);
    }
}
