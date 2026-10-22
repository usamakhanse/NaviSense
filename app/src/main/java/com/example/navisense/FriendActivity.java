package com.example.navisense;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.navisense.databinding.ActivityFriendBinding;

public class FriendActivity extends AppCompatActivity {

    private ActivityFriendBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityFriendBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(binding.mainRoot, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Back button to dashboard
        binding.tvBack.setOnClickListener(v -> finish());

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