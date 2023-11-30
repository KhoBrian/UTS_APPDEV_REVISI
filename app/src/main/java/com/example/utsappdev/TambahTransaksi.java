package com.example.utsappdev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class TambahTransaksi extends AppCompatActivity {

    private EditText dateEditText, amountEditText, debitCreditEditText;
    private Button cancelButton, saveButton;
    private DatabaseHelper dbHandler;

    private String username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_transaksi);

        dbHandler = new DatabaseHelper(this);

        String username = "user";

        TextView usernameTextView = findViewById(R.id.usernameTextView);
        usernameTextView.setText("Tambah transaksi untuk pengguna '" + username + "'");

        dateEditText = findViewById(R.id.dateEditText);
        amountEditText = findViewById(R.id.amountEditText);
        debitCreditEditText = findViewById(R.id.debitCreditEditText);
        cancelButton = findViewById(R.id.cancelButton);
        saveButton = findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveTransaction();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    private void saveTransaction() {
        String date = dateEditText.getText().toString();
        String amount = amountEditText.getText().toString();
        String debitCredit = debitCreditEditText.getText().toString();

        // Create a Transaction object
        Transaksi transaksi = new Transaksi(username, password, date, amount, debitCredit);

        // Add the transaction to the database
        dbHandler.tambahTransaksi(transaksi);

        // Show a toast message indicating success
        Context context = getApplicationContext();
        CharSequence text = "Transaksi berhasil tersimpan!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        Log.d("SQLITE","Membaca isi database");
        List<Transaksi> contacts = dbHandler.getAllTransaksi();

        // Finish this activity and go back
        finish();
    }
}