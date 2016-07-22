package clanner.app.V.fragment;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import clanner.app.V.R;
import clanner.app.V.base.BaseFragment;
import clanner.app.V.base.BaseFragmentActivity;

/**
 * Created by Clanner on 2016/7/1.
 */
public class RegisterSwipeBackFragment extends BaseFragment {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.edt_username_register)
    EditText edtUsernameRegister;
    @BindView(R.id.edt_username_register_wrapper)
    TextInputLayout edtUsernameRegisterWrapper;
    @BindView(R.id.btn_boy)
    LinearLayout btnBoy;
    @BindView(R.id.btn_girl)
    LinearLayout btnGirl;
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar_right)
    TextView toolbarRight;

    private boolean isBoy = false;
    private boolean isGirl = false;
    private String username;
    private String sex;

    public static RegisterSwipeBackFragment newInstance() {
        return new RegisterSwipeBackFragment();
    }

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_register;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        setDatas();
        initActionBar(toolbar, "", true);
    }

    private void setDatas() {
        edtUsernameRegisterWrapper.setHint("请输入用户名");
        toolbarTitle.setText("注册(1/3)");
        toolbarRight.setText("下一步");
    }

    @OnClick({R.id.btn_boy, R.id.btn_girl})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_boy:
                setBoy();
                break;
            case R.id.btn_girl:
                setGirl();
                break;
        }
    }

    private void setBoy(){
        btnBoy.setEnabled(false);
        btnGirl.setEnabled(true);
        isBoy = true;
        sex = "m";
    }

    private void setGirl(){
        btnGirl.setEnabled(false);
        btnBoy.setEnabled(true);
        sex = "f";
        isGirl = true;
    }

    @OnClick(R.id.toolbar_right)
    public void onClick() {
        username = edtUsernameRegister.getText().toString().trim();
        if (TextUtils.isEmpty(username)) {
            toast("请输入用户名");
        } else {
            if (isBoy || isGirl) {
                addFragment(new RegisterSwipeBackFragment2(username, sex), (BaseFragmentActivity) getActivity());
            } else {
                toast("请选择性别");
            }
        }
    }

}
