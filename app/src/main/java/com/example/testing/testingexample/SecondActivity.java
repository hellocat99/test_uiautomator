package com.example.testing.testingexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView titleTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        findViewById(R.id.tv_recommand).setOnClickListener(mOnClickListener);
        findViewById(R.id.tv_mine).setOnClickListener(mOnClickListener);
        findViewById(R.id.tv_title).setOnClickListener(mOnClickListener);
        titleTxt = (TextView) findViewById(R.id.tv_title);
    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.tv_recommand:
                    titleTxt.setText(getString(R.string.recommand));
                    break;
                case R.id.tv_mine:
                    titleTxt.setText(getString(R.string.login_register));
                    break;
                case R.id.tv_title:
                    SecondActivity.this.startActivity(
                            new Intent(SecondActivity.this, LoginActivity.class));
                    break;

            }
        }
    };
}
