package com.example.lcy.myframe.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;

import com.example.lcy.myframe.R;
import com.example.lcy.myframe.base.BaseAppCompatActivity;
import com.example.lcy.myframe.ui.fragment.FragmentCommon;
import com.example.lcy.myframe.util.ColorUtils;
import com.mikepenz.fastadapter.utils.RecyclerViewCacheUtil;
import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.itemanimators.AlphaCrossFadeAnimator;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

import butterknife.BindView;

public class MainActivity extends BaseAppCompatActivity {


    /**
     * 包结构
     * com.futurice.project
     ├─ network
     ├─ models
     ├─ managers
     ├─ utils
     ├─ fragments
     └─ views
        ├─ adapters
        ├─ actionbar
        ├─ widgets
        └─ notifications
     */
    @BindView(R.id.toolBar)
    Toolbar mToolbar;

    private long mLastPosition = -1;

    private Drawer mDrawer;

    private AccountHeader mAccountHeader;

    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_main;
    }


    @Override
    protected void initViewsAndEvents(Bundle savedInstanceState) {
        mToolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(mToolbar);
        // Create the AccountHeader
        mAccountHeader = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.mipmap.bg_head)
                .addProfiles(
                        new ProfileDrawerItem().withName("你有没有梦想").withEmail("https://github.com/chongyangliu").withIcon(ContextCompat.getDrawable(this, R.mipmap.ic_avatar))
                )
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
                        return false;
                    }
                })
                .withSavedInstance(savedInstanceState)
                .build();
        //if you want to update the items at a later time it is recommended to keep it in a variable

        //create the drawer and remember the `Drawer` result object
        mDrawer = new DrawerBuilder()
                .withAccountHeader(mAccountHeader)
                .withActivity(this)
                .withToolbar(mToolbar)
                .withHasStableIds(true)
                .withItemAnimator(new AlphaCrossFadeAnimator())
                .addDrawerItems(
                        new PrimaryDrawerItem().withIdentifier(1).withName("全部").withIcon(GoogleMaterial.Icon.gmd_select_all).withTextColor(ColorUtils.randomColor()).withSelectable(false),
                        new PrimaryDrawerItem().withIdentifier(2).withName("福利").withIcon(GoogleMaterial.Icon.gmd_face).withTextColor(ColorUtils.randomColor()).withSelectable(false),
                        new PrimaryDrawerItem().withIdentifier(3).withName("Android").withIcon(GoogleMaterial.Icon.gmd_android).withTextColor(ColorUtils.randomColor()).withSelectable(false),
                        new PrimaryDrawerItem().withIdentifier(4).withName("iOS").withIcon(GoogleMaterial.Icon.gmd_apple).withTextColor(ColorUtils.randomColor()).withSelectable(false),
                        new PrimaryDrawerItem().withIdentifier(5).withName("休息视频").withIcon(GoogleMaterial.Icon.gmd_collection_video).withTextColor(ColorUtils.randomColor()).withSelectable(false),
                        new PrimaryDrawerItem().withIdentifier(6).withName("前端").withIcon(GoogleMaterial.Icon.gmd_language_javascript).withTextColor(ColorUtils.randomColor()).withSelectable(false),
                        new PrimaryDrawerItem().withIdentifier(7).withName("拓展资源").withIcon(GoogleMaterial.Icon.gmd_more).withTextColor(ColorUtils.randomColor()).withSelectable(false),
                        new PrimaryDrawerItem().withIdentifier(8).withName("App").withIcon(GoogleMaterial.Icon.gmd_apps).withTextColor(ColorUtils.randomColor()).withSelectable(false),
                        new PrimaryDrawerItem().withIdentifier(9).withName("瞎推荐").withIcon(GoogleMaterial.Icon.gmd_book).withTextColor(ColorUtils.randomColor()).withSelectable(false)
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        // do something with the clicked item :D
                        if (position != mLastPosition) {
                            switch (position) {
                                case 1:
                                    replaceFragment(R.id.center_frame, FragmentCommon.newInstance("all"));
                                    mToolbar.setTitle("全部");
                                break;
                                case 2:
                                    replaceFragment(R.id.center_frame, FragmentCommon.newInstance("福利"));
                                    mToolbar.setTitle("福利");
                                break;
                                case 3:
                                    replaceFragment(R.id.center_frame, FragmentCommon.newInstance("Android"));
                                    mToolbar.setTitle("Android");
                                    break;
                                case 4:
                                    replaceFragment(R.id.center_frame, FragmentCommon.newInstance("iOS"));
                                    mToolbar.setTitle("iOS");
                                    break;
                                case 5:
                                    replaceFragment(R.id.center_frame, FragmentCommon.newInstance("休息视频"));
                                    mToolbar.setTitle("休息视频");
                                    break;
                                case 6:
                                    replaceFragment(R.id.center_frame, FragmentCommon.newInstance("前端"));
                                    mToolbar.setTitle("前端");
                                    break;
                                case 7:
                                    replaceFragment(R.id.center_frame, FragmentCommon.newInstance("拓展资源"));
                                    mToolbar.setTitle("拓展资源");
                                    break;
                                case 8:
                                    replaceFragment(R.id.center_frame, FragmentCommon.newInstance("App"));
                                    mToolbar.setTitle("App");
                                    break;
                                case 9:
                                    replaceFragment(R.id.center_frame, FragmentCommon.newInstance("瞎推荐"));
                                    mToolbar.setTitle("瞎推荐");
                                    break;
                            }
                            mLastPosition = position;
                        }

                        return false;
                    }
                })
                .withShowDrawerOnFirstLaunch(true)
                .withSavedInstance(savedInstanceState)
                .build();
                mDrawer.deselect();
                new RecyclerViewCacheUtil<IDrawerItem>().withCacheSize(2).apply(mDrawer.getRecyclerView(), mDrawer.getDrawerItems());
    }

    @Override
    protected void initDatas() {
        replaceFragment(R.id.center_frame, FragmentCommon.newInstance("福利"));
        mToolbar.setTitle("福利");
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //add the values which need to be saved from the drawer to the bundle
        outState = mDrawer.saveInstanceState(outState);
        //add the values which need to be saved from the accountHeader to the bundle
        outState = mAccountHeader.saveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (mDrawer != null && mDrawer.isDrawerOpen()) {
            mDrawer.closeDrawer();
            return true;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }

    /**
     * 切换fragment
     * @param layoutId  布局id
     * @param fragment  加载的fragment
     */
    public void replaceFragment(int layoutId, Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(layoutId, fragment).commitAllowingStateLoss();
    }

}
