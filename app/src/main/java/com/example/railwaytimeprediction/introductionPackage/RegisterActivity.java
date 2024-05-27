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

public class RegisterActivity extends AppCompatActivity {
    private EditText firstName, lastName, mail, password, passwordAgain;
    private Boolean isChecked = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        firstName = findViewById(R.id.first_name);
        lastName = findViewById(R.id.last_name);
        mail = findViewById(R.id.mail);
        password = findViewById(R.id.password);
        passwordAgain = findViewById(R.id.password_again);
        CheckBox rememberMe = findViewById(R.id.remember_me);
        Button loginButton = findViewById(R.id.login_button);
        Button registerButton = findViewById(R.id.register_button);

        SharedPreferences sharedPreferences = getSharedPreferences("checkbox", MODE_PRIVATE);
        String checkbox = sharedPreferences.getString("rememberMe", "");

        if(checkbox.equals("true")) {
            Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
            RegisterActivity.this.startActivity(intent);
        }

        firstName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                hideKeyboard(v);
            }
        });

        lastName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                hideKeyboard(v);
            }
        });

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

        passwordAgain.setOnFocusChangeListener(new View.OnFocusChangeListener() {
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

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try (AdministrationDatabase administrationDatabase = new AdministrationDatabase(RegisterActivity.this)) {
                    if (firstName.getText().toString().equals("") || lastName.getText().toString().equals("") || mail.getText().toString().equals("") || password.getText().toString().equals("")) {
                        Toast.makeText(RegisterActivity.this, "Boş Bırakılan Alanlar Var", Toast.LENGTH_SHORT).show();
                    } else if (administrationDatabase.isAccountExists(mail.getText().toString())) {
                        Toast.makeText(RegisterActivity.this, "Bu Maile Ait Başka Hesap Bulundu", Toast.LENGTH_SHORT).show();
                    } else {
                        if (password.getText().toString().equals(passwordAgain.getText().toString())) {
                            administrationDatabase.addAccount(firstName.getText().toString(), lastName.getText().toString(), mail.getText().toString(), password.getText().toString());

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

                            Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                            RegisterActivity.this.startActivity(intent);
                        } else {
                            Toast.makeText(RegisterActivity.this, "Şifreler Aynı Değil", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                RegisterActivity.this.startActivity(intent);
            }
        });
    }

    private void hideKeyboard(View view) {
        InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}