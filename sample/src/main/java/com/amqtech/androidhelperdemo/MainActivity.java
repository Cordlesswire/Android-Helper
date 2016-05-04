package com.amqtech.androidhelperdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;

import com.amqtech.androidhelper.AndroidHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Show Short Toast
        AndroidHelper.shortToast(getBaseContext(), "This is a short toast!");

        // Show Long Toast
        AndroidHelper.longToast(getBaseContext(), "This is a long toast!");

        // Convert drawable to bitmap
        AndroidHelper.drawableToBitmap(ResourcesCompat.getDrawable(getResources(), R.drawable.ic_add_white_24dp, null));

        // Shade a color to make it darker (float value: 0.1 = 10%, 0.9 = 90%)
        AndroidHelper.darkenColor(Color.parseColor("#FFFFFF"), 0.8f);

        // Shade a color to make it lighter (float value: 0.1 = 10%, 0.9 = 90%)
        AndroidHelper.lightenColor(Color.parseColor("#FFFFFF"), 0.8f);
    }
}
