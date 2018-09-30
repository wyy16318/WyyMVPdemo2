package sunmi.com.wyymvpdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import sunmi.com.wyymvpdemo.base.BaseActivity;
import sunmi.com.wyymvpdemo.model.UserBean;
import sunmi.com.wyymvpdemo.presenter.LoginRegistPresenter;
import sunmi.com.wyymvpdemo.utils.T;
import sunmi.com.wyymvpdemo.view.LoginRegistView;

public class MainActivity extends BaseActivity<LoginRegistView,LoginRegistPresenter> implements LoginRegistView,View.OnClickListener {

    private TextView tv_name;
    private EditText et_name;
    private TextView tv_password;
    private EditText et_password;
    private Button btn_regist;
    private Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    @Override
    public void initView() {
        tv_name = (TextView) findViewById(R.id.tv_name);
        et_name = (EditText) findViewById(R.id.et_name);
        tv_password = (TextView) findViewById(R.id.tv_password);
        et_password = (EditText) findViewById(R.id.et_password);
        btn_regist = (Button) findViewById(R.id.btn_regist);
        btn_login = (Button) findViewById(R.id.btn_login);

        btn_regist.setOnClickListener(this);
        btn_login.setOnClickListener(this);
    }

    @Override
    protected LoginRegistPresenter createPresenter() {
        return new LoginRegistPresenter();
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_main;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_regist:

                break;
            case R.id.btn_login:
                submit();
                break;
                default:
                    break;
        }
    }

    private void submit() {
        // validate
        String name = et_name.getText().toString().trim();
        if (TextUtils.isEmpty(name)) {
            Toast.makeText(this, "name不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String password = et_password.getText().toString().trim();
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "password不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    @Override
    public void showProgress(String tipString) {
        showWaitingDialog(tipString);
    }

    @Override
    public void hideProgress() {
        hideWaitingDialog();
    }

    @Override
    public void loginSuccess(UserBean user) {
         Toast.makeText(MainActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void registerSuccess(UserBean user) {
        Toast.makeText(MainActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginFail() {
        T.showShort(MainActivity.this,"登录失败");
    }

    @Override
    public void registerFail() {
       T.showShort(MainActivity.this,"注册失败");
    }
}
