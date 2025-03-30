package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText editName, editMssv, editClass, editPhone, editEssay;
    private RadioGroup radioYear;
    private CheckBox checkHTN, checkElectronics, checkNetwork;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        setTitle(R.string.title_main);

        editName = findViewById(R.id.edit_name);
        editMssv = findViewById(R.id.edit_mssv);
        editClass = findViewById(R.id.edit_class);
        editPhone = findViewById(R.id.edit_phone);
        editEssay = findViewById(R.id.edit_essay);
        radioYear = findViewById(R.id.radio_year);
        checkHTN = findViewById(R.id.checkbox_HTN);
        checkElectronics = findViewById(R.id.checkbox_electronics);
        checkNetwork = findViewById(R.id.checkbox_network);
        Button submitButton = findViewById(R.id.submit_essay);

        submitButton.setOnClickListener(v -> {
            String name = editName.getText().toString();
            String mssv = editMssv.getText().toString();
            String className = editClass.getText().toString();
            String phone = editPhone.getText().toString();
            String essay = editEssay.getText().toString();

            int selectedYearId = radioYear.getCheckedRadioButtonId();
            RadioButton selectedYear = findViewById(selectedYearId);
            String year = selectedYear != null ? selectedYear.getText().toString() : "";

            StringBuilder majors = new StringBuilder();
            if (checkHTN.isChecked()) majors.append(checkHTN.getText()).append(", ");
            if (checkElectronics.isChecked()) majors.append(checkElectronics.getText()).append(", ");
            if (checkNetwork.isChecked()) majors.append(checkNetwork.getText()).append(", ");

            String selectedMajors = majors.length() > 0
                    ? majors.substring(0, majors.length() - 2)
                    : "";

            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("name", name);
            intent.putExtra("mssv", mssv);
            intent.putExtra("className", className);
            intent.putExtra("phone", phone);
            intent.putExtra("year", year);
            intent.putExtra("majors", selectedMajors);
            intent.putExtra("correction", essay);
            startActivity(intent);
        });
    }
}