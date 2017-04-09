package com.github.nestscrolldemo.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.SwipeDismissBehavior;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

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
 * time：2017/4/9 1:20
 * des ：${TODO}
 * gitVersion：2.12.0.windows.1
 * updateAuthor：$Author$
 * updateDate：$Date$
 * updateDes：${TODO}
 * ============================================================
 */
public class SwipeDismissActivity extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipedismiss);
        tv = (TextView) findViewById(R.id.tv);

        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) tv
                .getLayoutParams();
        SwipeDismissBehavior<TextView> behavior = new SwipeDismissBehavior<>();
        params.setBehavior(behavior);

        behavior.setListener(new SwipeDismissBehavior.OnDismissListener() {
            @Override
            public void onDismiss(View view) {
                tv.setVisibility(View.GONE);
                Snackbar.make(view, "删除了一个控件", Snackbar.LENGTH_SHORT)
                        .setAction("确定", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                tv.setVisibility(View.VISIBLE);
                                ViewCompat.animate(tv).alpha(1).start();
                            }
                        })
                        .show();
            }

            @Override
            public void onDragStateChanged(int state) {

            }
        });
    }
}
