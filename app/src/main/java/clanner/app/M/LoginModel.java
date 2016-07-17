package clanner.app.M;

import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import clanner.app.M.entity.LoginHelper;
import clanner.app.P.LoginPresenter;
import okhttp3.Call;

/**
 * Created by Clanner on 2016/7/2.
 */
public class LoginModel {

    private LoginPresenter loginPresenter;

    public LoginModel(LoginPresenter loginPresenter){
        this.loginPresenter = loginPresenter;
    }

    public void login(String account,String password){
        if (TextUtils.isEmpty(account) || TextUtils.isEmpty(password)) {
            Log.e("Hello","用户名和密码不能为空");
            loginPresenter.loginFailure(UrlTools.ERRORCODE_CONTENT_EMPTY);
        } else {
            try {
                OkHttpUtils.post().url(UrlTools.LOGIN_URL)
                        .addParams("username", account)
                        .addParams("password", password).build().execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e("Hello", "失败");
                        loginPresenter.loginFailure(UrlTools.ERRORCODE_REQUEST_FAILURE);
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        LoginHelper helper = new Gson().fromJson(response, LoginHelper.class);
                        int code = helper.getCode();
                        if (code == 20000) {
                            loginPresenter.loginSuccess();
                        } else {
                            loginPresenter.loginFailure(UrlTools.ERRORCODE_CONTENT_WRONG);
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
