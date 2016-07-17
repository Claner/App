package clanner.app.P;

import clanner.app.M.LoginModel;
import clanner.app.V.view.Interface.LoginView;

/**
 * Created by Clanner on 2016/7/2.
 */
public class LoginPresenter {
    private LoginView loginView;
    private LoginModel loginModel;

    public LoginPresenter(LoginView loginView){
        this.loginView = loginView;
        loginModel = new LoginModel(this);
    }

    public void login(String account,String password){
        loginView.showProgress();
        loginModel.login(account,password);
    }

    public void loginSuccess(){
        loginView.loginSuccess();
        loginView.hideProgress();
    }

    public void loginFailure(int errorCode){
        loginView.loginFailure(errorCode);
        loginView.hideProgress();
    }

    public void detachView(){
        this.loginView = null;
    }
}
