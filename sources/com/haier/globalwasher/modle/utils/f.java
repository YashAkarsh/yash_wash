package com.haier.globalwasher.modle.utils;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes2.dex */
public class f {
    public static void a(Context context) {
        b(context.getCacheDir());
        if (Environment.getExternalStorageState().equals("mounted")) {
            b(context.getExternalCacheDir());
        }
    }

    private static boolean b(File file) {
        if (file != null && file.isDirectory()) {
            for (String str : file.list()) {
                if (!b(new File(file, str))) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    public static long c(File file) throws Exception {
        long jC = 0;
        try {
            File[] fileArrListFiles = file.listFiles();
            for (int i7 = 0; i7 < fileArrListFiles.length; i7++) {
                jC += fileArrListFiles[i7].isDirectory() ? c(fileArrListFiles[i7]) : fileArrListFiles[i7].length();
            }
        } catch (Exception e8) {
            e8.printStackTrace();
        }
        return jC;
    }

    public static String d(double d8) {
        double d9 = d8 / 1024.0d;
        if (d9 < 1.0d) {
            return "0K";
        }
        double d10 = d9 / 1024.0d;
        if (d10 < 1.0d) {
            return new BigDecimal(Double.toString(d9)).setScale(2, 4).toPlainString() + "KB";
        }
        double d11 = d10 / 1024.0d;
        if (d11 < 1.0d) {
            return new BigDecimal(Double.toString(d10)).setScale(2, 4).toPlainString() + "MB";
        }
        double d12 = d11 / 1024.0d;
        if (d12 < 1.0d) {
            return new BigDecimal(Double.toString(d11)).setScale(2, 4).toPlainString() + "GB";
        }
        return new BigDecimal(d12).setScale(2, 4).toPlainString() + "TB";
    }

    public static long e(Context context) throws Exception {
        return c(context.getCacheDir());
    }

    public static String f(Context context) throws Exception {
        long jC = c(context.getCacheDir());
        if (Environment.getExternalStorageState().equals("mounted")) {
            jC += c(context.getExternalCacheDir());
        }
        return d(jC);
    }
}
