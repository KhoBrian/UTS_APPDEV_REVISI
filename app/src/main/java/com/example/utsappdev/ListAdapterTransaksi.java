package com.example.utsappdev;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ListAdapterTransaksi extends BaseAdapter {
    private Context context;
    private List<Transaksi> listTransaksi;

    public ListAdapterTransaksi(Context context, List<Transaksi> transactionList) {
        this.context = context;
        this.listTransaksi = transactionList;
    }

    @Override
    public int getCount() {

        return listTransaksi.size();
    }

    @Override
    public Object getItem(int position) {

        return listTransaksi.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            // Jika convertView belum ada, inflate layout item kustom
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_list_item_transaksi, parent, false);
        }

        // Dapatkan objek Transaction yang sesuai dengan posisi saat ini
        Transaksi transaksi = listTransaksi.get(position);

        // Isi tampilan item dengan data dari objek Transaction
        TextView dateTextView = convertView.findViewById(R.id.dateTextView);
        TextView amountTextView = convertView.findViewById(R.id.amountTextView);
        TextView debitCreditTextView = convertView.findViewById(R.id.debitCreditTextView);

        dateTextView.setText("Tanggal: " + transaksi.getDate());
        amountTextView.setText("Jumlah: " + transaksi.getAmount());
        debitCreditTextView.setText("Debet/Kredit: " + transaksi.getDebitCredit());

        return convertView;
    }
}
