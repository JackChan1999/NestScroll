package com.github.nestscrolldemo.behavior;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

public class MyBottomBarBehavior extends CoordinatorLayout.Behavior<View> {


    public MyBottomBarBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        //这个方法是说明这个子控件是依赖AppBarLayout的
        return dependency instanceof AppBarLayout;
    }


    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        // Log.e("y",dependency.getTop()+"");
        float translationY = Math.abs(dependency.getTop());//获取更随布局的顶部位置
        child.setTranslationY(translationY);

        /*//得到依赖View的滑动距离
        int top = ((AppBarLayout.Behavior)((CoordinatorLayout.LayoutParams)dependency.getLayoutParams()).getBehavior()).getTopAndBottomOffset();
        //因为BottomNavigation的滑动与ToolBar是反向的，所以取-top值
        ViewCompat.setTranslationY(child, -top);*/

        return true;
    }

}