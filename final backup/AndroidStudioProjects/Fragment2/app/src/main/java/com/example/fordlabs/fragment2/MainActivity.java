package com.example.fordlabs.fragment2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements  Frag1.OnFragmentInteractionListener {

    static Frag1 fragOne = new Frag1();
    static Frag2 fragTwo = new Frag2();
    MyPagerAdapter myPagerAdapter;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(myPagerAdapter);

    }

    @Override
    public void onFragmentInteraction(String name, String desc) {
        fragTwo.onFragmentInteraction(name, desc);
    }


    public class MyPagerAdapter extends FragmentPagerAdapter implements Frag1.OnFragmentInteractionListener {


        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return fragOne;
                case 1:
                    return fragTwo;
                default:
                    return fragOne;
            }
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "Page " + position;
        }

        @Override
        public void onFragmentInteraction(String name, String desc) {
            fragTwo.onFragmentInteraction(name, desc);
        }
    }

}


