package com.android.videoplayer;

import android.view.GestureDetector;
import android.view.MotionEvent;

public class SwipeListener extends GestureDetector.SimpleOnGestureListener {
    private static int MIN_SWIPE_DISTANCE_X = 100;
    private  static int MIN_SWIPE_DISTANCE_Y = 100;

    private static int MAX_SWIPE_DISTANCE_X = 1000;
    private static int MAX_SWIPE_DISTANCE_Y = 1000;

    private MainActivity activity = null;

    public MainActivity getActivity()
    {
        return activity;
    }

    public void setActivity(MainActivity activity)
    {
        this.activity = activity;
    }

    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY)
    {
        float deltaX = e1.getX() - e2.getX();
        float deltaY = e1.getY() - e2.getY();

        float deltaXabs = Math.abs(deltaX);
        float deltaYabs = Math.abs(deltaY);

        if (deltaXabs >= MIN_SWIPE_DISTANCE_X && deltaXabs <= MAX_SWIPE_DISTANCE_X)
        {
            if(deltaX > 0)
            {
                this.activity.getPosition(0);
            }
            else
            {
                this.activity.getPosition(1);
            }
        }

        if (deltaYabs >= MIN_SWIPE_DISTANCE_Y && deltaYabs <= MAX_SWIPE_DISTANCE_Y)
        {
            if(deltaY > 0)
            {
                this.activity.getPosition(2);
            }
            else
            {
                this.activity.getPosition(3);
            }
        }

        return true;
    }

}