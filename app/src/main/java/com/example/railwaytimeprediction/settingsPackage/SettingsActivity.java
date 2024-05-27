package com.example.railwaytimeprediction.settingsPackage;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.railwaytimeprediction.R;
import com.example.railwaytimeprediction.allDatabasePackage.administrationPackage.AdministrationDatabase;
import com.example.railwaytimeprediction.introductionPackage.LoginActivity;
import com.example.railwaytimeprediction.introductionPackage.RegisterActivity;
import com.example.railwaytimeprediction.platformsPackage.FragmentAllPlatforms;
import com.example.railwaytimeprediction.platformsPackage.MainActivity;

import java.util.Objects;

public class SettingsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Button logoutButton = findViewById(R.id.logout_button);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences =getSharedPreferences("checkbox", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();

                Intent intent = new Intent(SettingsActivity.this, LoginActivity.class);
                SettingsActivity.this.startActivity(intent);
            }
        });

        Button deleteButton = findViewById(R.id.delete_button);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText dialogMail, dialogPassword;
                Button dialogEscapeButton, dialogConfirmButton;

                Dialog dialog = new Dialog(SettingsActivity.this);
                dialog.setContentView(R.layout.dialog_delete_account);
                Objects.requireNonNull(dialog.getWindow()).setLayout(800, 1200);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                dialog.show();

                dialogMail = dialog.findViewById(R.id.mail_input);
                dialogPassword = dialog.findViewById(R.id.password_input);
                dialogEscapeButton = dialog.findViewById(R.id.escape_button);
                dialogEscapeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                                dialog.dismiss();
                            }
                });
                dialogConfirmButton = dialog.findViewById(R.id.confirm_button);
                dialogConfirmButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try (AdministrationDatabase administrationDatabase = new AdministrationDatabase(SettingsActivity.this)) {
                            if (dialogMail.getText().toString().equals("") || dialogPassword.getText().toString().equals("")) {
                                Toast.makeText(SettingsActivity.this, "Boş Bırakılan Alanlar Var", Toast.LENGTH_SHORT).show();
                            } else {
                                if (administrationDatabase.login(dialogMail.getText().toString(), dialogPassword.getText().toString())) {
                                    administrationDatabase.deleteAccount(FragmentAllPlatforms.currentMail, SettingsActivity.this);

                                    SharedPreferences sharedPreferences = getSharedPreferences("checkbox", MODE_PRIVATE);
                                    SharedPreferences.Editor editor = sharedPreferences.edit();
                                    editor.clear();
                                    editor.apply();

                                    Intent intent = new Intent(SettingsActivity.this, RegisterActivity.class);
                                    SettingsActivity.this.startActivity(intent);

                                    Toast.makeText(SettingsActivity.this, "Hesabınız Başarıyla Silindi", Toast.LENGTH_SHORT).show();

                                } else {
                                    Toast.makeText(SettingsActivity.this, "Şifre Hatalı", Toast.LENGTH_SHORT).show();
                                }

                            }
                        }
                    }
                });
            }
        });

        Button settingsButton = findViewById(R.id.settings_button);
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingsActivity.this, UpdateActivity.class);
                SettingsActivity.this.startActivity(intent);
            }
        });

        Button escapeButton = findViewById(R.id.escape_button);
        escapeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingsActivity.this, MainActivity.class);
                SettingsActivity.this.startActivity(intent);
            }
        });
    }
}