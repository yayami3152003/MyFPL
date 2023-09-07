package com.example.fpoly.metmoi.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.example.fpoly.R;
import com.example.fpoly.metmoi.fragment.MyBottomSheetFragment;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class MyBottomSheetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_bottom_sheet);

        // Get the FrameLayout that includes the bottom_sheet_layout
        FrameLayout bottomSheetFrameLayout = findViewById(R.id.bottomSheetContainer);

        // Make sure the view is not null
        if (bottomSheetFrameLayout != null) {
            // Set up the BottomSheetBehavior
            BottomSheetBehavior<View> bottomSheetBehavior = BottomSheetBehavior.from(bottomSheetFrameLayout);

            // Now you can customize the behavior of the bottom sheet if needed
            bottomSheetBehavior.setPeekHeight(200); // Set the initial peek height, for example, 200 pixels.

            // Log the state of the BottomSheetBehavior
            Log.d("BottomSheetState", "State: " + bottomSheetBehavior.getState());

            // Add a BottomSheetCallback to monitor changes in state
            bottomSheetBehavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
                @Override
                public void onStateChanged(@NonNull View bottomSheet, int newState) {
                    Log.d("BottomSheetState", "State Changed: " + newState);
                }

                @Override
                public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                    // Optional: Add additional log for sliding behavior if needed
                    Log.d("BottomSheetSlide", "Slide Offset: " + slideOffset);
                }
            });
        }
        MyBottomSheetFragment bottomSheetFragment = new MyBottomSheetFragment();
        bottomSheetFragment.show(getSupportFragmentManager(), bottomSheetFragment.getTag());
    }
}