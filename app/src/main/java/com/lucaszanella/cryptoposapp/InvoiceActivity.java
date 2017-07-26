package com.lucaszanella.cryptoposapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import static android.R.id.message;

public class InvoiceActivity extends AppCompatActivity {
    private void text(String text, int r) {
        TextView textView = (TextView) findViewById(r);
        textView.setText(text);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice);
        Intent intent = getIntent();
        String crypto_type = intent.getStringExtra(MainActivity.CRYPTO_TYPE);
        String crypto_amount = intent.getStringExtra(MainActivity.CRYPTO_AMOUNT);
        String fiat_amount = intent.getStringExtra(MainActivity.FIAT_AMOUNT);
        String fiat_type = intent.getStringExtra(MainActivity.FIAT_TYPE);
        String equivalence = intent.getStringExtra(MainActivity.EQUIVALENCE);
        String address = intent.getStringExtra(MainActivity.ADDRESS);

        text(crypto_amount + " BTC", R.id.crypto_amount);
        text(fiat_amount, R.id.fiat_amount);
        text(equivalence, R.id.equivalence);
        String invoice = crypto_type+":"+address+"?amount="+crypto_amount;
        text(address, R.id.address);


        try {
            Bitmap qr = QRCodeUtility.CustomQRCode(invoice);
            ImageView myImage = (ImageView) findViewById(R.id.qr_image);
            myImage.setImageBitmap(qr);
        } catch (Exception e) {
            System.out.print(e);
        }
    }
}
