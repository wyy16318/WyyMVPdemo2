package sunmi.com.wyymvpdemo.view;


import sunmi.com.wyymvpdemo.model.UserBean;

/**
 * user：lqm
 * desc：登录注册
 */

public interface LoginRegistView {


    void showProgress(String tipString);

    void hideProgress();

    void loginSuccess(UserBean user);

    void registerSuccess(UserBean user);

    void loginFail();

    void registerFail();

}
