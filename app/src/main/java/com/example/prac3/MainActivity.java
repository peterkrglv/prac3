package com.example.prac3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.prac3.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        Info info = getIntent().getParcelableExtra("info");
        if (info != null) {
            binding.textView.setText(info.info);
        }

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                Info info = new Info(binding.editText.getText().toString(), 1);
                intent.putExtra("info", info);
                startActivity(intent);
            }
        });

        setContentView(binding.getRoot());
    }
}