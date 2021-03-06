package com.crystalgems.gemhunt.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.apps.su.gemhunt.R;

public class MainActivity extends FragmentActivity {

    private static final int NUM_PAGES = 3;
    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;

    private SettingsScreenSlidePageFragment settingsScreenSlidePageFragment;
    private TitleScreenSlidePageFragment titleScreenSlidePageFragment;
    private LobbyScreenSlidePageFragment lobbyScreenSlidePageFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_slide);

        settingsScreenSlidePageFragment = new SettingsScreenSlidePageFragment();
        titleScreenSlidePageFragment = new TitleScreenSlidePageFragment();
        lobbyScreenSlidePageFragment = new LobbyScreenSlidePageFragment();

        //ViewPager and PageAdapter
        viewPager = (ViewPager) findViewById(R.id.pager);
        pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(1);
    }

    @Override
    protected void onStart() {
        super.onStart();
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN |
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }

    @Override
    public void onBackPressed() {
        if (viewPager.getCurrentItem() == 1) {
            super.onBackPressed();
        } else {
            viewPager.setCurrentItem(1);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (intent != null)
            lobbyScreenSlidePageFragment.setCharacter(intent.getIntExtra("buttonID", 0), intent.getIntExtra("pictureID", 0), intent.getStringExtra("name"));
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
                    return settingsScreenSlidePageFragment;
                //Home page
                case 1:
                    return titleScreenSlidePageFragment;
                //Lobby page

                case 2:
                    return lobbyScreenSlidePageFragment;
                default:
                    System.err.println("Wrong menu item number.");
                    return titleScreenSlidePageFragment;
            }
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}
