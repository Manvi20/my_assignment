package com.android.videoplayer;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;

public class subscribeActivity extends AppCompatActivity {

    Button btnSubscribe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscribe);

        setTitle("@Rajiv_Singh");

        btnSubscribe = (Button)findViewById(R.id.btnSubscribe);

        btnSubscribe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setMessage("Subscribed");
                builder.setCancelable(true);

                final AlertDialog dialog= builder.create();

                dialog.show();

                final Timer timer2 = new Timer();
                timer2.schedule(new TimerTask() {
                    public void run() {
                        dialog.dismiss();
                        timer2.cancel();
                    }
                }, 2000);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(subscribeActivity.this,MainActivity.class);
        startActivity(i);
    }
}

