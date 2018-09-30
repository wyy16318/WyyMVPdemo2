package sunmi.com.wyymvpdemo.presenter;

import sunmi.com.wyymvpdemo.base.BasePresenter;
import sunmi.com.wyymvpdemo.model.UserBean;
import sunmi.com.wyymvpdemo.view.LoginRegistView;

/**
 * 　　  　　　　 ┏┓       ┏┓
 * 　　　　　　　┏┛┻━━━━━━━┛┻┓
 * 　　　　　　　┃　　　　　　 ┃
 * 　　　　　　　┃　　　━　　　┃
 * 　　　　　　 █████━█████  ┃
 * 　　　　　　　┃　　　　　　 ┃
 * 　　　　　　　┃　　　┻　　　┃
 * 　　　　　　　┃　　　　　　 ┃
 * 　　　　　　　┗━━┓　　　 ┏━┛
 * 　　　　　　　　　　┃　　　┃  神兽保佑,代码无bug
 * <p>
 * Created by Administrator on 2018/9/30.
 * Created with Android Studio
 * Created By Kinsey
 * Date: 2018/9/30
 * Time: 14:48
 * 王洋洋
 */

public class LoginRegistPresenter    extends BasePresenter<LoginRegistView> {
          UserBean userBean=new UserBean();
    //登录
    public void toLogin(String username, String password) {
      //联网请求
               getView().showProgress("正在登录");

                  getView().loginSuccess(userBean);

              getView().loginFail();

        getView().hideProgress();
    }


    //注册
    public void toRegist(String username, String password) {
            //联网请求
        getView().showProgress("正在注册");

        getView().registerSuccess(userBean);

        getView().registerFail();

        getView().hideProgress();
    }


}
