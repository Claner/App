package clanner.app.V.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import clanner.app.M.entity.PublishEntity;
import clanner.app.V.R;
import clanner.app.V.base.BaseActivity;

/**
 * Created by Clanner on 2016/7/18.
 */
public class PublishDetailsActivity extends BaseActivity {

    @BindView(R.id.edt_publish_content)
    EditText edtPublishContent;
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar_right)
    TextView toolbarRight;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected int setContentViewId() {
        return R.layout.activity_publish;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        setEdtPublishContent();
        setActionBar();
        initActionBar(toolbar,"",true);
    }

    private void setEdtPublishContent() {
        switch (getIntent().getIntExtra("CODE", PublishEntity.ACTIVITY_ERROR)) {
            case PublishEntity.ACTIVITY_CUSTOM:
                edtPublishContent.setHint(getIntent().getStringExtra("STRING"));
                break;
            case PublishEntity.ACTIVITY_PARTY:
                edtPublishContent.setText(getIntent().getStringExtra("STRING"));
                edtPublishContent.setEnabled(false);
                break;
            case PublishEntity.ACTIVITY_BOARD_GAME:
                edtPublishContent.setText(getIntent().getStringExtra("STRING"));
                edtPublishContent.setEnabled(false);
                break;
            case PublishEntity.ACTIVITY_ESCAPE_GAME:
                edtPublishContent.setText(getIntent().getStringExtra("STRING"));
                edtPublishContent.setEnabled(false);
                break;
            case PublishEntity.ACTIVITY_SPORT:
                edtPublishContent.setText(getIntent().getStringExtra("STRING"));
                edtPublishContent.setEnabled(false);
                break;
            case PublishEntity.ACTIVITY_FILM:
                edtPublishContent.setText(getIntent().getStringExtra("STRING"));
                edtPublishContent.setEnabled(false);
                break;
            case PublishEntity.ACTIVITY_EATING:
                edtPublishContent.setText(getIntent().getStringExtra("STRING"));
                edtPublishContent.setEnabled(false);
                break;
            case PublishEntity.ACTIVITY_STUDY:
                edtPublishContent.setText(getIntent().getStringExtra("STRING"));
                edtPublishContent.setEnabled(false);
                break;
            case PublishEntity.ACTIVITY_HISTORY:
                edtPublishContent.setText(getIntent().getStringExtra("STRING"));
                break;
        }
    }

    private void setActionBar() {
        initActionBar(toolbar,"",true);
        toolbarTitle.setText("活动详情");
        toolbarRight.setText("发布");
    }
}
