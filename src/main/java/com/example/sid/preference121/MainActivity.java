package com.example.sid.preference121;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int SETTING_RESULT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSetting = (Button) findViewById(R.id.btnSetting);
        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //creating intent for result
                Intent intent = new Intent(getApplicationContext(),SettingActivity.class);
                startActivityForResult(intent,SETTING_RESULT);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==SETTING_RESULT)
            displayUserSetting();
    }

    private void displayUserSetting() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String mSetting = "";

        mSetting = mSetting+"Password :"+sharedPreferences.getString("UserPasswaod","No Password");
        mSetting = mSetting+"\nRemind For Update :"+sharedPreferences.getBoolean("LockScreen",false);
        mSetting = mSetting+"\nUpdate Frequency  :"+sharedPreferences.getString("UpdateFrequency","No Update");

        TextView tvSetting = (TextView) findViewById(R.id.tvSetting);
        tvSetting.setText(mSetting);
    }
}
