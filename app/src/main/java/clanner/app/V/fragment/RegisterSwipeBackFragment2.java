package clanner.app.V.fragment;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import clanner.app.V.R;
import clanner.app.V.base.BaseFragment;

/**
 * Created by Clanner on 2016/7/1.
 */
public class RegisterSwipeBackFragment2 extends BaseFragment {
    @BindView(R.id.edt_account_register)
    EditText edtAccountRegister;
    @BindView(R.id.account_register_wrapper)
    TextInputLayout accountRegisterWrapper;
    @BindView(R.id.edt_password_register)
    EditText edtPasswordRegister;
    @BindView(R.id.password_register_wrapper)
    TextInputLayout passwordRegisterWrapper;
    @BindView(R.id.edt_surePassword_register)
    EditText edtSurePasswordRegister;
    @BindView(R.id.surePassword_register_warpper)
    TextInputLayout surePasswordRegisterWarpper;
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar_right)
    TextView toolbarRight;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private String username;
    private String sex;

    public RegisterSwipeBackFragment2(String username, String sex) {
        this.username = username;
        this.sex = sex;
    }

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_register2;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        initActionBar(toolbar, "", false);
        setDatas();
    }

    private void setDatas() {
        toolbarTitle.setText("注册（2/3）");
        toolbarRight.setText("下一步");
        accountRegisterWrapper.setHint("请输入用户名");
        passwordRegisterWrapper.setHint("请输入密码");
        surePasswordRegisterWarpper.setHint("请确认密码");
    }
}
