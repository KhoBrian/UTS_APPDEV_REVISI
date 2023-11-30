package com.example.utsappdev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListKontak extends AppCompatActivity {
    private ListView contactListView;
    private Button addTransactionButton;
    private String username;
    private String password;
    private List<Transaksi> listTransaksi;
    private ListAdapterTransaksi listAdapterTransaksi;
    private DatabaseHelper dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_kontak);

        username = getIntent().getStringExtra("username");
        password = getIntent().getStringExtra("password");

        contactListView = findViewById(R.id.listViewKontak);
        addTransactionButton = findViewById(R.id.tambahButtonTransaksi);

        dbHandler = new DatabaseHelper(ListKontak.this);

        listTransaksi = new ArrayList<>();

        // Mengambil data transaksi dari database
        listTransaksi = dbHandler.getAllTransaksi();

        listAdapterTransaksi = new ListAdapterTransaksi(this, listTransaksi);
        contactListView.setAdapter(listAdapterTransaksi);

        addTransactionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // When "Tambah Transaksi" button is clicked, start AddTransactionActivity
                Intent intent = new Intent(ListKontak.this, TambahTransaksi.class);
                startActivity(intent);
            }
        });
    }
}