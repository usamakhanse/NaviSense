package com.example.navisense;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.navisense.databinding.Activity5Binding;

public class Activity5 extends AppCompatActivity {

    private Activity5Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = Activity5Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnTraceFriend.setOnClickListener(v -> {
            String name = binding.etFriendName.getText().toString().trim();
            if (name.isEmpty()) {
                Toast.makeText(this, "Please enter friend name or ID", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Tracing " + name + "... Located near Food Court.", Toast.LENGTH_LONG).show();
            }
        });
    }
}