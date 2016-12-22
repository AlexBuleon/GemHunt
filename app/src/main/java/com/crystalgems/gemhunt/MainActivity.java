package com.crystalgems.gemhunt;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Window;
import android.view.WindowManager;

import com.apps.su.gemhunt.R;
import com.crystalgems.gemhunt.view.LobbyScreenSlidePageFragment;
import com.crystalgems.gemhunt.view.SettingsScreenSlidePageFragment;
import com.crystalgems.gemhunt.view.TitleScreenSlidePageFragment;

public class MainActivity extends FragmentActivity {

    private static final int NUM_PAGES = 3;
    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_screen_slide);

        //ViewPager and PageAdapter
        viewPager = (ViewPager) findViewById(R.id.pager);
        pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(1);

        //setContentView(R.layout.fragment_title_screen_slide_page);
    }

    @Override
    public void onBackPressed() {
        if (viewPager.getCurrentItem() == 1) {
            super.onBackPressed();
        } else {
            viewPager.setCurrentItem(1);
        }
    }

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                //Settings page
                case 0:
                    System.out.println("1");
                    return new SettingsScreenSlidePageFragment();
                //Home page
                case 1:
                    System.out.println("2");
                    return new TitleScreenSlidePageFragment();
                //Lobby page

                case 2:
                    System.out.println("3");
                    return new LobbyScreenSlidePageFragment();
                default:
                    System.err.println("Wrong menu item number.");
                    return new TitleScreenSlidePageFragment();
            }
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}
