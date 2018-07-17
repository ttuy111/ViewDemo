package me.kule.viewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import me.kule.viewdemo.breakText.BreakTextActivity;
import me.kule.viewdemo.speed.SpeedActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.mBtnOne).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.LaunchActivity(MainActivity.this, SpeedActivity.class);
            }
        });
        findViewById(R.id.mBtnTwo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.LaunchActivity(MainActivity.this, BreakTextActivity.class);
            }
        });
    }
}
