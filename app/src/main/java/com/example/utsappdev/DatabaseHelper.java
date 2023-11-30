package com.example.utsappdev;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "databasetransaksi";
    public static final String TB_NAME = "daftartransaksi";
    public static final String KEY_ID = "id";
    public static final String KEY_DATE = "date";
    public static final String KEY_AMOUNT = "amount";
    public static final String KEY_DEBIT_CREDIT = "debit_credit";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TB_NAME + "(" +
                KEY_ID + " INTEGER PRIMARY KEY," +
                KEY_DATE + " TEXT," +
                KEY_AMOUNT + " TEXT," +
                KEY_DEBIT_CREDIT + " TEXT" + ")";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TB_NAME);
        onCreate(sqLiteDatabase);
    }

    public void tambahTransaksi(Transaksi transaksi) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(KEY_DATE, transaksi.getDate());
        cv.put(KEY_AMOUNT, transaksi.getAmount());
        cv.put(KEY_DEBIT_CREDIT, transaksi.getDebitCredit());
        db.insert(TB_NAME, null, cv);
        db.close();
    }

    // ... Implement other methods for retrieving transactions
    public Transaksi getTransaksi(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TB_NAME,
                new String[]{KEY_ID, KEY_DATE, KEY_AMOUNT, KEY_DEBIT_CREDIT},
                KEY_ID + "=?",
                new String[]{String.valueOf(id)},
                null, null, null, null
        );

        if (cursor != null) {
            cursor.moveToFirst();
            int transactionId = Integer.parseInt(cursor.getString(0));
            String date = cursor.getString(1);
            String amount = cursor.getString(2);
            String debitCredit = cursor.getString(3);

            return new Transaksi(transactionId, date, amount, debitCredit);
        } else {
            return null;
        }
    }

    public List<Transaksi> getAllTransaksi() {
        List<Transaksi> listTransaksi = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TB_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                int id = Integer.parseInt(cursor.getString(0));
                String date = cursor.getString(1);
                String amount = cursor.getString(2);
                String debitCredit = cursor.getString(3);

                Transaksi transaksi = new Transaksi(id, date, amount, debitCredit);
                listTransaksi.add(transaksi);
            } while (cursor.moveToNext());
        }

        return listTransaksi;
    }
}
