package com.example.prac3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.prac3.databinding.ActivityMain2Binding;
import com.example.prac3.databinding.ActivityMain3Binding;

public class MainActivity2 extends AppCompatActivity {
    ActivityMain2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());

        Info info = getIntent().getParcelableExtra("info");
        if (info != null) {
            binding.textView.setText(info.info);
        }

        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                Info info = new Info(binding.editText.getText().toString(), 2);
                intent.putExtra("info", info);
                startActivity(intent);
            }
        });

        binding.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                Info info = new Info(binding.editText.getText().toString(), 2);
                intent.putExtra("info", info);
                startActivity(intent);
            }
        });

        setContentView(binding.getRoot());
    }
}