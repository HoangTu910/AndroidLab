package com.example.btvn6;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class StudentDetailActivity extends AppCompatActivity {
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_student_detail);

        dbHelper = new DatabaseHelper(this);
        ImageView detailAvatar = findViewById(R.id.detailAvatar);
        TextView detailName = findViewById(R.id.detailName);
        TextView detailMSSV = findViewById(R.id.detailMSSV);
        TextView detailNgaySinh = findViewById(R.id.detailNgaySinh);
        TextView detailLop = findViewById(R.id.detailLop);
        TextView detailChuyenNganh = findViewById(R.id.detailChuyenNganh);

        int studentId = getIntent().getIntExtra("student_id", -1);
        if (studentId != -1) {
            Cursor cursor = dbHelper.getStudentById(studentId);
            if (cursor != null && cursor.moveToFirst()) {
                String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
                String mssv = cursor.getString(cursor.getColumnIndexOrThrow("mssv"));
                String avatar = cursor.getString(cursor.getColumnIndexOrThrow("avatar"));
                String ngaysinh = cursor.getString(cursor.getColumnIndexOrThrow("ngaysinh"));
                String lop = cursor.getString(cursor.getColumnIndexOrThrow("lop"));
                String chuyennganh = cursor.getString(cursor.getColumnIndexOrThrow("chuyennganh"));

                detailName.setText("Ho ten: " + name);
                detailMSSV.setText("MSSV: " + mssv);
                detailNgaySinh.setText("Ngay sinh: " + ngaysinh);
                detailLop.setText("Lop: " + lop);
                detailChuyenNganh.setText("Chuyen nganh: " + chuyennganh);
                detailAvatar.setImageResource(R.drawable.ic_customer);
            }
            cursor.close();
        }
    }
}
