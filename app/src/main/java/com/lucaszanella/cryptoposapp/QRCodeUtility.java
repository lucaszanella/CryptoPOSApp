package com.lucaszanella.cryptoposapp;

import android.graphics.Bitmap;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

/**
 * Created by lucas on 26/07/17.
 */

/*
    Taken from here: https://github.com/kenglxn/QRGen/blob/master/android/src/main/java/net/glxn/qrgen/android/MatrixToImageWriter.java
 */

public class QRCodeUtility {
    public static final int BLACK = 0xFF000000;
    public static final int WHITE = 0xFFFFFFFF;

    public static Bitmap CustomQRCode(String text) throws Exception{
        int onColor = BLACK;
        int offColor = WHITE;
        QRCodeWriter writer = new QRCodeWriter();
        int width = 256, height = 256;
        int white = 255 << 16 | 255 << 8 | 255;
        int black = 0;
        BitMatrix bitMatrix = writer.encode(text, BarcodeFormat.QR_CODE, width, height);
        return BitMatrixToBitmap(bitMatrix, onColor, offColor);
    }

    public static Bitmap BitMatrixToBitmap(BitMatrix matrix, int onColor, int offColor) {
        final int width = matrix.getWidth();
        final int height = matrix.getHeight();
        final int[] pixels = new int[width * height];

        for (int y = 0; y < height; y++) {
            int offset = y * width;
            for (int x = 0; x < width; x++) {
                pixels[offset + x] = matrix.get(x, y) ? onColor : offColor;
            }
        }

        Bitmap image = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        image.setPixels(pixels, 0, width, 0, 0, width, height);
        return image;
    }
}
