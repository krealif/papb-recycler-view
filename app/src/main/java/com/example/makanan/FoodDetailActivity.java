package com.example.makanan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class FoodDetailActivity extends AppCompatActivity {
    TextView txtName, txtDesc;
    String name, desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);

        txtName = findViewById(R.id.txt_name);
        txtDesc = findViewById(R.id.txt_desc);

        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        desc = intent.getStringExtra("desc");

        txtName.setText(name);
        txtDesc.setText(desc);

    }
}