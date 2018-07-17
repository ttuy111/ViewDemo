package me.kule.viewdemo.speed;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import me.kule.viewdemo.R;

public class SpeedActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speed);
        final SpeedView mSpeedView = (SpeedView) findViewById(R.id.mSpeedView);
        final EditText mEdit1 = (EditText) findViewById(R.id.mEdit);
        mEdit1.setText(1+"");

        ((Button) findViewById(R.id.mBtn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = mEdit1.getText().toString();
                Integer integer = Integer.valueOf(s);
                mSpeedView.setValue(integer);
            }
        });
    }
}
