package com.example.listview51and52;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AndroidVersionAdapter extends ArrayAdapter<AndroidVersion> {
    public AndroidVersionAdapter(Context context, List<AndroidVersion> versions) {
        super(context, 0, versions);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_view_1, parent, false);
        }

        AndroidVersion version = getItem(position);

        ImageView imageView = convertView.findViewById(R.id.imageView);
        TextView versionName = convertView.findViewById(R.id.versionName);
        TextView versionNumber = convertView.findViewById(R.id.versionNumber);

        imageView.setImageResource(version.getImageResId());
        versionName.setText(version.getName());
        versionNumber.setText(version.getNumber());

        return convertView;
    }
}