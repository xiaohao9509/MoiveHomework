package com.nick.moivehomework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class OtherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        Toast.makeText(this,getIntent().getLongExtra("id",1)+"",Toast.LENGTH_SHORT).show();
    }
}
