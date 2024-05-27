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
import com.example.railwaytimeprediction.platformsPackage.FragmentAllPlatforms;
import com.example.railwaytimeprediction.platformsPackage.MainActivity;

import java.util.Objects;

public class UpdateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        Button changeFirstName = findViewById(R.id.change_first_name);
        changeFirstName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText dialogFirstName, dialogPassword;
                Button dialogEscapeButton, dialogConfirmButton;

                Dialog dialog = new Dialog(UpdateActivity.this);
                dialog.setContentView(R.layout.dialog_change_first_name);
                Objects.requireNonNull(dialog.getWindow()).setLayout(800, 1200);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                dialog.show();

                dialogFirstName = dialog.findViewById(R.id.first_name_input);
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
                        try (AdministrationDatabase administrationDatabase = new AdministrationDatabase(UpdateActivity.this)) {

                            if (dialogFirstName.getText().toString().equals("") || dialogPassword.getText().toString().equals("")) {
                                Toast.makeText(UpdateActivity.this, "Boş Bırakılan Alanlar Var", Toast.LENGTH_SHORT).show();
                            } else if (administrationDatabase.getOneLine(1, dialogFirstName.getText().toString())) {
                                Toast.makeText(UpdateActivity.this, "Yeni Adınız Eskisiyle Aynı Olamaz", Toast.LENGTH_SHORT).show();
                            } else {
                                if (administrationDatabase.login(FragmentAllPlatforms.currentMail, dialogPassword.getText().toString())) {
                                    administrationDatabase.changeFirstName(dialogFirstName.getText().toString());

                                    dialog.dismiss();
                                    Intent intent = new Intent(UpdateActivity.this, MainActivity.class);
                                    UpdateActivity.this.startActivity(intent);

                                    Toast.makeText(UpdateActivity.this, "Adınız Başarıyla Değiştirildi", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(UpdateActivity.this, "Şifre Hatalı", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    }
                });
            }
        });

        Button changeLastName = findViewById(R.id.change_last_name);
        changeLastName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText dialogLastName, dialogPassword;
                Button dialogEscapeButton, dialogConfirmButton;

                Dialog dialog = new Dialog(UpdateActivity.this);
                dialog.setContentView(R.layout.dialog_change_last_name);
                Objects.requireNonNull(dialog.getWindow()).setLayout(800, 1200);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                dialog.show();

                dialogLastName = dialog.findViewById(R.id.last_name_input);
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
                        try (AdministrationDatabase administrationDatabase = new AdministrationDatabase(UpdateActivity.this)) {
                            if (dialogLastName.getText().toString().equals("") || dialogPassword.getText().toString().equals("")) {
                                Toast.makeText(UpdateActivity.this, "Boş Bırakılan Alanlar Var", Toast.LENGTH_SHORT).show();
                            } else if (administrationDatabase.getOneLine(2, dialogLastName.getText().toString())) {
                                Toast.makeText(UpdateActivity.this, "Yeni Soyadınız Eskisiyle Aynı Olamaz", Toast.LENGTH_SHORT).show();
                            } else {
                                if (administrationDatabase.login(FragmentAllPlatforms.currentMail, dialogPassword.getText().toString())) {
                                    administrationDatabase.changeLastName(dialogLastName.getText().toString());

                                    dialog.dismiss();
                                    Intent intent = new Intent(UpdateActivity.this, MainActivity.class);
                                    UpdateActivity.this.startActivity(intent);

                                    Toast.makeText(UpdateActivity.this, "Soyadınız Başarıyla Değiştirildi", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(UpdateActivity.this, "Şifre Hatalı", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    }
                });
            }
        });

        Button changeMail = findViewById(R.id.change_mail);
        changeMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText dialogMail, dialogPassword;
                Button dialogEscapeButton, dialogConfirmButton;

                Dialog dialog = new Dialog(UpdateActivity.this);
                dialog.setContentView(R.layout.dialog_change_mail);
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
                        try (AdministrationDatabase administrationDatabase = new AdministrationDatabase(UpdateActivity.this)) {
                            if (dialogMail.getText().toString().equals("") || dialogPassword.getText().toString().equals("")) {
                                Toast.makeText(UpdateActivity.this, "Boş Bırakılan Alanlar Var", Toast.LENGTH_SHORT).show();
                            } else if (administrationDatabase.getOneLine(3, dialogMail.getText().toString())) {
                                Toast.makeText(UpdateActivity.this, "Yeni Mail Adresiniz Eskisiyle Aynı Olamaz", Toast.LENGTH_SHORT).show();
                            } else if (administrationDatabase.isAccountExists(dialogMail.getText().toString())) {
                                Toast.makeText(UpdateActivity.this, "Bu Mail Adresi Başka Bir Hesaba Ait", Toast.LENGTH_SHORT).show();
                            } else {
                                if (administrationDatabase.login(FragmentAllPlatforms.currentMail, dialogPassword.getText().toString())) {
                                    administrationDatabase.changeMail(dialogMail.getText().toString(), UpdateActivity.this);

                                    dialog.dismiss();

                                    SharedPreferences sharedPreferences = getSharedPreferences("checkbox", MODE_PRIVATE);
                                    SharedPreferences.Editor editor = sharedPreferences.edit();
                                    editor.clear();
                                    editor.apply();

                                    Intent intent = new Intent(UpdateActivity.this, LoginActivity.class);
                                    UpdateActivity.this.startActivity(intent);

                                    Toast.makeText(UpdateActivity.this, "Mail Adresiniz Başarıyla Değiştirildi\nLütfen Tekrar Giriş Yapın", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(UpdateActivity.this, "Şifre Hatalı", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    }
                });
            }
        });

        Button changePassword = findViewById(R.id.change_password);
        changePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText dialogNewPassword, dialogConfirmNewPassword, dialogOldPassword;
                Button dialogEscapeButton, dialogConfirmButton;

                Dialog dialog = new Dialog(UpdateActivity.this);
                dialog.setContentView(R.layout.dialog_change_password);
                Objects.requireNonNull(dialog.getWindow()).setLayout(800, 1200);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                dialog.show();

                dialogNewPassword = dialog.findViewById(R.id.new_password_input);
                dialogConfirmNewPassword = dialog.findViewById(R.id.confirm_new_password_input);
                dialogOldPassword = dialog.findViewById(R.id.old_password_input);
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
                        try (AdministrationDatabase administrationDatabase = new AdministrationDatabase(UpdateActivity.this)) {

                            if (dialogNewPassword.getText().toString().equals("") || dialogConfirmNewPassword.getText().toString().equals("") || dialogOldPassword.getText().toString().equals("")) {
                                Toast.makeText(UpdateActivity.this, "Boş Bırakılan Alanlar Var", Toast.LENGTH_SHORT).show();
                            } else if (!dialogNewPassword.getText().toString().equals(dialogConfirmNewPassword.getText().toString())) {
                                Toast.makeText(UpdateActivity.this, "Şifreler Uyuşmuyor", Toast.LENGTH_SHORT).show();
                            } else if (administrationDatabase.getOneLine(4, dialogNewPassword.getText().toString())) {
                                Toast.makeText(UpdateActivity.this, "Yeni Şifreniz Eskisiyle Aynı Olamaz", Toast.LENGTH_SHORT).show();
                            } else {
                                if (administrationDatabase.login(FragmentAllPlatforms.currentMail, dialogOldPassword.getText().toString())) {
                                    administrationDatabase.changePassword(dialogNewPassword.getText().toString());

                                    dialog.dismiss();

                                    SharedPreferences sharedPreferences = getSharedPreferences("checkbox", MODE_PRIVATE);
                                    SharedPreferences.Editor editor = sharedPreferences.edit();
                                    editor.clear();
                                    editor.apply();

                                    Intent intent = new Intent(UpdateActivity.this, LoginActivity.class);
                                    UpdateActivity.this.startActivity(intent);

                                    Toast.makeText(UpdateActivity.this, "Şifreniz Başarıyla Değiştirildi\nLütfen Tekrar Giriş Yapın", Toast.LENGTH_SHORT).show();

                                } else {
                                    Toast.makeText(UpdateActivity.this, "Şifre Hatalı", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    }
                });
            }
        });

        Button escapeButton = findViewById(R.id.escape_button);
        escapeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UpdateActivity.this, SettingsActivity.class);
                UpdateActivity.this.startActivity(intent);
            }
        });
    }
}