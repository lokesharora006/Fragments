package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.util.Log;

import android.os.Bundle;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    TabLayout tabLayout;
    ViewPager2 viewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find ViewPager2 and TabLayout from the layout
        viewPager2 = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabs);

        // Create a list of Fragments
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new chatFragment());
        fragmentList.add(new statusFragment());
        fragmentList.add(new CallFragment());

        // Create and set up the FragmentPagerAdapter
        FragmentsPagerAdaptor fragmentsPagerAdaptor = new FragmentsPagerAdaptor(getSupportFragmentManager(), getLifecycle(), fragmentList);
        viewPager2.setAdapter(fragmentsPagerAdaptor);

        // Connect TabLayout with ViewPager2
        new TabLayoutMediator(tabLayout, viewPager2,
                (tab, position) -> {
                    switch (position) {
                        case 0:
                            tab.setText("Chat");
                            break;
                        case 1:
                            tab.setText("Status");
                            break;
                        case 2:
                            tab.setText("Call");
                            break;
                    }
                }).attach();
    }
}