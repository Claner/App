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
import clanner.app.V.activity.PublishDetailsActivity;
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
                custom();
                break;
            case R.id.btn_party:
                party();
                break;
            case R.id.btn_board_game:
                board_game();
                break;
            case R.id.btn_escape_game:
                escape_game();
                break;
            case R.id.btn_sport:
                sport();
                break;
            case R.id.btn_film:
                film();
                break;
            case R.id.btn_eating:
                eating();
                break;
            case R.id.btn_study:
                study();
                break;
            case R.id.btn_history:
                history();
                break;
        }
    }

    private void custom(){
        Intent intent = new Intent(getActivity(), PublishDetailsActivity.class);
        intent.putExtra("CODE", PublishEntity.ACTIVITY_CUSTOM);
        intent.putExtra("STRING","自定义");
        changeActivity(intent);
    }

    private void party(){
        Intent intent = new Intent(getActivity(), PublishDetailsActivity.class);
        intent.putExtra("CODE", PublishEntity.ACTIVITY_PARTY);
        intent.putExtra("STRING","节日派对");
        changeActivity(intent);
    }

    private void board_game(){
        Intent intent = new Intent(getActivity(), PublishDetailsActivity.class);
        intent.putExtra("CODE", PublishEntity.ACTIVITY_BOARD_GAME);
        intent.putExtra("STRING","桌游");
        changeActivity(intent);
    }

    private void escape_game(){
        Intent intent = new Intent(getActivity(), PublishDetailsActivity.class);
        intent.putExtra("CODE", PublishEntity.ACTIVITY_ESCAPE_GAME);
        intent.putExtra("STRING","密室逃脱");
        changeActivity(intent);
    }

    private void sport(){
        Intent intent = new Intent(getActivity(), PublishDetailsActivity.class);
        intent.putExtra("CODE", PublishEntity.ACTIVITY_SPORT);
        intent.putExtra("STRING","运动");
        changeActivity(intent);
    }

    private void film(){
        Intent intent = new Intent(getActivity(), PublishDetailsActivity.class);
        intent.putExtra("CODE", PublishEntity.ACTIVITY_FILM);
        intent.putExtra("STRING","电影");
        changeActivity(intent);
    }

    private void eating(){
        Intent intent = new Intent(getActivity(), PublishDetailsActivity.class);
        intent.putExtra("CODE", PublishEntity.ACTIVITY_EATING);
        intent.putExtra("STRING","聚餐");
        changeActivity(intent);
    }

    private void study(){
        Intent intent = new Intent(getActivity(), PublishDetailsActivity.class);
        intent.putExtra("CODE", PublishEntity.ACTIVITY_STUDY);
        intent.putExtra("STRING","学习");
        changeActivity(intent);
    }

    private void history(){
        Intent intent = new Intent(getActivity(), PublishDetailsActivity.class);
        intent.putExtra("CODE", PublishEntity.ACTIVITY_HISTORY);
        intent.putExtra("STRING","历史纪录");
        changeActivity(intent);
    }
}
