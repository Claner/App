package clanner.app.V.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.OnClick;
import clanner.app.M.UrlTools;
import clanner.app.P.LoginPresenter;
import clanner.app.V.R;
import clanner.app.V.base.BaseActivity;
import clanner.app.V.view.Interface.LoginView;

/**
 * Created by Clanner on 2016/7/1.
 */
public class LoginActivity extends BaseActivity implements LoginView {
    @BindView(R.id.username_login_wrapper)
    TextInputLayout usernameLoginWrapper;
    @BindView(R.id.password_login_wrapper)
    TextInputLayout passwordLoginWrapper;
    @BindView(R.id.edt_username_login)
    EditText edtUsernameLogin;
    @BindView(R.id.edt_password_login)
    EditText edtPasswordLogin;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    private ProgressDialog progressDialog;

    private LoginPresenter loginPresenter;
    private String account;
    private String password;

    @Override
    protected int setContentViewId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        setDatas();
        initActionBar(toolbar, R.string.loginActivity_value, true);
    }

    private void setDatas() {
        usernameLoginWrapper.setHint("请输入账号");
        passwordLoginWrapper.setHint("请输入密码");
    }

    @OnClick({R.id.btn_login, R.id.tv_register})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                login();
                break;
            case R.id.tv_register:
                register();
                break;
        }
    }

    /**
     * 登陆
     */
    private void login() {
        account = edtUsernameLogin.getText().toString().trim();
        password = edtPasswordLogin.getText().toString().trim();
        loginPresenter = new LoginPresenter(this);
        loginPresenter.login(account, password);
    }

    /**
     * 注册
     */
    private void register() {
        ChangeActivity(RegisterActivity.class);
    }

    @Override
    public void showProgress() {
        progressDialog = ProgressDialog.show(this, null, "正在登陆...");
    }

    @Override
    public void hideProgress() {
        progressDialog.dismiss();
    }

    @Override
    public void loginSuccess() {
        ChangeActivity(MainActivity.class, true);
    }

    @Override
    public void loginFailure(int errorCode) {
        switch (errorCode) {
            case UrlTools.ERRORCODE_CONTENT_EMPTY:
                toast("用户民和密码不能为空");
                break;
            case UrlTools.ERRORCODE_CONTENT_WRONG:
                toast("用户名或密码错误");
                break;
            case UrlTools.ERRORCODE_REQUEST_FAILURE:
                toast("请求失败,请检查网络连接");
                break;
        }
    }
}
