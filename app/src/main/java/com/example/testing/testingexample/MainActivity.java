package com.example.testing.testingexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.tv_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.startActivity(getActivityIntent(SecondActivity.class));
            }
        });
    }

    private Intent getActivityIntent(Class objClass) {
        Intent intent = new Intent(this, objClass);
        return intent;
    }

}
