package com.android.videoplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        setTitle("@Rajiv_Singh");
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(ProfileActivity.this,MainActivity.class);
        startActivity(i);
    }
}
