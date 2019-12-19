package com.example.oun1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.oun1.Adapter.FragmentAdapter;
import com.example.oun1.Fragment.CollectFragment;
import com.example.oun1.Fragment.HomeFragment;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private NavigationView drawer_nested;
    private DrawerLayout deawer;
    private ActionBarDrawerToggle toggle;
    private Toolbar toolbar;
    private ViewPager mvp;
    private TabLayout tab;
    private ArrayList<Fragment> fragments;
    private ArrayList<String> titleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initFragment();
    }

    private void initFragment() {
        fragments = new ArrayList<>();
        titleList = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new HomeFragment());
        fragments.add(new HomeFragment());
        fragments.add(new HomeFragment());
        fragments.add(new HomeFragment());
        fragments.add(new HomeFragment());
        titleList.add("第1个");
        titleList.add("第2个");
        titleList.add("第3个");
        titleList.add("第4个");
        titleList.add("第5个");
        titleList.add("第6个");
        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager(), fragments, titleList);
        mvp.setAdapter(adapter);
        //adapter.notifyDataSetChanged();
        tab.setTabMode(TabLayout.MODE_FIXED);
        tab.setupWithViewPager(mvp);

    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        mvp = (ViewPager) findViewById(R.id.mvp);
        tab = (TabLayout) findViewById(R.id.tab);
        drawer_nested = (NavigationView) findViewById(R.id.drawer_nested);
        deawer = (DrawerLayout) findViewById(R.id.deawer);
        //显示抽屉中图片的代码
        drawer_nested.setItemIconTintList(null);

        toolbar.setTitle("首页");
        setSupportActionBar(toolbar);
        toggle = new ActionBarDrawerToggle(this, deawer, toolbar, R.string.ok, R.string.no);
        deawer.addDrawerListener(toggle);
        toggle.syncState();
        drawer_nested.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {              //view点击事件
                    case R.id.icon_1:
                        Toast.makeText(MainActivity.this, "icon_1", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.icon_2:
                        Toast.makeText(MainActivity.this, "icon_2", Toast.LENGTH_SHORT).show();

                        break;
                    case R.id.icon_3:
                        Toast.makeText(MainActivity.this, "icon_3", Toast.LENGTH_SHORT).show();

                        break;
                    case R.id.icon_4:

                        Toast.makeText(MainActivity.this, "icon_4", Toast.LENGTH_SHORT).show();
                        break;

                    default:
                        break;
                }
                return false;
            }
        });
    }
}
