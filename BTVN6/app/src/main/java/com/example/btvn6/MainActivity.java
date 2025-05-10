package com.example.btvn6;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private DatabaseHelper dbHelper;
    private List<Student> studentList;
    private StudentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listViewStudents);
        dbHelper = new DatabaseHelper(this);
        studentList = new ArrayList<>();
        adapter = new StudentAdapter(this, studentList);
        listView.setAdapter(adapter);

        dbHelper.addStudent("Nguyen Van A", "123456", "default_avatar", "08/03/2003", "21Nhung", "MAY TINH - NHUNG");
        dbHelper.addStudent("Tran Thi B", "789012", "default_avatar", "15/05/2002", "21DienTu", "DIEN TU");

        loadStudents();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            private long lastClickTime = 0;
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                long currentTime = System.currentTimeMillis();
                if (currentTime - lastClickTime < 300) { // Double-click trong 300ms
                    Student student = studentList.get(position);
                    Intent intent = new Intent(MainActivity.this, StudentDetailActivity.class);
                    intent.putExtra("student_id", student.getId());
                    startActivity(intent);
                }
                lastClickTime = currentTime;
            }
        });
    }

    private void loadStudents() {
        studentList.clear();
        Cursor cursor = dbHelper.getAllStudents();
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
            String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
            String mssv = cursor.getString(cursor.getColumnIndexOrThrow("mssv"));
            String avatar = cursor.getString(cursor.getColumnIndexOrThrow("avatar"));
            String ngaysinh = cursor.getString(cursor.getColumnIndexOrThrow("ngaysinh"));
            String lop = cursor.getString(cursor.getColumnIndexOrThrow("lop"));
            String chuyennganh = cursor.getString(cursor.getColumnIndexOrThrow("chuyennganh"));
            studentList.add(new Student(id, name, mssv, avatar, ngaysinh, lop, chuyennganh));
        }
        cursor.close();
        adapter.notifyDataSetChanged();
    }
}