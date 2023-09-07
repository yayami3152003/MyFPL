package com.example.fpoly.metmoi.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.fpoly.R;
import com.example.fpoly.metmoi.fragment.CalenderFragment;
import com.example.fpoly.metmoi.fragment.HomeFragment;
import com.example.fpoly.metmoi.fragment.PointFragment;
import com.example.fpoly.metmoi.fragment.UtilitiesFragment;

public class MainActivity extends AppCompatActivity {
    // Số tab được chọn, chúng ta có 4 tab, vì vậy giá trị phải nằm trong khoảng từ 1-4, mặc định là 1 vì tab đầu tiên được chọn mặc định.
    private int selectedTab = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final LinearLayout homeLayout = findViewById(R.id.homeLayout);
        final LinearLayout calenderLayout = findViewById(R.id.calenderLayout);
        final LinearLayout scoresLayout = findViewById(R.id.pointsLayout);
        final LinearLayout utilitiesLayout = findViewById(R.id.utilitiesLayout);

        final ImageView homeImage = findViewById(R.id.homeImage);
        final ImageView calenderImage = findViewById(R.id.calenderImage);
        final ImageView scoresImage = findViewById(R.id.pointsImage);
        final ImageView utilitiesImage = findViewById(R.id.utilitiesImage);

        final TextView homeTxt = findViewById(R.id.homeTxt);
        final TextView calenderTxt = findViewById(R.id.calenderTxt);
        final TextView scoresTxt = findViewById(R.id.pointsTxt);
        final TextView utilitiesTxt = findViewById(R.id.utilitiesTxt);

        // set home
        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.frameLayoutConstrainer, HomeFragment.class, null)
                .commit();

        homeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Kiểm tra xem trang chủ đã được chọn hay chưa
                if (selectedTab != 1) {
                    //set home fragment
                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.frameLayoutConstrainer, HomeFragment.class, null)
                            .commit();
                    // Bỏ chọn các tab khác trừ tab trang chủ
                    calenderTxt.setVisibility(View.GONE);
                    scoresTxt.setVisibility(View.GONE);
                    utilitiesTxt.setVisibility(View.GONE);

                    calenderImage.setImageResource(R.drawable.calender);
                    scoresImage.setImageResource(R.drawable.points);
                    utilitiesImage.setImageResource(R.drawable.utilities);

                    calenderLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    scoresLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    utilitiesLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));

                    //select home tab
                    homeTxt.setVisibility(View.VISIBLE);
                    homeImage.setImageResource(R.drawable.home_selected_icon);
                    homeLayout.setBackgroundResource(R.drawable.round_back);

                    // create animation on home
                    ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f, 1.0f, 1f, 1f, Animation.RELATIVE_TO_SELF, 1.0f, Animation.RELATIVE_TO_SELF, 0.0f);
                    scaleAnimation.setDuration(500);
                    scaleAnimation.setFillAfter(true);
                    homeLayout.startAnimation(scaleAnimation);

                    // set 1st  tab as selected tab
                    selectedTab = 1;

                }

            }
        });

        calenderLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Kiểm tra xem  lịch họcđã được chọn hay chưa
                if (selectedTab != 2) {
                    //set calender fragment
                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.frameLayoutConstrainer, CalenderFragment.class, null)
                            .commit();

                    // Bỏ chọn các tab khác trừ tab lịch học
                    homeTxt.setVisibility(View.GONE);
                    scoresTxt.setVisibility(View.GONE);
                    utilitiesTxt.setVisibility(View.GONE);

                    homeImage.setImageResource(R.drawable.home);
                    scoresImage.setImageResource(R.drawable.points);
                    utilitiesImage.setImageResource(R.drawable.utilities);

                    homeLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    scoresLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    utilitiesLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));

                    //select home tab
                    calenderTxt.setVisibility(View.VISIBLE);
                    calenderImage.setImageResource(R.drawable.calender_selected_icon);
                    calenderLayout.setBackgroundResource(R.drawable.rounded_bank_calender);

                    // create animation on home
                    ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f, 1.0f, 1f, 1f, Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.0f);
                    scaleAnimation.setDuration(500);
                    scaleAnimation.setFillAfter(true);
                    calenderLayout.startAnimation(scaleAnimation);

                    // set 1st  tab as selected tab
                    selectedTab = 2;

                }
            }
        });

        scoresLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Kiểm tra xem điểm đã được chọn hay chưa
                if (selectedTab != 3) {
                  // set scores fragment
                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.frameLayoutConstrainer, PointFragment.class, null)
                            .commit();
                    // Bỏ chọn các tab khác trừ tab điểm
                    homeTxt.setVisibility(View.GONE);
                    calenderTxt.setVisibility(View.GONE);
                    utilitiesTxt.setVisibility(View.GONE);

                    homeImage.setImageResource(R.drawable.home);
                    calenderImage.setImageResource(R.drawable.calender);
                    utilitiesImage.setImageResource(R.drawable.utilities);

                    homeLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    calenderLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    utilitiesLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));

                    //select home tab
                    scoresTxt.setVisibility(View.VISIBLE);
                    scoresImage.setImageResource(R.drawable.points_selected_icon);
                    scoresLayout.setBackgroundResource(R.drawable.rounded_scores);

                    // create animation on home
                    ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f, 1.0f, 1f, 1f, Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.0f);
                    scaleAnimation.setDuration(500);
                    scaleAnimation.setFillAfter(true);
                    scoresLayout.startAnimation(scaleAnimation);

                    // set 1st  tab as selected tab
                    selectedTab = 3;

                }
            }
        });

        utilitiesLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Kiểm tra xem điểm đã được chọn hay chưa
                if (selectedTab != 4) {
                    //set utilities fragment
                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.frameLayoutConstrainer, UtilitiesFragment.class, null)
                            .commit();

                    // Bỏ chọn các tab khác trừ tab điểm
                    homeTxt.setVisibility(View.GONE);
                    calenderTxt.setVisibility(View.GONE);
                    scoresTxt.setVisibility(View.GONE);

                    homeImage.setImageResource(R.drawable.home);
                    calenderImage.setImageResource(R.drawable.calender);
                    scoresImage.setImageResource(R.drawable.points);

                    homeLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    calenderLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    scoresLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));

                    //select home tab
                    utilitiesTxt.setVisibility(View.VISIBLE);
                    utilitiesImage.setImageResource(R.drawable.utilities_selected_icon);
                    utilitiesLayout.setBackgroundResource(R.drawable.rounded_utilities);

                    // create animation on home
                    ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f, 1.0f, 1f, 1f, Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.0f);
                    scaleAnimation.setDuration(500);
                    scaleAnimation.setFillAfter(true);
                    utilitiesLayout.startAnimation(scaleAnimation);

                    // set 1st  tab as selected tab
                    selectedTab = 4;

                }
            }
        });
    }
}