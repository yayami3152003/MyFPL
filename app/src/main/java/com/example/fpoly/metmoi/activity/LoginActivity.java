package com.example.fpoly.metmoi.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.fpoly.R;
import com.example.fpoly.metmoi.adapter.TrainingCenterDialog;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.common.SignInButton;

public class LoginActivity extends AppCompatActivity implements TrainingCenterDialog.OnTrainingCenterSelectedListener  {

    private GoogleSignInClient googleSignInClient;
    private int RC_SIGN_IN = 2;
    private Button btnChon;
    private boolean hasChosenTrainingCenter = false;
    private boolean hasSignedInWithGoogle = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Configure Google Sign-In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        googleSignInClient = GoogleSignIn.getClient(this, gso);

        Button signInButton = findViewById(R.id.btn_sign_in_width_google);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });

        // Find the btnChon button and set an OnClickListener
        btnChon = findViewById(R.id.btnChon);
        btnChon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTrainingCenterDialog();
            }
        });
    }

    private void signIn() {
        Intent signInIntent = googleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            // Handle Google Sign-In response
            GoogleSignInAccount account = GoogleSignIn.getSignedInAccountFromIntent(data).getResult();
            if (account != null) {
                // Sign-in successful, set the flag
                hasSignedInWithGoogle = true;

                // Check if both conditions are met
                checkConditionsAndNavigate();
            }
        }
    }

    private void showTrainingCenterDialog() {
        TrainingCenterDialog dialog = new TrainingCenterDialog(this, this);
        dialog.show();
    }

    @Override
    public void onTrainingCenterSelected(String trainingCenter) {
        // Handle the selected training center here
        // For example, store it in SharedPreferences for later use
        hasChosenTrainingCenter = true;

        // Check if both conditions are met
        checkConditionsAndNavigate();
    }

    private void checkConditionsAndNavigate() {
        // Check if both conditions (hasChosenTrainingCenter and hasSignedInWithGoogle) are met
        if (hasChosenTrainingCenter && hasSignedInWithGoogle) {
            navigateToMainActivity();
        }
    }

    private void navigateToMainActivity() {
        // Chuyển hướng đến MainActivity
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
        // Optional: Close the LoginActivity if you don't want the user to go back to it
    }
}