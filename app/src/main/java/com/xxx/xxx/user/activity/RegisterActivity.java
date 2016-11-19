package com.xxx.xxx.user.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.xxx.xxx.R;
import com.xxx.xxx.base.BaseActivity;

public class RegisterActivity extends BaseActivity implements View.OnClickListener {

    private TextView tvTitle;
    private ImageView ivLeft;
    private ImageView ivRight;
    private Button btnRegister;

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_register);
        tvTitle = $(R.id.tv_title);
        ivLeft = $(R.id.iv_left);
        ivRight = $(R.id.iv_right);
        btnRegister = $(R.id.btn_register);

        ivLeft.setOnClickListener(this);
        btnRegister.setOnClickListener(this);

        ivLeft.setVisibility(View.VISIBLE);
        tvTitle.setText("用户注册");
    }

    @Override
    protected void loadData() {
        super.loadData();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_left:
                Toast.makeText(RegisterActivity.this, "返回", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_register:
                Toast.makeText(RegisterActivity.this, "注册", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
