package com.apps.su.gemhunt;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;

public class MainActivity extends FragmentActivity {

    private static final int NUM_PAGES = 5;
    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;
    private HorizontalScrollView scrollView;
    private ImageView backgroundImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_title_screen_slide_page);
        scrollView = (HorizontalScrollView) findViewById(R.id.scroll_view);
        backgroundImageView = (ImageView) findViewById(R.id.titleScreenBackground);

        setContentView(R.layout.activity_screen_slide);


        viewPager = (ViewPager) findViewById(R.id.pager);

        pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                int x = (int) ((viewPager.getWidth() * position + positionOffsetPixels) * computeFactor());
                scrollView.scrollTo(x, 0);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }

            private float computeFactor() {
                return (backgroundImageView.getWidth() - viewPager.getWidth()) /
                        (float)(viewPager.getWidth() * (viewPager.getAdapter().getCount() - 1));
            }
        });
        viewPager.setAdapter(pagerAdapter);


    }

    @Override
    public void onBackPressed() {
        if (viewPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        }
    }

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            return new TitleScreenSlidePageFragment();
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}
