package com.sd.demo.circular_progresbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.sd.lib.circularpgb.CircularProgressBar;

public class MainActivity extends AppCompatActivity
{
    private CircularProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mProgressBar = findViewById(R.id.progressbar);

        mProgressBar.setProgress(50);
    }
}
