package com.example.navisense;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.navisense.databinding.HomeBinding;

public class HomeActivity extends AppCompatActivity {

    private HomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = HomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(binding.mainRoot, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Logout
        binding.btnLogout.setOnClickListener(v -> {
            Toast.makeText(this, "Logged out successfully", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(HomeActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        });

        // 1. Scan QR Code card & nav
        binding.cardScanQr.setOnClickListener(v -> startActivity(new Intent(this, MainActivity2.class)));
        binding.navScan.setOnClickListener(v -> startActivity(new Intent(this, MainActivity2.class)));

        // 2. Nearby Facilities card & nav
        binding.cardFacilities.setOnClickListener(v -> startActivity(new Intent(this, MainActivity3.class)));
        binding.navFacilities.setOnClickListener(v -> startActivity(new Intent(this, MainActivity3.class)));

        // 3. AR Navigation card
        binding.cardArNav.setOnClickListener(v -> startActivity(new Intent(this, MainActivity4.class)));

        // 4. Find a Friend card & nav
        binding.cardFindFriend.setOnClickListener(v -> startActivity(new Intent(this, FriendActivity.class)));
        binding.navFriends.setOnClickListener(v -> startActivity(new Intent(this, FriendActivity.class)));
    }
}