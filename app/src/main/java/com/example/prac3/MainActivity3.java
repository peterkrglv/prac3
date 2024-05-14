package com.example.prac3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.prac3.databinding.ActivityMain2Binding;
import com.example.prac3.databinding.ActivityMain3Binding;

public class MainActivity3 extends AppCompatActivity {
    ActivityMain3Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMain3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Info info = getIntent().getParcelableExtra("info");
        if (info != null) {
            binding.textView.setText(info.info);
        }

        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this, MainActivity2.class);
                Info info = new Info(binding.editText.getText().toString(), 3);
                intent.putExtra("info", info);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
}