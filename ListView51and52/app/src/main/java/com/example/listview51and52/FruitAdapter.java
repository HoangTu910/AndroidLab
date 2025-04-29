package com.example.listview51and52;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FruitAdapter extends ArrayAdapter<Fruit> {
    public FruitAdapter(Context context, List<Fruit> fruits) {
        super(context, 0, fruits);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_view_2, parent, false);
        }

        Fruit fruit = getItem(position);

        ImageView fruitImage = convertView.findViewById(R.id.fruitImage);
        TextView fruitName = convertView.findViewById(R.id.fruitName);
        TextView fruitCalories = convertView.findViewById(R.id.fruitCalories);

        fruitImage.setImageResource(fruit.getImageResId());
        fruitName.setText(fruit.getName());
        fruitCalories.setText(fruit.getCalories() + " Calories");

        return convertView;
    }
}