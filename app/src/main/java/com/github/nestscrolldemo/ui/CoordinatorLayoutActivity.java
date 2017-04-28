package com.github.nestscrolldemo.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.NestedScrollingChild;
import android.support.v4.view.NestedScrollingChildHelper;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.nestscrolldemo.R;

public class CoordinatorLayoutActivity extends AppCompatActivity {

    Toolbar mToolbar;

    // @CoordinatorLayout.DefaultBehavior(AppBarLayout.ScrollingViewBehavior.class)
    RecyclerView mRecyclerView;

    TextView tv;

    TabLayout mTabLayout;

    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        tv = (TextView) findViewById(R.id.tv);
        mViewPager = (ViewPager) findViewById(R.id.vp);

        mTabLayout = (TabLayout) findViewById(R.id.tab);

        mViewPager.setAdapter(new TabAdapter());
        mTabLayout.setupWithViewPager(mViewPager);


      /*  mRecyclerView = (RecyclerView) findViewById(R.id.rv);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new MyAdapter());*/

        /*CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) tv
        .getLayoutParams();
        params.setBehavior(new MyBehavior());*/

       /* AppBarLayout.LayoutParams params;
        params.setScrollFlags();*/

    }


    class TabAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            RecyclerView recyclerView = new RecyclerView(CoordinatorLayoutActivity.this);
            recyclerView.setLayoutManager(new LinearLayoutManager(CoordinatorLayoutActivity.this));
            recyclerView.setAdapter(new MyAdapter());
            container.addView(recyclerView);
            return recyclerView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "标签" + position;
        }
    }

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

        @Override
        public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(CoordinatorLayoutActivity.this).inflate(R.layout
                    .item_list, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
            holder.setDataAndRefreshUI(position);
        }

        @Override
        public int getItemCount() {
            return 100;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            TextView tv_title;

            public ViewHolder(View itemView) {
                super(itemView);
                tv_title = (TextView) itemView.findViewById(R.id.title);
            }

            public void setDataAndRefreshUI(int pos) {
                tv_title.setText("item " + pos);
            }
        }
    }

    class NestBehavior extends CoordinatorLayout.Behavior implements NestedScrollingChild {

        NestedScrollingChildHelper mHelper;

        public NestBehavior() {
        }

        public NestBehavior(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        @Override
        public boolean onTouchEvent(CoordinatorLayout parent, View child, MotionEvent ev) {

            if (mHelper == null) {
                mHelper = new NestedScrollingChildHelper(child);
                setNestedScrollingEnabled(true);
            }

            return super.onTouchEvent(parent, child, ev);
        }

        @Override
        public void setNestedScrollingEnabled(boolean enabled) {
            mHelper.setNestedScrollingEnabled(enabled);
        }

        @Override
        public boolean isNestedScrollingEnabled() {
            return mHelper.isNestedScrollingEnabled();
        }

        @Override
        public boolean startNestedScroll(int axes) {
            return mHelper.startNestedScroll(axes);
        }

        @Override
        public void stopNestedScroll() {
            mHelper.stopNestedScroll();
        }

        @Override
        public boolean hasNestedScrollingParent() {
            return mHelper.hasNestedScrollingParent();
        }

        @Override
        public boolean dispatchNestedScroll(int dxConsumed, int dyConsumed, int dxUnconsumed, int
                dyUnconsumed, int[] offsetInWindow) {
            return mHelper.dispatchNestedScroll(dxConsumed, dyConsumed, dxUnconsumed,
                    dyUnconsumed, offsetInWindow);
        }

        @Override
        public boolean dispatchNestedPreScroll(int dx, int dy, int[] consumed, int[]
                offsetInWindow) {
            return mHelper.dispatchNestedPreScroll(dx, dy, consumed, offsetInWindow);
        }

        @Override
        public boolean dispatchNestedFling(float velocityX, float velocityY, boolean consumed) {
            return mHelper.dispatchNestedFling(velocityX, velocityY, consumed);
        }

        @Override
        public boolean dispatchNestedPreFling(float velocityX, float velocityY) {
            return mHelper.dispatchNestedPreFling(velocityX, velocityY);
        }
    }
}
