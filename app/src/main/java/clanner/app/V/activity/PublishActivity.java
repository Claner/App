package clanner.app.V.activity;

import android.content.Intent;

import clanner.app.M.entity.PublishEntity;
import clanner.app.V.base.BaseFragment;
import clanner.app.V.base.BaseFragmentActivity;

/**
 * Created by Clanner on 2016/7/18.
 */
public class PublishActivity extends BaseFragmentActivity{
    @Override
    protected BaseFragment getFirstFragment() {
        Intent intent = getIntent();
        int code = intent.getIntExtra("fragmentCode",PublishEntity.FRAGMENT_ERROR);
        return SwitchFragment(code);
    }

    private BaseFragment SwitchFragment(int fragmentCode){
        switch (fragmentCode){
            case PublishEntity.FRAGMENT_CUSTOM:
                break;
            case PublishEntity.FRAGMENT_PATY:
                break;
            case PublishEntity.FRAGMENT_BOARD_GAME:
                break;
            case PublishEntity.FRAGMENT_ESCAPE_GAME:
                break;
            case PublishEntity.FRAGMENT_SPORT:
                break;
            case PublishEntity.FRAGMENT_FILM:
                break;
            case PublishEntity.FRAGMENT_EATING:
                break;
            case PublishEntity.FRAGMENT_STUDY:
                break;
            case PublishEntity.FRAGMENT_HISTORY:
                break;
        }
        return null;
    }
}
