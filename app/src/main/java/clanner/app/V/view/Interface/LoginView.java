package clanner.app.V.view.Interface;

/**
 * Created by Clanner on 2016/7/2.
 * 登陆需要实现的方法
 */
public interface LoginView {

    void showProgress();

    void hideProgress();

    void loginSuccess();

    void loginFailure(int errorCode);
}
