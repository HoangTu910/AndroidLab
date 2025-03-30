package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String mssv = intent.getStringExtra("mssv");
        String className = intent.getStringExtra("className");
        String phone = intent.getStringExtra("phone");
        String year = intent.getStringExtra("year");
        String majors = intent.getStringExtra("majors");
        String correction = intent.getStringExtra("correction");

        ((TextView) findViewById(R.id.tv_name)).setText(
                getString(R.string.display_name, name));
        ((TextView) findViewById(R.id.tv_mssv)).setText(
                getString(R.string.display_mssv, mssv));
        ((TextView) findViewById(R.id.tv_class)).setText(
                getString(R.string.display_class, className));
        ((TextView) findViewById(R.id.tv_phone)).setText(
                getString(R.string.display_phone, phone));
        ((TextView) findViewById(R.id.tv_year)).setText(
                getString(R.string.display_year, year));
        ((TextView) findViewById(R.id.tv_majors)).setText(
                getString(R.string.display_majors, majors));
        ((TextView) findViewById(R.id.tv_essay)).setText(
                getString(R.string.display_essay, correction));
    }

    public void onBackClick(View view) {
        finish();
    }
}