package com.example.que_2;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Switch switchSound, switchVibration, switchLed, switchBanner, switchContent, switchLockScreen;

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        switchSound = findViewById(R.id.switchSound);
        switchVibration = findViewById(R.id.switchVibration);
        switchLed = findViewById(R.id.switchLed);
        switchBanner = findViewById(R.id.switchBanner);
        switchContent = findViewById(R.id.switchContent);
        switchLockScreen = findViewById(R.id.switchLockScreen);


        sharedPreferences = getSharedPreferences("Preferences", MODE_PRIVATE);
        loadPreferences();


        findViewById(R.id.buttonSave).setOnClickListener(v -> savePreferences());
    }

    private void loadPreferences() {
        switchSound.setChecked(sharedPreferences.getBoolean("sound", false));
        switchVibration.setChecked(sharedPreferences.getBoolean("vibration", false));
        switchLed.setChecked(sharedPreferences.getBoolean("led", false));
        switchBanner.setChecked(sharedPreferences.getBoolean("banner", false));
        switchContent.setChecked(sharedPreferences.getBoolean("content", false));
        switchLockScreen.setChecked(sharedPreferences.getBoolean("lockScreen", false));
    }

    private void savePreferences() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("sound", switchSound.isChecked());
        editor.putBoolean("vibration", switchVibration.isChecked());
        editor.putBoolean("led", switchLed.isChecked());
        editor.putBoolean("banner", switchBanner.isChecked());
        editor.putBoolean("content", switchContent.isChecked());
        editor.putBoolean("lockScreen", switchLockScreen.isChecked());
        editor.apply();
        Toast.makeText(this, "saved", Toast.LENGTH_SHORT).show();
    }
}
