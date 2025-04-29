package com.example.listview51and52;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewFlipper viewFlipper;
    private Button prevButton, nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewFlipper = findViewById(R.id.viewFlipper);
        prevButton = findViewById(R.id.prevButton);
        nextButton = findViewById(R.id.nextButton);

        ListView listView1 = findViewById(R.id.listView1);
        List<AndroidVersion> versions = new ArrayList<>();
        versions.add(new AndroidVersion("Android Cupcake", "Version 1.5", R.mipmap.ic_launcher));
        versions.add(new AndroidVersion("Android Donut", "Version 1.6", R.mipmap.ic_launcher));
        versions.add(new AndroidVersion("Android Eclair", "Version 2.0", R.mipmap.ic_launcher));
        versions.add(new AndroidVersion("Android Froyo", "Version 2.2", R.mipmap.ic_launcher));
        versions.add(new AndroidVersion("Android Gingerbread", "Version 2.3", R.mipmap.ic_launcher));
        versions.add(new AndroidVersion("Android Honeycomb", "Version 3.0", R.mipmap.ic_launcher));
        AndroidVersionAdapter adapter1 = new AndroidVersionAdapter(this, versions);
        listView1.setAdapter(adapter1);

        ListView listView2 = findViewById(R.id.listView2);
        List<Fruit> fruits = new ArrayList<>();
        fruits.add(new Fruit("Orange", 47, R.mipmap.ic_launcher));
        fruits.add(new Fruit("Cherry", 50, R.mipmap.ic_launcher));
        fruits.add(new Fruit("Banana", 89, R.mipmap.ic_launcher));
        fruits.add(new Fruit("Apple", 52, R.mipmap.ic_launcher));
        fruits.add(new Fruit("Kiwi", 61, R.mipmap.ic_launcher));
        fruits.add(new Fruit("Pear", 57, R.mipmap.ic_launcher));
        fruits.add(new Fruit("Strawberry", 33, R.mipmap.ic_launcher));
        fruits.add(new Fruit("Lemon", 29, R.mipmap.ic_launcher));
        fruits.add(new Fruit("Peach", 39, R.mipmap.ic_launcher));
        fruits.add(new Fruit("Apricot", 48, R.mipmap.ic_launcher));
        fruits.add(new Fruit("Mango", 60, R.mipmap.ic_launcher));
        FruitAdapter adapter2 = new FruitAdapter(this, fruits);
        listView2.setAdapter(adapter2);

        prevButton.setOnClickListener(v -> {
            viewFlipper.setInAnimation(MainActivity.this, android.R.anim.slide_in_left);
            viewFlipper.setOutAnimation(MainActivity.this, android.R.anim.slide_out_right);
            viewFlipper.showPrevious();
            updateButtonState();
        });

        nextButton.setOnClickListener(v -> {
            viewFlipper.setInAnimation(MainActivity.this, R.anim.slide_in_left);
            viewFlipper.setOutAnimation(MainActivity.this, R.anim.slide_out_right);
            viewFlipper.showNext();
            updateButtonState();
        });

        updateButtonState();
    }

    private void updateButtonState() {
        prevButton.setEnabled(viewFlipper.getDisplayedChild() != 0);
        nextButton.setEnabled(viewFlipper.getDisplayedChild() != viewFlipper.getChildCount() - 1);
    }
}