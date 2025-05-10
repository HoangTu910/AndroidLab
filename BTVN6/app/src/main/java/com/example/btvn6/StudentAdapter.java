package com.example.btvn6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class StudentAdapter extends ArrayAdapter<Student> {
    public StudentAdapter(Context context, List<Student> students) {
        super(context, 0, students);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_student, parent, false);
        }
        Student student = getItem(position);

        ImageView avatar = convertView.findViewById(R.id.avatar);
        TextView tvName = convertView.findViewById(R.id.tvName);
        TextView tvMSSV = convertView.findViewById(R.id.tvMSSV);

        tvName.setText(student.getName());
        tvMSSV.setText(student.getMssv());
        avatar.setImageResource(R.drawable.ic_customer);

        return convertView;
    }
}
