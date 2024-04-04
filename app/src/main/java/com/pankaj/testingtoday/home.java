package com.pankaj.testingtoday;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class home extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 viewPager2;
    MyViewPagerAdapter myViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tabLayout = findViewById(R.id.tab_layout);
        viewPager2 = findViewById(R.id.view_pager);

        // Create and add tabs
        TabLayout.Tab tab1 = tabLayout.newTab();
        TabLayout.Tab tab2 = tabLayout.newTab();
        TabLayout.Tab tab3 = tabLayout.newTab();
        TabLayout.Tab tab4 = tabLayout.newTab();
        TabLayout.Tab tab5 = tabLayout.newTab();

        tabLayout.addTab(tab1);
        tabLayout.addTab(tab2);
        tabLayout.addTab(tab3);
        tabLayout.addTab(tab4);
        tabLayout.addTab(tab5);

        // Set custom views for tabs
        tab1.setCustomView(R.layout.custom_tab_item);
        tab2.setCustomView(R.layout.custom_tab_item);
        tab3.setCustomView(R.layout.custom_tab_item);
        tab4.setCustomView(R.layout.custom_tab_item);
        tab5.setCustomView(R.layout.custom_tab_item);

        // Find views within custom tab layout
        TextView tabText1 = tab1.getCustomView().findViewById(R.id.tab_text);
        ImageView tabIcon1 = tab1.getCustomView().findViewById(R.id.tab_icon);
        TextView tabText2 = tab2.getCustomView().findViewById(R.id.tab_text);
        ImageView tabIcon2 = tab2.getCustomView().findViewById(R.id.tab_icon);
        TextView tabText3 = tab3.getCustomView().findViewById(R.id.tab_text);
        ImageView tabIcon3 = tab3.getCustomView().findViewById(R.id.tab_icon);
        TextView tabText4 = tab4.getCustomView().findViewById(R.id.tab_text);
        ImageView tabIcon4 = tab4.getCustomView().findViewById(R.id.tab_icon);
        TextView tabText5 = tab5.getCustomView().findViewById(R.id.tab_text);
        ImageView tabIcon5 = tab5.getCustomView().findViewById(R.id.tab_icon);

        // Set text and icon for each tab
        tabText1.setText("Journey Ticket");
        tabIcon1.setImageResource(R.drawable.baseline_train_24);
        tabText2.setText("QR Ticket");
        tabIcon2.setImageResource(R.drawable.baseline_train_24);
        tabText3.setText("Quick Ticket");
        tabIcon3.setImageResource(R.drawable.baseline_train_24);
        tabText4.setText("Platform Ticket");
        tabIcon4.setImageResource(R.drawable.baseline_train_24);
        tabText5.setText("Season Ticket");
        tabIcon5.setImageResource(R.drawable.baseline_train_24);

        myViewPagerAdapter = new MyViewPagerAdapter(this);
        viewPager2.setAdapter(myViewPagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}

            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });
    }

}
