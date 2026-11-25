package com.haier.globalwasher.modle.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Hashtable;

/* JADX INFO: loaded from: classes2.dex */
public class w {
    public static Bitmap a(String str, int i7, int i8) {
        int i9;
        int i10;
        Hashtable hashtable = new Hashtable();
        hashtable.put(com.google.zxing.g.ERROR_CORRECTION, com.google.zxing.qrcode.decoder.f.H);
        hashtable.put(com.google.zxing.g.CHARACTER_SET, "UTF-8");
        if (i7 < 100 || i8 < 100 || i7 > 600 || i8 > 600) {
            i9 = 480;
            i10 = 480;
        } else {
            i9 = i7;
            i10 = i8;
        }
        try {
            com.google.zxing.common.b bVarB = new com.google.zxing.l().b(str, com.google.zxing.a.QR_CODE, i9, i10, hashtable);
            int iQ = bVarB.q();
            int iM = bVarB.m();
            int[] iArr = new int[iQ * iM];
            for (int i11 = 0; i11 < iM; i11++) {
                for (int i12 = 0; i12 < iQ; i12++) {
                    if (bVarB.j(i12, i11)) {
                        iArr[(i11 * iQ) + i12] = -16777216;
                    } else {
                        iArr[(i11 * iQ) + i12] = -1;
                    }
                }
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iQ, iM, Bitmap.Config.ARGB_8888);
            bitmapCreateBitmap.setPixels(iArr, 0, iQ, 0, 0, iQ, iM);
            return bitmapCreateBitmap;
        } catch (com.google.zxing.w e8) {
            e8.printStackTrace();
            return null;
        }
    }

    public static void b(Context context, Bitmap bitmap) {
        File file = new File(Environment.getExternalStorageDirectory(), "GlobalWasher_Picture");
        if (!file.exists()) {
            file.mkdir();
        }
        String str = System.currentTimeMillis() + ".png";
        File file2 = new File(file, str);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (FileNotFoundException e8) {
            i0.d(context, "保存失败");
            e8.printStackTrace();
        } catch (IOException e9) {
            i0.d(context, "保存失败");
            e9.printStackTrace();
        }
        try {
            MediaStore.Images.Media.insertImage(context.getContentResolver(), file2.getAbsolutePath(), str, (String) null);
            i0.d(context, "保存成功");
        } catch (FileNotFoundException e10) {
            i0.d(context, "保存失败");
            e10.printStackTrace();
        }
        context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new File(file2.getPath()))));
    }

    public static Bitmap c(View view) {
        view.setDrawingCacheEnabled(true);
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.buildDrawingCache();
        view.setDrawingCacheQuality(1048576);
        return view.getDrawingCache();
    }
}
