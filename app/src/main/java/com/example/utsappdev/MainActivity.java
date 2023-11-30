package com.example.utsappdev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    EditText username;
    EditText password;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.Username);
        password = findViewById(R.id.Password);
        loginButton = findViewById(R.id.LoginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Button LoginButton = (Button) findViewById(R.id.LoginButton);

                LoginButton.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub

                        if (username.getText().toString().equals("user") && password.getText().toString().equals("1234")) {
                            Toast.makeText(MainActivity.this, "Login Berhasil!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this, ListKontak.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(MainActivity.this, "Login Gagal! Cek kembali username dan password Anda.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }

        }
        )
        ;
    }
}