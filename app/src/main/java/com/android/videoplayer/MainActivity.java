package com.android.videoplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ArrayAdapter;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    VideoView videoView;

    ArrayList<Integer> videoList ;
    private GestureDetectorCompat gestureDetectorCompat = null;
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoView = (VideoView)findViewById(R.id.videoView);

        videoList = new ArrayList<>(Arrays.asList(R.raw.cat_in_the_sun,R.raw.gatos_,R.raw.seagulls_on_the_beach,R.raw.bannersch013));

        playVideo(videoList.indexOf(R.raw.bannersch013));

        SwipeListener gestureListener = new SwipeListener();
        gestureListener.setActivity(this);
        gestureDetectorCompat = new GestureDetectorCompat(this,gestureListener);

    }

    public void playVideo(int index1)
    {
        index = index1;
        videoView.setVideoURI(Uri.parse("android.resource://"+getPackageName()+ "/" +videoList.get(index1)));
        videoView.setMediaController(new MediaController(this));
        videoView.requestFocus();
        videoView.start();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetectorCompat.onTouchEvent(event);
        return true;
    }

    public void getPosition(int position)
    {
        if (position == 0) {
            Intent i = new Intent(MainActivity.this, ProfileActivity.class);
            startActivity(i);
        }

        if (position == 1) {
            Intent i = new Intent(MainActivity.this, subscribeActivity.class);
            startActivity(i);
        }

        if (position == 2) {

            if(index == 0)
            {
                playVideo(videoList.indexOf(R.raw.bannersch013));
            }

            else if(index == 1)
            {
                playVideo(videoList.indexOf(R.raw.cat_in_the_sun));
            }

            else if(index == 2)
            {
                playVideo(videoList.indexOf(R.raw.gatos_));
            }

            else if(index == 3)
            {
                playVideo(videoList.indexOf(R.raw.seagulls_on_the_beach));
            }
        }

        if (position == 3) {
            if(index == 1)
            {
                playVideo(videoList.indexOf(R.raw.seagulls_on_the_beach));
            }

            else if(index == 0)
            {
                playVideo(videoList.indexOf(R.raw.gatos_));
            }

            else if(index == 2)
            {
                playVideo(videoList.indexOf(R.raw.bannersch013));
            }
            else if(index == 3)
            {
                playVideo(videoList.indexOf(R.raw.cat_in_the_sun));
            }
        }
    }
}
