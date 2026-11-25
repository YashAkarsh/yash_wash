package com.haier.globalwasher.modle.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import java.io.File;
import java.io.FileOutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    public static int a(BitmapFactory.Options options, int i7, int i8) {
        int i9 = options.outHeight;
        int i10 = options.outWidth;
        if (i9 <= i8 && i10 <= i7) {
            return 1;
        }
        int iRound = Math.round(i9 / i8);
        int iRound2 = Math.round(i10 / i7);
        return iRound < iRound2 ? iRound : iRound2;
    }

    public static File b(String str) {
        try {
            Bitmap bitmapC = c(str);
            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsoluteFile(), "washer_guo");
            if (!file.exists()) {
                file.mkdir();
            }
            File file2 = new File(file + "/" + System.currentTimeMillis() + ".jpg");
            File parentFile = file2.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            file2.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            if (bitmapC.compress(Bitmap.CompressFormat.JPEG, 20, fileOutputStream)) {
                fileOutputStream.flush();
                fileOutputStream.close();
            }
            file2.length();
            return file2;
        } catch (Exception e8) {
            e8.printStackTrace();
            return null;
        }
    }

    public static Bitmap c(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inSampleSize = a(options, 1080, 1920);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(str, options);
    }
}
