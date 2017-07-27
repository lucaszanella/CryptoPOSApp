package com.lucaszanella.cryptoposapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    public static final String CRYPTO_AMOUNT = "com.lucaszanella.cryptoposapp.crypto_amount";
    public static final String CRYPTO_TYPE = "com.lucaszanella.cryptoposapp.crypto_type";
    public static final String FIAT_AMOUNT = "com.lucaszanella.cryptoposapp.fiat_amount";
    public static final String FIAT_TYPE = "com.lucaszanella.cryptoposapp.fiat_type";
    public static final String EQUIVALENCE = "com.lucaszanella.cryptoposapp.equivalence";
    public static final String ADDRESS = "com.lucaszanella.cryptoposapp.address";


    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.cryptocurrencies);
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, new String[]{"foxbit", "Mercado Bitcoin", "bitfinex", "poloniex"});
        listView.setAdapter(adapter);
        Intent intent = new Intent(this, KeypadActivity.class);
        intent.putExtra(CRYPTO_AMOUNT, "0.006627");
        intent.putExtra(CRYPTO_TYPE, "bitcoin");
        intent.putExtra(FIAT_AMOUNT, "$14.75");
        intent.putExtra(FIAT_TYPE, "dollar");
        intent.putExtra(EQUIVALENCE, "1 BTC = $2467");
        intent.putExtra(ADDRESS, "3Ldyss741Bu5kUhPBUPXE7hdpdNSNn2nWG");

        startActivity(intent);
    }
}