package com.nick.moivehomework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.nick.moivehomework.Fragments.InfoFragment;

public class OtherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        long id = getIntent().getLongExtra("id", 209112);
        InfoFragment fragment = InfoFragment.newInstance(id);
        getSupportFragmentManager().beginTransaction().replace(R.id.info, fragment).commit();


        Toast.makeText(this, id + "", Toast.LENGTH_SHORT).show();
    }
}
