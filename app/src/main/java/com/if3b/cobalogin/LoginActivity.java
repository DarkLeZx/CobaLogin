package com.if3b.cobalogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class LoginActivity extends AppCompatActivity {
    private EditText etUsername, etPassword;
    private Button btnLogin;
    private String username, password;
    KendaliLogin KL = new KendaliLogin();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username = etUsername.getText().toString();
                password = etPassword.getText().toString();

                if(username.trim().isEmpty()) {
                    etUsername.setError("Username Tidak Boleh Kosong");
                }
                else if (password.trim().isEmpty()) {
                }
                else {
                    if(username.equals("asep") && password.equals("mangasep"))
                    {
                        KL.setPref(LoginActivity.this, MainActivity.keySPusername, "DepNielS");
                        KL.setPref(LoginActivity.this, MainActivity.keySPname, "Asep");
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        finish();

                    }
                    else{
                        Toast.makeText(LoginActivity.this, "Username Atau Password Belum Tepat!", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}