package com.github.nestscrolldemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.github.nestscrolldemo.R;

/**
 * ============================================================
 * Copyright：${TODO}有限公司版权所有 (c) 2017
 * Author：   AllenIverson
 * Email：    815712739@qq.com
 * GitHub：   https://github.com/JackChen1999
 * GitBook：  https://www.gitbook.com/@alleniverson
 * 博客：     http://blog.csdn.net/axi295309066
 * 微博：     AndroidDeveloper
 * <p>
 * Project_Name：NestScrollDemo
 * Package_Name：com.github.nestscrolldemo
 * Version：1.0
 * time：2017/4/9 17:41
 * des ：${TODO}
 * gitVersion：2.12.0.windows.1
 * updateAuthor：$Author$
 * updateDate：$Date$
 * updateDes：${TODO}
 * ============================================================
 */
public class MainActivity extends AppCompatActivity {

    Toolbar mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
    }


    public void click(View btn) {

        switch (btn.getId()) {
            case R.id.btn1:
                goToActivity(CoordinatorLayoutActivity.class);
                break;
            case R.id.btn2:
                goToActivity(SwipeDismissActivity.class);
                break;
            case R.id.btn3:
                goToActivity(CustomBehaviorActivity.class);
                break;
            case R.id.btn4:
                break;
        }
    }

    public void goToActivity(Class activity) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);
    }
}
