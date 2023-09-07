package com.example.fpoly.metmoi.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.fpoly.metmoi.adapter.MenuAdapter;
import com.example.fpoly.metmoi.fragment.NavigationFragment;
import com.example.fpoly.R;
import com.example.fpoly.metmoi.fragment.QuizFragment;
import com.example.fpoly.metmoi.fragment.SMSFragment;
import com.example.fpoly.metmoi.fragment.SettingFragment;

import java.util.ArrayList;
import java.util.Arrays;

import nl.psdcompany.duonavigationdrawer.views.DuoDrawerLayout;
import nl.psdcompany.duonavigationdrawer.views.DuoMenuView;
import nl.psdcompany.duonavigationdrawer.widgets.DuoDrawerToggle;


public class NavigationDrawerActivity extends AppCompatActivity implements DuoMenuView.OnClickListener {

    private DuoDrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
        init();

    }

    private void init() {

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = (DuoDrawerLayout) findViewById(R.id.drawer);
        DuoDrawerToggle drawerToggle = new DuoDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);

        drawerLayout.setDrawerListener(drawerToggle);
        drawerToggle.syncState();

        View contentView = drawerLayout.getContentView();
        View menuView = drawerLayout.getMenuView();

        LinearLayout ll_Home = menuView.findViewById(R.id.ll_Home);
        LinearLayout ll_Profile = menuView.findViewById(R.id.ll_Profile);
        LinearLayout ll_Setting = menuView.findViewById(R.id.ll_Setting);
        LinearLayout ll_Share = menuView.findViewById(R.id.ll_Share);
        LinearLayout ll_Logout = menuView.findViewById(R.id.ll_Logout);


        ll_Home.setOnClickListener(this);
        ll_Profile.setOnClickListener(this);
        ll_Setting.setOnClickListener(this);
        ll_Share.setOnClickListener(this);
        ll_Logout.setOnClickListener(this);


        replace(new QuizFragment());


    }
    @Override
    public void onClick(View view) {
        int viewId = view.getId();

        if (viewId == R.id.ll_Home) {
            replace(new QuizFragment(), "Home");
        } else if (viewId == R.id.ll_Profile) {
            replace(new SMSFragment(), "Profile");
        } else if (viewId == R.id.ll_Setting) {
            replace(new SettingFragment(), "Setting");
        } else if (viewId == R.id.ll_Share) {
            Toast.makeText(this, "Share...", Toast.LENGTH_SHORT).show();
        } else if (viewId == R.id.ll_Logout) {
            Toast.makeText(this, "Logout...", Toast.LENGTH_SHORT).show();
        }

        drawerLayout.closeDrawer();
    }


    private void replace(Fragment fragment, String s) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame,fragment);
        transaction.addToBackStack(s);
        transaction.commit();
    }

    private void replace(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame,fragment);
        transaction.commit();
    }
}