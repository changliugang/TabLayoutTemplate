package com.chang.cn.tablayouttemplate;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.tab_layout)
    TabLayout tabLayout;
    @InjectView(R.id.viewpager)
    ViewPager viewpager;
    private SimpleFragmentPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(TheSimplePageFragment.newInstance("古典"));
        fragments.add(TheSimplePageFragment.newInstance("民谣"));
        fragments.add(TheSimplePageFragment.newInstance("电音"));
        mAdapter = new SimpleFragmentPagerAdapter(getSupportFragmentManager(),this,fragments);
        viewpager.setAdapter(mAdapter);
        tabLayout.setupWithViewPager(viewpager);
    }



    public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

        private String[] mTabs;
        private List<Fragment> mFragments;

        public SimpleFragmentPagerAdapter(FragmentManager fm, Context context, List<Fragment> fragments) {
            super(fm);
            mFragments = fragments;
            mTabs = context.getResources().getStringArray(R.array.tabs);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments != null ? mFragments.get(position) : null;
        }

        @Override
        public int getCount() {
            return mTabs != null ? mTabs.length : 0;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTabs != null ? mTabs[position] : "";
        }
    }

}
