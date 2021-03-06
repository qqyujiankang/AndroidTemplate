package com.cn.android.ui.activity;

import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

import com.cn.android.R;
import com.cn.android.common.MyActivity;
import com.cn.android.common.MyLazyFragment;
import com.cn.android.helper.ActivityStackManager;
import com.cn.android.helper.DoubleClickHelper;
import com.cn.android.other.KeyboardWatcher;
import com.cn.android.ui.fragment.ClassifyFragment;
import com.cn.android.ui.fragment.HomePageFragment;
import com.cn.android.ui.fragment.PersonalCenterFragment;
import com.cn.android.ui.fragment.ShoppingTrolleyFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.hjq.base.BaseFragmentAdapter;
import com.hjq.widget.layout.NoScrollViewPager;

import butterknife.BindView;

/**
 * author : Android 轮子哥
 * github : https://github.com/getActivity/AndroidProject
 * time   : 2018/10/18
 * desc   : 主页界面
 */
public final class HomeActivity extends MyActivity
        implements ViewPager.OnPageChangeListener,
        BottomNavigationView.OnNavigationItemSelectedListener,
        KeyboardWatcher.SoftKeyboardStateListener {

    @BindView(R.id.vp_home_pager)
    NoScrollViewPager mViewPager;
    @BindView(R.id.bv_home_navigation)
    BottomNavigationView mBottomNavigationView;
    public ClassifyFragment classifyFragment = new ClassifyFragment();


    /**
     * ViewPager 适配器
     */
    private BaseFragmentAdapter<MyLazyFragment> mPagerAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    private int anInt = 0;

    @Override
    protected void initView() {

        mViewPager.addOnPageChangeListener( this );
        mViewPager.setNoScroll( true );


        // 不使用图标默认变色
        mBottomNavigationView.setItemIconTintList( null );
        mBottomNavigationView.setOnNavigationItemSelectedListener( this );

        KeyboardWatcher.with( this )
                .setListener( this );
    }

    @Override
    protected void initData() {
        mPagerAdapter = new BaseFragmentAdapter<>( this );
        mPagerAdapter.addFragment( HomePageFragment.newInstance() );
        mPagerAdapter.addFragment( classifyFragment );
        mPagerAdapter.addFragment( ShoppingTrolleyFragment.newInstance() );
        mPagerAdapter.addFragment( PersonalCenterFragment.newInstance() );

        mViewPager.setAdapter( mPagerAdapter );

        // 限制页面数量
        mViewPager.setOffscreenPageLimit( mPagerAdapter.getCount() );
    }

    public void onFragmentClick(int position) {
        mViewPager.setCurrentItem( 1 );
        mBottomNavigationView.setSelectedItemId( R.id.home_found );
        classifyFragment.onClick( position );
    }

    /**
     * {@link ViewPager.OnPageChangeListener}
     */

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {

        switch (position) {
            case 0:
                mBottomNavigationView.setSelectedItemId( R.id.menu_home );
                break;
            case 1:
                mBottomNavigationView.setSelectedItemId( R.id.home_found );
                break;
            case 2:
                if (isLogin()) {
                    mBottomNavigationView.setSelectedItemId( R.id.home_message );
                }else {
                    startActivity( TheloginIdActivity.class );
                   // ActivityStackManager.getInstance().finishAllActivities( TheloginIdActivity.class );
                }
                break;
            case 3:
                if (isLogin()) {
                    mBottomNavigationView.setSelectedItemId( R.id.home_me );
                } else {
                    startActivity( TheloginIdActivity.class );
                 //   ActivityStackManager.getInstance().finishAllActivities( TheloginIdActivity.class );
                }

                break;

        }


    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }

    /**
     * {@link BottomNavigationView.OnNavigationItemSelectedListener}
     */

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_home:
                mViewPager.setCurrentItem( 0 );
                return true;
            case R.id.home_found:
                mViewPager.setCurrentItem( 1 );
                return true;
            case R.id.home_message:
                if (isLogin()) {
                    mViewPager.setCurrentItem( 2 );
                }else {
                    startActivity( TheloginIdActivity.class );
                    //ActivityStackManager.getInstance().finishAllActivities( TheloginIdActivity.class );
                }
                return true;
            case R.id.home_me:
                if (isLogin()) {
                    mViewPager.setCurrentItem( 3 );
                } else {
                    startActivity( TheloginIdActivity.class );
                    //ActivityStackManager.getInstance().finishAllActivities( TheloginIdActivity.class );
                }
                return true;
//

        }
        return false;
    }

    /**
     * {@link KeyboardWatcher.SoftKeyboardStateListener}
     */
    @Override
    public void onSoftKeyboardOpened(int keyboardHeight) {
        mBottomNavigationView.setVisibility( View.GONE );
    }

    @Override
    public void onSoftKeyboardClosed() {
        mBottomNavigationView.setVisibility( View.VISIBLE );
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // 回调当前 Fragment 的 onKeyDown 方法
        if (mPagerAdapter.getCurrentFragment().onKeyDown( keyCode, event )) {
            return true;
        }
        return super.onKeyDown( keyCode, event );
    }

    @Override
    public void onBackPressed() {
        if (DoubleClickHelper.isOnDoubleClick()) {
            //移动到上一个任务栈，避免侧滑引起的不良反应
            moveTaskToBack( false );
            postDelayed( new Runnable() {

                @Override
                public void run() {
                    // 进行内存优化，销毁掉所有的界面
                    ActivityStackManager.getInstance().finishAllActivities();
                    // 销毁进程（请注意：调用此 API 可能导致当前 Activity onDestroy 方法无法正常回调）
                    // System.exit(0);
                }
            }, 300 );
        } else {
            toast( R.string.home_exit_hint );
        }
    }

    @Override
    protected void onDestroy() {
        mViewPager.removeOnPageChangeListener( this );
        mViewPager.setAdapter( null );
        mBottomNavigationView.setOnNavigationItemSelectedListener( null );
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();


    }


}