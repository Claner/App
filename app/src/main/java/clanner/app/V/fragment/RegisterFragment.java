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
public class RegisterFragment extends BaseFragment {
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

    public static RegisterFragment newInstance() {
        return new RegisterFragment();
    }

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_register;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        getSwipeBackLayout().setEnableGesture(false);
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
                btnBoy.setEnabled(false);
                btnGirl.setEnabled(true);
                break;
            case R.id.btn_girl:
                btnGirl.setEnabled(false);
                btnBoy.setEnabled(true);
                break;
        }
    }

    @OnClick(R.id.toolbar_right)
    public void onClick() {
        username = edtUsernameRegister.getText().toString().trim();
        if (TextUtils.isEmpty(username)){
            toast("请输入用户名");
        }else {
            if (isBoy || isGirl){
                addFragment(RegisterFragment2.newInstance(), (BaseFragmentActivity) getActivity());
            }else {
                toast("请选择性别");
            }
        }
    }
}
