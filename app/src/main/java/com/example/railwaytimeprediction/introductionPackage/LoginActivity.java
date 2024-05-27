package com.example.railwaytimeprediction.introductionPackage;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;
import com.example.railwaytimeprediction.R;
import com.example.railwaytimeprediction.allDatabasePackage.administrationPackage.AdministrationDatabase;
import com.example.railwaytimeprediction.platformsPackage.MainActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText mail, password;
    private Boolean isChecked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mail = findViewById(R.id.mail);
        password = findViewById(R.id.password);
        CheckBox rememberMe = findViewById(R.id.remember_me);
        Button loginButton = findViewById(R.id.login_button);
        Button registerButton = findViewById(R.id.register_button);

        SharedPreferences sharedPreferences = getSharedPreferences("checkbox", MODE_PRIVATE);
        String checkbox = sharedPreferences.getString("rememberMe", "");
        if(checkbox.equals("true")) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            LoginActivity.this.startActivity(intent);
        }

        mail.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                hideKeyboard(v);
            }
        });

        password.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                hideKeyboard(v);
            }
        });

        rememberMe.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                isChecked = compoundButton.isChecked();
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try (AdministrationDatabase administrationDatabase = new AdministrationDatabase(LoginActivity.this)) {

                    if (mail.getText().toString().equals("") || password.getText().toString().equals("")) {
                        Toast.makeText(LoginActivity.this, "Boş Bırakılan Alanlar Var", Toast.LENGTH_SHORT).show();
                    } else if (!administrationDatabase.isAccountExists(mail.getText().toString())) {
                        Toast.makeText(LoginActivity.this, "Bu Mail Adresine Ait Hesap Bulunamadı", Toast.LENGTH_SHORT).show();
                    } else {
                        if (administrationDatabase.login(mail.getText().toString(), password.getText().toString())) {
                            SharedPreferences sharedPreferences = getSharedPreferences("checkbox", MODE_PRIVATE);
                            SharedPreferences.Editor currentMail_editor = sharedPreferences.edit();
                            currentMail_editor.putString("currentMail", mail.getText().toString());
                            currentMail_editor.apply();

                            if (isChecked) {
                                sharedPreferences = getSharedPreferences("checkbox", MODE_PRIVATE);
                                SharedPreferences.Editor rememberMe_editor = sharedPreferences.edit();
                                rememberMe_editor.putString("rememberMe", "true");
                                rememberMe_editor.apply();
                            } else {
                                sharedPreferences = getSharedPreferences("checkbox", MODE_PRIVATE);
                                SharedPreferences.Editor rememberMe_editor = sharedPreferences.edit();
                                rememberMe_editor.putString("rememberMe", "false");
                                rememberMe_editor.apply();
                            }

                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            LoginActivity.this.startActivity(intent);
                        } else {
                            Toast.makeText(LoginActivity.this, "Giriş Bilgileri Hatalı", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(intent);
            }
        });
    }

    private void hideKeyboard(View view) {
        InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}