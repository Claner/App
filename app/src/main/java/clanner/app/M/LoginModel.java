package clanner.app.M.entity;

import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import clanner.app.P.LoginPresenter;
import okhttp3.Call;

/**
 * Created by Clanner on 2016/7/2.
 */
public class LoginModel {
    /**
     * 返回1表示用户名和密码不能为空
     * 返回2表示用户名或密码错误
     * 返回3表示请求失败
     */

    private LoginPresenter loginPresenter;

    public LoginModel(LoginPresenter loginPresenter){
        this.loginPresenter = loginPresenter;
    }

    public void login(String account,String password){
        if (TextUtils.isEmpty(account) || TextUtils.isEmpty(password)) {
            Log.e("Hello","用户名和密码不能为空");
            loginPresenter.loginFailue(1);
        } else {
            try {
                OkHttpUtils.post().url(UrlHelper.LOGIN_URL)
                        .addParams("username", account)
                        .addParams("password", password).build().execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e("Hello", "失败");
                        loginPresenter.loginFailue(3);
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        LoginHelper helper = new Gson().fromJson(response, LoginHelper.class);
                        int code = helper.getCode();
                        if (code == 20000) {
                            loginPresenter.loginSuccess();
                        } else {
                            loginPresenter.loginFailue(2);
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
